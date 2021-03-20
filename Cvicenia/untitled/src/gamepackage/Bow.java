package gamepackage;

public class Bow extends Weapon {
    private int damage;

    public Bow(int damage) {
        this.damage = damage;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }
}
