package sk.stuba.fei.oop.petrinet;

public abstract class Edge {
    private Vertex vertexStart; //vstupny vrchol
    private Vertex vertexEnd;   //vystupny vrchol
    private int weight = 1;      //nasobnost hrany, defaultna hodnota = 1
    private long id;

    //konstruktory
    public Edge(long id, Vertex vertexStart, Vertex vertexEnd) throws IllegalArgumentException{
        //povinne su oba vrcholy
        if (vertexStart == null || vertexEnd == null){
            throw new IllegalArgumentException("Nespravny vstupny alebo vystupny vrchol");
        }

        //hrana medzi rovnakymi vrcholmi neexistuje
        if(vertexStart instanceof Place && vertexEnd instanceof Place ||
                vertexStart instanceof Transition && vertexEnd instanceof Transition) {

            throw new IllegalArgumentException("Neda sa vytvorit hrana medzi vrcholmi rovnakeho typu");
        }
        this.vertexStart = vertexStart;
        this.vertexEnd = vertexEnd;
        this.id = id;
    }

    public Edge(long id, Vertex vertexStart, Vertex vertexEnd, int weight) throws IllegalArgumentException{
        //povinne su oba vrcholy
        if (vertexStart == null || vertexEnd == null){
            throw new IllegalArgumentException("Nespravny vstupny alebo vystupny vrchol");
        }

        //hrana medzi rovnakymi vrcholmi neexistuje
        if(vertexStart instanceof Place && vertexEnd instanceof Place ||
                vertexStart instanceof Transition && vertexEnd instanceof Transition) {

            throw new IllegalArgumentException("Neda sa vytvorit hrana medzi vrcholmi rovnakeho typu");
        }

        if (weight<1)
            throw new IllegalArgumentException("Nasobnost hrany musi byt kladna");

        this.weight = weight;
        this.vertexStart = vertexStart;
        this.vertexEnd = vertexEnd;
        this.id = id;
    }


    //gettery, settery
    public Vertex getVertexStart(){
        return this.vertexStart;
    }

    public Vertex getVertexEnd(){
        return this.vertexEnd;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) throws IllegalArgumentException {
        if (weight<1)
            throw new IllegalArgumentException("Nasobnost hrany musi byt kladna");

        this.weight = weight;
    }

    public long getId() {
        return id;
    }
}
