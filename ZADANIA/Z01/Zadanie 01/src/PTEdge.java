public class PTEdge extends Edge {

    //konstruktory
    public PTEdge(Place place_start, Transition transition_end) throws IllegalArgumentException { //nasobnost = 1
        super(place_start, transition_end);
    }

    public PTEdge(Place place_start, Transition transition_end, int weight) throws IllegalArgumentException { //vlastna hodnota nasobnosti
        super(place_start, transition_end, weight);
    }

    //getter, setter
    @Override
    public Place getVertex_start() {
        return (Place)super.getVertex_start();
    }

    @Override
    public Transition getVertex_end() {
        return (Transition)super.getVertex_end();
    }
}
