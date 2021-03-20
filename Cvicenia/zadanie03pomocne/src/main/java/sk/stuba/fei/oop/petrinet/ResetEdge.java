package sk.stuba.fei.oop.petrinet;

public class ResetEdge extends PTEdge {
    //reset hrana dedi od PT hrany, tym je zabezpecene aj to, ze sa neda vytvorit reset hrana z prechodu do miesta

    //konstruktor
    public ResetEdge(long id,Place placeStart, Transition transitionEnd) throws IllegalArgumentException {
        //pouzije sa konstruktor bez "weight", nasobnost hrany bude defaultna = 1
        super(id,placeStart, transitionEnd);
        //do vystupnych hran prechodu sa prida tato hrana
        getVertexEnd().addEdgeIn(this);
    }

    @Override
    public void setWeight(int weight) throws UnsupportedOperationException {
        //nasobnost je defaultne 1, ina nasobnost sa nemoze nastavit
        throw new UnsupportedOperationException("neda sa nastavit nasobnost reset hrany");
    }
}
