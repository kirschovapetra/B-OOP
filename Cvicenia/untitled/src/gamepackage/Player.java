package gamepackage;

public abstract class Player<T extends Weapon> {

    private String name;
    private T weapon;
    private int health;

    public Player(String name, T weapon, int health) {
        this.name = name;
        this.weapon = weapon;
        this.health = health;
    }

    public abstract double getDamage();
    public abstract double getBlock();
    public abstract void useSkill();

    public T getWeapon() {
        return weapon;
    }

    public void setWeapon(T weapon) {
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public abstract int ask();
    public abstract void attack();
}
