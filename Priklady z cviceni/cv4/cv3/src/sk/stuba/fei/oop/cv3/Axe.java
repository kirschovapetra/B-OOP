package sk.stuba.fei.oop.cv3;

public class Axe extends Weapon{
    private double weight;
    private boolean isDoubleBlade;

    public Axe(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isDoubleBlade() {
        return isDoubleBlade;
    }

    public void setDoubleBlade(boolean doubleBlade) {
        isDoubleBlade = doubleBlade;
    }

    @Override
    public double getDamage() {
        if(isDoubleBlade){
            return weight*2;
        }
        else{
            return weight;
        }
    }

    @Override
    public String toString() {
        return "Axe{" +
                "weight=" + weight +
                ", isDoubleBlade=" + isDoubleBlade +
                '}';
    }
}
