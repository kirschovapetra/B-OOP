package gamepackage;

public class Axe extends Weapon {
    private int damage;

    public Axe(int damage) {
        this.damage = damage;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }
}