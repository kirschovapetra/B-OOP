package sk.stuba.fei.oop.shapes;

public class Circle extends Shape {

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI*Math.pow(getRadius(), 2);
    }

    public int getRadius() {
        return radius;
    }
}