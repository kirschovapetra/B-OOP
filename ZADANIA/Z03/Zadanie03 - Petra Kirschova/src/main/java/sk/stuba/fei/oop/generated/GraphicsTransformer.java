package sk.stuba.fei.oop.generated;

import sk.stuba.fei.oop.gui.*;
import sk.stuba.fei.oop.petrinet.PetriNet;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.*;
import java.util.List;

public class GraphicsTransformer {

    private List<Drawable> elements = new LinkedList<Drawable>();   //zoznam grafickych elementov siete
    private static final int SIZE = 25;                      //pevne dana velkost objektu petriho siete


    //getter, setter
    public List<Drawable> getElements() {
        return elements;
    }
    public void setElements(List<Drawable> elements) {
        this.elements = elements;
    }

    //transformacia
    public void transform(Document document, PetriNet petriNet) {
        try {
            transformArcs(document, petriNet);
            transformPlaces(document, petriNet);
            transformTransitions(document, petriNet);
        }
        catch (IllegalArgumentException exception){
            System.out.println(exception);
        }
    }

    //transformacia miest
    public void transformPlaces(Document document, PetriNet petriNet)throws IllegalArgumentException{
        //ku kazdemu Place v Documente sa vytvori nove Place2D - uklada x,y
        // z Documentu a Place zo sk.stuba.fei.oop.petrinet
        for (Place currentGeneratedPlace : document.place) {

            long placeId = currentGeneratedPlace.getId();
            sk.stuba.fei.oop.petrinet.Place currentPetrinetPlace = petriNet.getPlaces().get(placeId);
            elements.add(new Place2D(currentPetrinetPlace,currentGeneratedPlace.x,currentGeneratedPlace.y));
        }
    }

    //transformacia prechodov
    public void transformTransitions(Document document, PetriNet petriNet) throws IllegalArgumentException{
        //ku kazdemu Transition v Documente sa vytvori nove Transition2D - uklada x,y
        // z Documentu a Transition z sk.stuba.fei.oop.petrinet
        for (Transition currentGeneratedTransition : document.transition) {

            long transitionId = currentGeneratedTransition.getId();
            sk.stuba.fei.oop.petrinet.Transition currentPetrinetTransition = petriNet.getTransitions().get(transitionId);
            elements.add(new Transition2D(currentPetrinetTransition,currentGeneratedTransition.x,currentGeneratedTransition.y));
        }
    }

    //transformacia hran
    public void transformArcs(Document document, PetriNet petriNet)throws IllegalArgumentException{
        //ku kazdej Arc v Documente sa vytvori nova Edge2D - uklada x,y
        //  Documentu a Edge z sk.stuba.fei.oop.petrinet

        for (Arc currentArc : document.arc) {

            long sourceId = currentArc.getSourceId();
            long destId = currentArc.getDestinationId();
            long currentId = currentArc.getId();
            int currentWeight = currentArc.getMultiplicity();

            //reset hrany: Place -> Transition
            if (currentArc.getType() == ArcType.RESET ) {
                //zaciatocny Place, koncovy Transition
                Place sourcePlace = findGeneratedPlace(sourceId,document);
                Transition destTransition = findGeneratedTransition(destId,document);

                //lavy horny roh zaciatocneho Place a koncoveho Transition
                Point2D sourcePoint = new Point.Double(sourcePlace.x,sourcePlace.y);
                Point2D destPoint = new Point.Double(destTransition.x,destTransition.y);

                elements.add(new ResetEdge2D(petriNet.getEdges().get(currentId),sourcePoint,destPoint));
            }

            //regular hrany
            else if (currentArc.getType() == ArcType.REGULAR ) {

                //v .xml su id jedinecne v ramci celej siete, takze podla id vieme urcit aj typ vrcholu

                //PT hrany: Place -> Transition
                if (petriNet.getPlaces().containsKey(sourceId)) { //sourceId sa nachadza medzi miestami => PT
                    //zaciatocny Place, koncovy Transition
                    Place sourcePlace = findGeneratedPlace(sourceId,document);
                    Transition destTransition = findGeneratedTransition(destId,document);

                    //lavy horny roh zaciatocneho Place a koncoveho Transition
                    Point2D sourcePoint = new Point.Double(sourcePlace.x,sourcePlace.y);
                    Point2D destPoint = new Point.Double(destTransition.x,destTransition.y);

                    elements.add(new RegularEdge2D(petriNet.getEdges().get(currentId),sourcePoint,destPoint,currentWeight));
                }

                //TP hrany: Transition -> Place
                else if (petriNet.getTransitions().containsKey(sourceId)) {//sourceId sa nachadza medzi prechodmi => TP
                    //zaciatocny Transition, koncovy Place
                    Transition sourceTransition = findGeneratedTransition(sourceId,document);
                    Place destPlace = findGeneratedPlace(destId,document);

                    //lavy horny roh zaciatocneho Transition a koncoveho Place
                    Point2D sourcePoint = new Point2D.Double(sourceTransition.x,sourceTransition.y);
                    Point2D destPoint = new Point2D.Double(destPlace.x,destPlace.y);

                    elements.add(new RegularEdge2D(petriNet.getEdges().get(currentId),sourcePoint,destPoint,currentWeight));
                }

            }
        }
    }


    //najde miesto v liste miest v Documente
    public Place findGeneratedPlace(long id,Document document){
        for (Place currentPlace: document.place){
            if (id == currentPlace.id){
                return currentPlace;
            }
        }
        return null;
    }

    //najde prechod v liste prechodov v Documente
    public Transition findGeneratedTransition(long id,Document document){
        for (Transition currentTransition: document.transition){
            if (id == currentTransition.id){
                return currentTransition;
            }
        }
        return null;
    }

}
