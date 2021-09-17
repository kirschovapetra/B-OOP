public class TPEdge extends Edge {

    //konstruktory
    public TPEdge(Transition transition_start, Place place_end) throws IllegalArgumentException { //nasobnost je 1
        super(transition_start, place_end);
    }

    public TPEdge(Transition transition_start, Place place_end, int weight) throws IllegalArgumentException { //vlastna hodnota nasobnosti
        super(transition_start, place_end, weight);
    }

    //getter, setter
    @Override
    public Transition getVertex_start() {
        return (Transition)super.getVertex_start();
    }

    @Override
    public Place getVertex_end() {
        return (Place)super.getVertex_end();
    }
}
