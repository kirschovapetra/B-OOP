package sk.stuba.fei.oop.cv3;

public class Bow extends Weapon {
    private double rateOfFire;
    private double velocity;

    public Bow(double rateOfFire, double velocity) {
        this.rateOfFire = rateOfFire;
        this.velocity = velocity;
    }

    @Override
    public double getDamage() {
        return 0;
    }

    @Override
    public String toString() {
        return "Bow{" +
                "rateOfFire=" + rateOfFire +
                ", velocity=" + velocity +
                '}';
    }
}
