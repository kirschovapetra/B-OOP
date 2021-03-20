package sk.stuba.fei.oop.petrinet;

public class IdGenerator {
    //pri kazdom vytvoreni objektu tohoto typu sa inkrementuje id => id sa nebudu v ramci celej siete opakovat
    public static long id = 0;

    public IdGenerator() {
        id++;
    }

    public static void setId(long id) {
        IdGenerator.id = id;
    }
    public long getId() {
        return id;
    }

}
