package sk.stuba.fei.oop.gui;

import sk.stuba.fei.oop.petrinet.Edge;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public abstract class Edge2D implements Drawable{
    private Line2D line2D;          //graficka podoba Edge
    private Edge edge;              //prislusna Edge
    private Point2D startPoint;     //zaciatocny bod
    private Point2D endPoint;       //koncovy bod
    private int weight = 1;         //nasobnost

    //konstruktory
    public Edge2D(Edge edge, Point2D startPoint, Point2D endPoint, int weight) throws IllegalArgumentException {
        if (edge == null){
            throw new IllegalArgumentException("Nespravna zadana hrana");
        }

        if (startPoint == null || endPoint == null){
            throw new IllegalArgumentException("Nespravny vstupny alebo vystupny bod");
        }

        this.edge = edge;
        this.startPoint = startPoint;
        this.endPoint = endPoint;

        if (weight<1)
            throw new IllegalArgumentException("Nasobnost hrany musi byt kladna");

        this.weight = weight;

        this.line2D = new Line2D.Double(startPoint, endPoint);

    }

    public Edge2D(Edge edge, double x1, double y1, double x2, double y2, int weight) throws IllegalArgumentException  {
        if (edge == null){
            throw new IllegalArgumentException("Nespravna zadana hrana");
        }
        this.edge = edge;

        this.startPoint = new Point2D.Double(x1,y1);
        this.endPoint = new Point2D.Double(x2,y2);

        if (weight<1)
            throw new IllegalArgumentException("Nasobnost hrany musi byt kladna");

        this.weight = weight;

        line2D = new Line2D.Double(x1,y1, x2,y2);
    }

    public Edge2D(Edge edge,Point2D startPoint, Point2D endPoint) throws IllegalArgumentException  {
        if (edge == null){
            throw new IllegalArgumentException("Nespravna zadana hrana");
        }

        if (startPoint == null || endPoint == null){
            throw new IllegalArgumentException("Nespravny vstupny alebo vystupny bod");
        }

        this.edge = edge;
        this.startPoint = startPoint;
        this.endPoint = endPoint;

        this.line2D = new Line2D.Double(startPoint, endPoint);
    }

    public Edge2D(Edge edge, double x1, double y1, double x2, double y2) throws IllegalArgumentException  {
        if (edge == null){
            throw new IllegalArgumentException("Nespravna zadana hrana");
        }
        this.edge = edge;
        this.startPoint = new Point2D.Double(x1,y1);
        this.endPoint = new Point2D.Double(x2,y2);

        line2D = new Line2D.Double(x1,y1, x2,y2);
    }

    //gettery, settery
    public Line2D getLine2D() {
        return line2D;
    }
    public Edge getEdge() {
        return edge;
    }
    public Point2D getStartPoint() {
        return startPoint;
    }
    public Point2D getEndPoint() {
        return endPoint;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) throws IllegalArgumentException{
        if (weight<1)
            throw new IllegalArgumentException("Nasobnost hrany musi byt kladna");
        this.weight = weight;
    }

    public abstract void drawElement(Graphics2D g2);
    public abstract boolean ActionAvailable(MouseEvent e);
}
