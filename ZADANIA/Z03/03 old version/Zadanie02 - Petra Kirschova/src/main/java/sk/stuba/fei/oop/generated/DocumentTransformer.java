package sk.stuba.fei.oop.generated;

import sk.stuba.fei.oop.gui.Drawable;
import sk.stuba.fei.oop.gui.Place2D;
import sk.stuba.fei.oop.gui.Transition2D;
import sk.stuba.fei.oop.petrinet.*;
import sk.stuba.fei.oop.petrinet.Place;
import sk.stuba.fei.oop.petrinet.Transition;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class DocumentTransformer {
    private Document document;

    public DocumentTransformer() {
        document = new Document();
        document.transition = new ArrayList<sk.stuba.fei.oop.generated.Transition>();
        document.place = new ArrayList<sk.stuba.fei.oop.generated.Place>();
        document.arc = new ArrayList<sk.stuba.fei.oop.generated.Arc>();
    }

    public Document getDocument() {
        return document;
    }

    public void transform(List<Drawable> elements, PetriNet petriNet){
        transformPlaces(elements,petriNet);
        transformTransitions(elements,petriNet);
        transformArcs(elements,petriNet);
    }

    public void transformPlaces(List<Drawable> elements, PetriNet petriNet){
        for (Place currentPlace: petriNet.getPlaces().values()){
            //lavy horny roh Place
            Point2D point2D = new Point2D.Double();
            try {
                point2D = findPoint(elements, currentPlace.getId());
            }
            catch(IllegalArgumentException exception){
                System.out.println(exception);
            }
            //generovane Place
            sk.stuba.fei.oop.generated.Place generatedPlace = new sk.stuba.fei.oop.generated.Place();

            //nastavenie parametrov
            generatedPlace.setId((int)currentPlace.getId());
            generatedPlace.setLabel(currentPlace.getName());
            generatedPlace.setTokens(currentPlace.getTokens());
            generatedPlace.setX((int) point2D.getX());
            generatedPlace.setY((int) point2D.getY());

            document.place.add(generatedPlace);
        }
    }

    public void transformTransitions(List<Drawable> elements, PetriNet petriNet){
        for (Transition currentTransition: petriNet.getTransitions().values()){
            //lavy horny roh Transition
            Point2D point2D = new Point2D.Double();
            try {
                point2D = findPoint(elements, currentTransition.getId());
            }
            catch(IllegalArgumentException exception){
                System.out.println(exception);
            }

            //generovany Transition
            sk.stuba.fei.oop.generated.Transition generatedTransition = new sk.stuba.fei.oop.generated.Transition();

            //nastavenie parametrov
            generatedTransition.setId((int)currentTransition.getId());
            generatedTransition.setLabel(currentTransition.getName());
            generatedTransition.setX((int) point2D.getX());
            generatedTransition.setY((int) point2D.getY());

            document.transition.add(generatedTransition);
        }
    }

    public void transformArcs(List<Drawable> elements, PetriNet petriNet){
        for (Edge currentEdge: petriNet.getEdges().values()){
            //zaciatocny,koncovy vrchol
            Vertex source = currentEdge.getVertexStart();
            Vertex dest = currentEdge.getVertexEnd();
            //generovana Arc
            sk.stuba.fei.oop.generated.Arc generatedArc = new sk.stuba.fei.oop.generated.Arc();

            //nastavenie parametrov
            generatedArc.setId((int)currentEdge.getId());
            generatedArc.setSourceId((int)source.getId());
            generatedArc.setDestinationId((int)dest.getId());
            generatedArc.setMultiplicity(currentEdge.getWeight());
            if (currentEdge instanceof ResetEdge){
                generatedArc.setType(ArcType.RESET);
            }
            else if(currentEdge instanceof PTEdge || currentEdge instanceof TPEdge){
                generatedArc.setType(ArcType.REGULAR);
            }
            document.arc.add(generatedArc);
        }
    }

    //vrati bod hladaneho objektu v zozname elements
    public Point2D findPoint(List<Drawable> elements, long id) throws IllegalArgumentException{

        for (Drawable currentElement: elements){

            if (currentElement instanceof Place2D){
                if (((Place2D)currentElement).getPlace().getId() == id){
                    return new Point2D.Double(((Place2D) currentElement).getX(),((Place2D) currentElement).getY());
                }
            }

            if (currentElement instanceof Transition2D) {
                if (((Transition2D) currentElement).getTransition().getId() == id) {
                    return new Point2D.Double(((Transition2D) currentElement).getX(), ((Transition2D) currentElement).getY());
                }
            }
        }
        //nenasiel - exception
        throw new IllegalArgumentException("Nenasiel sa objekt s id = "+id);
    }
    public void clear(){
        document.arc.clear();
        document.place.clear();
        document.transition.clear();
    }
}
