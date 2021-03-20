package sk.stuba.fei.oop.petrinet;

public class IdGenerator {
    //pri kazdom vytvoreni instancie tohoto typu sa inkrementuje id => id sa nebudu opakovat v ramci celej siete
    public static int id = 0;

    public IdGenerator() {
        id++;
    }

    public int getId() {
        return id;
    }

}
