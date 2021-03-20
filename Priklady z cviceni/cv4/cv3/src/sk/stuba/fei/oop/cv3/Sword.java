package sk.stuba.fei.oop.cv3;

public class Sword extends Weapon {
    private double length;
    private double sharpness;

    public Sword(double length, double sharpness) {
        this.length = length;
        this.sharpness = sharpness;
    }

    @Override
    public double getDamage() {
        return length*sharpness;
    }

    @Override
    public String toString() {
        return "Sword{" +
                "length=" + length +
                ", sharpness=" + sharpness +
                '}';
    }
}
