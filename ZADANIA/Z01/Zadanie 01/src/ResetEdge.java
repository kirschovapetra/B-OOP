public class ResetEdge extends PTEdge {
    //reset hrana dedi od PT hrany, tym je zabezpecene aj to, ze sa neda vytvorit reset hrana z prechodu do miesta

    //konstruktor
    public ResetEdge(Place place_start, Transition transition_end) throws IllegalArgumentException {
        //pouzije sa konstruktor bez "weight", nasobnost hrany bude defaultna = 1
        super(place_start, transition_end);
    }

    @Override
    public void setWeight(int weight) throws UnsupportedOperationException {
        //nasobnost je defaultne 1, ina nasobnost sa nemoze nastavit
        throw new UnsupportedOperationException("neda sa nastavit nasobnost reset hrany");
    }
}
