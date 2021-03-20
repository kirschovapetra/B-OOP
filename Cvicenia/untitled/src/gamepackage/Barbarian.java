package gamepackage;

import java.util.Random;

public class Barbarian extends Player<Axe> {
    public Barbarian(String name, Axe weapon, int health) {
        super(name, weapon, health);
    }

    public double getDamage() {
        return getWeapon().getDamage();
    }

    public double getBlock() {
        Random rand = new Random();
        double min = 0.1;
        double max = 0.2;
        return min + (max - min) * rand.nextDouble();
    }

    public void useSkill() {
        // do something
    }
    public int ask(){
        return Zklavesnice.readInt("Chces zautocit: (0) zbranou alebo (1) 2-nasobny utok?");

    }
    public void attack(){}
}
