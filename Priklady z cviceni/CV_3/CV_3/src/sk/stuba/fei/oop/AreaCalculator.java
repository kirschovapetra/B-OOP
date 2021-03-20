package sk.stuba.fei.oop;

import sk.stuba.fei.oop.shapes.Shape;

class AreaCalculator {

    public double calculate(Shape... shapes) {
        double area = 0;
        for (Shape shape : shapes) {
            area += shape.getArea();
        }
        return area;
    }
}