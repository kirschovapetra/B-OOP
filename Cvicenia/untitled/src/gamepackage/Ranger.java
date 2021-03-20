package gamepackage;

public class Ranger extends Player<Bow> {
    public Ranger(String name, Bow weapon, int health) {
        super(name, weapon, health);
    }

    public double getDamage() {
        return getWeapon().getDamage();
    }

    public double getBlock() {
        return 0;
    }

    public void useSkill() {
        // do something
    }

    public int ask(){
        return Zklavesnice.readInt("Chces zautocit: (0) zbranou alebo (1) 2-nasobne poskodenie protivnika?");

    }
    public void attack(){}
}

