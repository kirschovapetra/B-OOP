package gamepackage;

public class Sword extends Weapon {
    private int damage;

    public Sword(int damage) {
        this.damage = damage;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }
}