package sk.stuba.fei.oop.petrinet;

public class Place extends Vertex {
    private int tokens = 0; //defaultny pocet tokenov = 0

    //konstruktory
    public Place(long id) { //bez mena, pocet tokenov = 0
        super(id);
    }
    public Place(long id, String name) { //pocet tokenov = 0
        super(id, name);
    }
    public Place(long id, int tokens) throws IllegalArgumentException{ //bez mena
        super(id);

        if (tokens<0){
            throw new IllegalArgumentException("Pocet tokenov v mieste nesmie byt zaporny");
        }
        this.tokens = tokens;
    }
    public Place(long id, String name, int tokens) throws IllegalArgumentException {
        super(id, name);

        if (tokens<0){
            throw new IllegalArgumentException("Pocet tokenov v mieste nesmie byt zaporny");
        }
        this.tokens = tokens;
    }

    //getter, setter
    public int getTokens() {
        return tokens;
    }
    public void setTokens(int tokens) throws IllegalArgumentException{
        if (tokens<0){
            throw new IllegalArgumentException("Pocet tokenov v mieste nesmie byt zaporny");
        }
        this.tokens = tokens;
    }

    //pridanie/odobranie tokenov - podla vstupu (+/-)
    public void updateTokens(int tokens) throws IllegalArgumentException{

        //ked odcitavame, nesmieme odcitat viac, ako je pocet tokenov v mieste = zaporne znackovanie
        if (tokens<0 && Math.abs(tokens)>this.tokens){
            throw new IllegalArgumentException("Pocet tokenov v mieste nesmie byt zaporny");
        }

        this.tokens+=tokens;
    }
}

