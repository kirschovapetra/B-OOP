package gamepackage;

public class Knight extends Player<Sword> {

    public Knight(String name, Sword weapon, int health) {
        super(name, weapon, health);
    }

    public double getDamage() {
        return getWeapon().getDamage();
    }

    public double getBlock() {
        return 0.2;
    }

    public void attack(){}

    public void useSkill() {
        // do something
    }
    public int ask(){
        return Zklavesnice.readInt("Chces zautocit: (0) zbranou alebo (1) zvysit blok?");

    }
}
