package sk.stuba.fei.oop.cv3;

public abstract class Player<T extends Weapon> {

    private final String name;
    private double health;
    private T weapon;

    public Player(String name, T weapon) {
        if(name == null || name.length()==0) {
            throw new IllegalArgumentException("Hrac musi mat svoje meno");
        }
        this.name = name;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public T getWeapon() {
        return weapon;
    }

    public void setWeapon(T weapon) {
        this.weapon = weapon;
    }
    public abstract double getDamage();
    public abstract double getBlock();
    public abstract void attackWithSkill(Player player);
    public abstract void attackWithWeapon(Player player);

}
