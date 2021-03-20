package sk.stuba.fei.oop.shapes;

public class Square extends Rectangle {

    public Square(int side) {
        super(side, side);
    }

    public double getArea() {
        return Math.pow(getHeight(), 2);
    }
}