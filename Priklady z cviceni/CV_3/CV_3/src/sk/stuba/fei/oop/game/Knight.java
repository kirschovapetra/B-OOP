package sk.stuba.fei.oop.game;

public class Knight extends Player<Axe> {

    @Override
    public double getDamage() {
        return getWeapon().getDmg();
    }

    @Override
    public double getBlock() {
        return Math.random();
    }

    @Override
    public void useSkill() {
        // do something
    }
}