public abstract class Edge {
    private Vertex vertex_start; //vstupny vrchol
    private Vertex vertex_end;   //vystupny vrchol
    private int weight = 1;      //nasobnost hrany, defaultna hodnota = 1

    //konstruktory
    public Edge(Vertex vertex_start, Vertex vertex_end) throws IllegalArgumentException{
        //povinne su oba vrcholy
        if (vertex_start == null || vertex_end == null){
            throw new IllegalArgumentException("Nespravny vstupny alebo vystupny vrchol");
        }

        //hrana medzi rovnakymi vrcholmi neexistuje
        if(vertex_start instanceof Place && vertex_end instanceof Place ||
                vertex_start instanceof Transition && vertex_end instanceof Transition) {

            throw new IllegalArgumentException("Neda sa vytvorit hrana medzi vrcholmi rovnakeho typu");
        }
        this.vertex_start = vertex_start;
        this.vertex_end = vertex_end;
    }

    public Edge(Vertex vertex_start, Vertex vertex_end, int weight) throws IllegalArgumentException{
        //povinne su oba vrcholy
        if (vertex_start == null || vertex_end == null){
            throw new IllegalArgumentException("Nespravny vstupny alebo vystupny vrchol");
        }

        //hrana medzi rovnakymi vrcholmi neexistuje
        if(vertex_start instanceof Place && vertex_end instanceof Place ||
                vertex_start instanceof Transition && vertex_end instanceof Transition) {

            throw new IllegalArgumentException("Neda sa vytvorit hrana medzi vrcholmi rovnakeho typu");
        }

        if (weight<1)
            throw new IllegalArgumentException("Nasobnost hrany musi byt kladna");

        this.weight = weight;
        this.vertex_start = vertex_start;
        this.vertex_end = vertex_end;
    }

    //gettery, settery
    public Vertex getVertex_start(){
        return this.vertex_start;
    }

    public Vertex getVertex_end(){
        return this.vertex_end;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) throws IllegalArgumentException {
        if (weight<1)
            throw new IllegalArgumentException("Nasobnost hrany musi byt kladna");

        this.weight = weight;
    }

}
