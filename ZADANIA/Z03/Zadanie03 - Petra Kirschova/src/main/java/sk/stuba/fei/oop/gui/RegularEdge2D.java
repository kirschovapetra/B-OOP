package sk.stuba.fei.oop.gui;

import sk.stuba.fei.oop.petrinet.Edge;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.*;

public class RegularEdge2D extends Edge2D {
    private ArrowHead arrowHead; //vrchol sipky

    //konstruktory
    public RegularEdge2D(Edge edge, Point2D startPoint, Point2D endPoint, int weight) throws IllegalArgumentException {
        super(edge, startPoint, endPoint, weight);
        arrowHead = new ArrowHead(super.getLine2D().getX1(),super.getLine2D().getY1(),
                super.getLine2D().getX2(),super.getLine2D().getY2(),5,10);

    }
    public RegularEdge2D(Edge edge, double x1, double y1, double x2, double y2, int weight)throws IllegalArgumentException {
        super(edge, x1, y1, x2, y2, weight);
        arrowHead = new ArrowHead(super.getLine2D().getX1(),super.getLine2D().getY1(),
                super.getLine2D().getX2(),super.getLine2D().getY2(),5,10);
    }
    public RegularEdge2D(Edge edge, Point2D startPoint, Point2D endPoint) throws IllegalArgumentException{
        super(edge, startPoint, endPoint);
        arrowHead = new ArrowHead(super.getLine2D().getX1(),super.getLine2D().getY1(),
                super.getLine2D().getX2(),super.getLine2D().getY2(),5,10);

    }
    public RegularEdge2D(Edge edge, double x1, double y1, double x2, double y2) throws IllegalArgumentException{
        super(edge, x1, y1, x2, y2);
        arrowHead = new ArrowHead(super.getLine2D().getX1(),super.getLine2D().getY1(),
                super.getLine2D().getX2(),super.getLine2D().getY2(),5,10);
    }

    //vykreslenie
    public void drawElement(Graphics2D g2) {
        g2.setColor(new Color(0,0,0));

        Line2D lineToDraw = super.getLine2D();
        g2.draw(lineToDraw);
        arrowHead.drawElement(g2);

        //suradnice stredu hrany
        float centerX = (float)lineToDraw.getBounds().getCenterX();
        float centerY = (float)lineToDraw.getBounds().getCenterY();

        //nasobnost hrany sa napise len ak je >1
        if (super.getWeight()>1){
            g2.drawString(String.valueOf(super.getWeight()),centerX,centerY);
        }
    }

    //ci sa kliklo na edge
    @Override
    public boolean ActionAvailable(MouseEvent e) {
        //bud sa kliklo na ciaru alebo na vrchol sipky
        return (super.ActionAvailable(e) || arrowHead.ActionAvailable(e));
    }

    public Rectangle getBounds() {
        return null;
    }
    public Rectangle2D getBounds2D() {
        return null;
    }
    public boolean contains(double x, double y) {
        return false;
    }
    public boolean contains(Point2D p) {
        return false;
    }
    public boolean intersects(double x, double y, double w, double h) {
        return false;
    }
    public boolean intersects(Rectangle2D r) {
        return false;
    }
    public boolean contains(double x, double y, double w, double h) {
        return false;
    }
    public boolean contains(Rectangle2D r) {
        return false;
    }
    public PathIterator getPathIterator(AffineTransform at) {
        return null;
    }
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return null;
    }
}
