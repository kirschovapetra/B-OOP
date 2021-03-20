package sk.stuba.fei.oop.cv3;

import java.util.Random;

public class Barbarian extends Player<Axe> {
    private final double MIN_BLOCK=0.1;
    private final double MAX_BLOCK=0.2;

    public Barbarian(String name, Axe weapon) {
        super(name, weapon);
        setHealth(100);
    }

    @Override
    public double getDamage() {
        return getWeapon().getDamage();
    }

    @Override
    public double getBlock() {
        Random rand = new Random();
        return MIN_BLOCK+(MAX_BLOCK-MIN_BLOCK)* rand.nextDouble();
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
