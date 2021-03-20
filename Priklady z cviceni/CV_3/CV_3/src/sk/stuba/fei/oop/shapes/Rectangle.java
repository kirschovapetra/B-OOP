package sk.stuba.fei.oop.shapes;

public class Rectangle extends Shape {

    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return getHeight()*getWidth();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        if (width <= 0)
            throw new IllegalArgumentException("");
        this.width = width;
    }

    public void setHeight(int height) {
        if (height <= 0)
            throw new IllegalArgumentException("");
        this.height = height;
    }
}