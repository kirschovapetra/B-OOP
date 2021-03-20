package sk.stuba.fei.oop.cv3;

public class Ranger extends Player<Bow> {

    public Ranger(String name, Bow weapon) {
        super(name, weapon);
        setHealth(100);
    }

    @Override
    public double getDamage() {
        return 0;
    }

    @Override
    public double getBlock() {
        return 0;
    }

    @Override
    public void attackWithSkill(Player player) {

    }

    @Override
    public void attackWithWeapon(Player player) {

    }
}
