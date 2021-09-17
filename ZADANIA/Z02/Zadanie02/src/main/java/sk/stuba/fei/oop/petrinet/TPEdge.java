package sk.stuba.fei.oop.petrinet;

public class TPEdge extends Edge {

    //konstruktory
    public TPEdge(long id, Transition transitionStart, Place placeEnd) throws IllegalArgumentException { //nasobnost je 1
        super(id,transitionStart, placeEnd);
        //do vystupnych hran prechodu sa prida tato hrana
        getVertexStart().addEdgeOut(this);
    }

    public TPEdge(long id,Transition transitionStart, Place placeEnd, int weight) throws IllegalArgumentException { //vlastna hodnota nasobnosti
        super(id,transitionStart, placeEnd, weight);
        //do vystupnych hran prechodu sa prida tato hrana
        getVertexStart().addEdgeOut(this);
    }


    //getter, setter
    @Override
    public Transition getVertexStart() {
        return (Transition)super.getVertexStart();
    }

    @Override
    public Place getVertexEnd() {
        return (Place)super.getVertexEnd();
    }
}
