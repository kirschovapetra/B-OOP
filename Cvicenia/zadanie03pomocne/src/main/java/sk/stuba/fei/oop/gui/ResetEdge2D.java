package sk.stuba.fei.oop.gui;

import sk.stuba.fei.oop.petrinet.Edge;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.*;


public class ResetEdge2D extends Edge2D {
    private ArrowHead arrowHead1;  //vrchol sipky1
    private ArrowHead arrowHead2;  //vrchol sipky2

    //konstruktory
    public ResetEdge2D(Edge edge, Point2D startPoint, Point2D endPoint) throws IllegalArgumentException{
        super(edge, startPoint, endPoint);

        //prvy vrchol sipky klasicky
        arrowHead1 = new ArrowHead(super.getLine2D().getX1(),super.getLine2D().getY1(),super.getLine2D().getX2(),super.getLine2D().getY2(),5,10);

        //stred zakladne vrcholu sipky
        Point2D bottomMiddlePoint = arrowHead1.getBottomMiddlePoint();

        //druhy vrchol ma spic v strede zakladne vrcholu prvej sipky
        arrowHead2 = new ArrowHead(super.getLine2D().getX1(),super.getLine2D().getY1(),bottomMiddlePoint.getX(),bottomMiddlePoint.getY(),5,10);

    }
    public ResetEdge2D(Edge edge, double x1, double y1, double x2, double y2) throws IllegalArgumentException{
        super(edge, x1, y1, x2, y2);

        //prvy vrchol sipky klasicky
        arrowHead1 = new ArrowHead(super.getLine2D().getX1(),super.getLine2D().getY1(),super.getLine2D().getX2(),super.getLine2D().getY2(),5,10);

        //stred zakladne vrcholu sipky
        Point2D bottomMiddlePoint = arrowHead1.getBottomMiddlePoint();

        //druhy vrchol ma spic v strede zakladne vrcholu prvej sipky
        arrowHead2 = new ArrowHead(super.getLine2D().getX1(),super.getLine2D().getY1(),bottomMiddlePoint.getX(),bottomMiddlePoint.getY(),5,10);
    }

    //vykreslenie
    public void drawElement(Graphics2D g2) {
        g2.setColor(new Color(0,0,0));

        g2.draw(getLine2D());
        arrowHead1.drawElement(g2);
        arrowHead2.drawElement(g2);

    }
    @Override
    public boolean ActionAvailable(MouseEvent e) {
        //bud sa kliklo na ciaru alebo na niektory z vrcholov sipky
        return (super.ActionAvailable(e) || arrowHead1.ActionAvailable(e) || arrowHead2.ActionAvailable(e));
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
