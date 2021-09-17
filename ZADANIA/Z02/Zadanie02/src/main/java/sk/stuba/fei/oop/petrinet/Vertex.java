package sk.stuba.fei.oop.petrinet;

public abstract class Vertex { //vrchol petriho siete
    private long id;
    private String name;


    //konstruktory - id potrebne zadat vzdy
    public Vertex(long id) {
        this.id = id;
    }

    public Vertex(long id, String name) {
        this.id = id;
        this.name = name;
    }

    //gettery, settery
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
