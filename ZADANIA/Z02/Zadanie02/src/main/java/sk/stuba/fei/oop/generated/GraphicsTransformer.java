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

                //zaciatocny a koncovy bod posunuty do stredu objektov
                Point2D shiftedSourcePoint = shiftToCenter(sourcePoint);
                Point2D shiftedDestPoint = shiftToCenter(destPoint);

                //skutocny koncovy bod hrany - bod dotyku usecky (shiftedSourcePoint,shiftedDestPoint) a Transition
                Point2D finalDestPoint = findIntersection(shiftedSourcePoint, shiftedDestPoint,destPoint);

                elements.add(new ResetEdge2D(petriNet.getEdges().get(currentId),shiftedSourcePoint,finalDestPoint));
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

                    //zaciatocny a koncovy bod posunuty do stredu objektov
                    Point2D shiftedSourcePoint = shiftToCenter(sourcePoint);
                    Point2D shiftedDestPoint = shiftToCenter(destPoint);

                    //skutocny koncovy bod hrany bude bod dotyku Transition a usecky (shiftedSourcePoint,shiftedDestPoint)
                    Point2D finalDestPoint = findIntersection(shiftedSourcePoint, shiftedDestPoint,destPoint);

                    elements.add(new RegularEdge2D(petriNet.getEdges().get(currentId),shiftedSourcePoint,finalDestPoint,currentWeight));
                }

                //TP hrany: Transition -> Place
                else if (petriNet.getTransitions().containsKey(sourceId)) {//sourceId sa nachadza medzi prechodmi => TP
                    //zaciatocny Transition, koncovy Place
                    Transition sourceTransition = findGeneratedTransition(sourceId,document);
                    Place destPlace = findGeneratedPlace(destId,document);

                    //lavy horny roh zaciatocneho Transition a koncoveho Place
                    Point2D sourcePoint = new Point2D.Double(sourceTransition.x,sourceTransition.y);
                    Point2D destPoint = new Point2D.Double(destPlace.x,destPlace.y);

                    //zaciatocny a koncovy bod posunuty do stredu objektov
                    Point2D shiftedSourcePoint = shiftToCenter(sourcePoint);
                    Point2D shiftedDestPoint = shiftToCenter(destPoint);

                    //skutocny koncovy bod hrany bude bod dotyku usecky (shiftedSourcePoint,shiftedDestPoint) a Place
                    Point2D finalDestPoint = findIntersection(shiftedSourcePoint, shiftedDestPoint,destPoint);

                    elements.add(new RegularEdge2D(petriNet.getEdges().get(currentId),shiftedSourcePoint,finalDestPoint,currentWeight));
                }

            }
        }
    }

    //posun bodu do stredu objektu
    public Point2D shiftToCenter(Point2D point){
        return new Point2D.Double(point.getX()+SIZE/2,point.getY()+SIZE/2);
    }

    //najde bod prieniku usecky (sourcePoint, destPoint) a objektom s bodom laveho horneho rohu elementPoint
    public Point2D findIntersection(Point2D sourcePoint, Point2D destPoint,Point2D elementPoint){
        Point2D intersection = new Point();

        //objekt ma 4 body (topLeft = elementPoint)
        Point2D topRight = new Point2D.Double(elementPoint.getX()+SIZE,elementPoint.getY());
        Point2D bottomLeft = new Point2D.Double(elementPoint.getX(),elementPoint.getY()+SIZE);
        Point2D bottomRight = new Point2D.Double(elementPoint.getX()+SIZE,elementPoint.getY()+SIZE);

        //objekt je tvoreny(ohraniceny) 4 useckami (transition = stvorec, place = kruh, ale je v pisany do stvorca)
        Line2D topLine = new Line2D.Double(elementPoint,topRight);
        Line2D bottomLine = new Line2D.Double(bottomLeft,bottomRight);
        Line2D leftLine = new Line2D.Double(elementPoint,bottomLeft);
        Line2D rightLine = new Line2D.Double(topRight,bottomRight);

        //usecka, ktora predstavuje hranu
        Line2D edgeLine = new Line2D.Double(sourcePoint,destPoint);

        //ak hrana pretina niektoru z hranicnych useciek, najde sa na nej bod prieniku
        if (edgeLine.intersectsLine(topLine)){
            intersection = getIntersection(edgeLine,topLine);
        }
        else if(edgeLine.intersectsLine(bottomLine)){
            intersection = getIntersection(edgeLine,bottomLine);
        }
        else if (edgeLine.intersectsLine(leftLine)) {
            intersection = getIntersection(edgeLine,leftLine);
        }
        else if(edgeLine.intersectsLine(rightLine)){
            intersection = getIntersection(edgeLine,rightLine);
        }

        return intersection;
    }

    //vrati prienik 2 useciek
    public Point2D getIntersection(Line2D line1, Line2D line2){
        Point2D intersection = new Point2D.Double();

        //(x1,y1) = zaciatocny bod line1
        double x1 = line1.getX1();
        double y1 = line1.getY1();

        //(x2,y2) = koncovy bod line1
        double x2 = line1.getX2();
        double y2 = line1.getY2();

        //(x3,y3) = zaciatocny bod line2
        double x3 = line2.getX1();
        double y3 = line2.getY1();

        //(x4,y4) = koncovy bod line2
        double x4 = line2.getX2();
        double y4 = line2.getY2();

        //vzorec z wikipedie :D
        double d = (x1-x2)*(y3-y4)-(y1-y2)*(x3-x4);
        double interX = ((x1*y2-y1*x2)*(x3-x4)-(x1-x2)*(x3*y4-y3*x4))/d;
        double interY = ((x1*y2-y1*x2)*(y3-y4)-(y1-y2)*(x3*y4-y3*x4))/d;

        intersection.setLocation(interX,interY);

        return intersection;

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
