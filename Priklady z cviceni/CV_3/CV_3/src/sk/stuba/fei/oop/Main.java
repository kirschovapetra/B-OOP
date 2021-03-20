package sk.stuba.fei.oop;

import sk.stuba.fei.oop.game.Axe;
import sk.stuba.fei.oop.game.Player;
import sk.stuba.fei.oop.game.Sword;
import sk.stuba.fei.oop.shapes.*;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Shape rectangle = new Rectangle(2,3);
        Rectangle square = new Square(10);
        Shape triangle = new Triangle(1,2,3);

        AreaCalculator calculator = new AreaCalculator();
        double area = calculator.calculate(circle, rectangle, square, triangle);

        System.out.println(area);
    }
}