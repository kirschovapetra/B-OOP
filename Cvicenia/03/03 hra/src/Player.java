public class Player <T extends Weapon> {
    private String name;
    private int health;
    private T weapon;

    public Player(String n, int h, T w){

        this.name = n;
        this.health = h;
        this.weapon = w;

    }

}
