package sk.stuba.fei.oop.shapes;

public class Triangle extends Shape {

    private int a, b, c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        return a + b + c;
    }
}