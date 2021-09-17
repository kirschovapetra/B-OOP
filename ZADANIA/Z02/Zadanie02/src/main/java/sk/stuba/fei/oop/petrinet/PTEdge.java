package sk.stuba.fei.oop.petrinet;

public class PTEdge extends Edge {

    //konstruktory
    public PTEdge(long id,Place placeStart, Transition transitionEnd) throws IllegalArgumentException { //nasobnost = 1
        super(id,placeStart, transitionEnd);
        //do vstupnych hran prechodu sa prida tato hrana
        getVertexEnd().addEdgeIn(this);
    }

    public PTEdge(long id,Place placeStart, Transition transitionEnd, int weight) throws IllegalArgumentException { //vlastna hodnota nasobnosti
        super(id,placeStart, transitionEnd, weight);
        //do vstupnych hran prechodu sa prida tato hrana
        getVertexEnd().addEdgeIn(this);
    }


    //getter, setter
    @Override
    public Place getVertexStart() {
        return (Place)super.getVertexStart();
    }

    @Override
    public Transition getVertexEnd() {
        return (Transition)super.getVertexEnd();
    }
}
