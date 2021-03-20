package sk.stuba.fei.oop.cv3;

public class Knight extends Player<Sword> {

    public Knight(String name, Sword weapon) {
        super(name, weapon);
        setHealth(100);
    }

    @Override
    public double getDamage() {
        return getWeapon().getDamage();
    }

    @Override
    public double getBlock() {
        return 0.2;
    }

    @Override
    public void attackWithSkill(Player player) {

    }

    @Override
    public void attackWithWeapon(Player player) {
        double health;
        health = player.getHealth();
        health = health - (getDamage() * (1 - player.getBlock()));
        player.setHealth(health);
    }
}
