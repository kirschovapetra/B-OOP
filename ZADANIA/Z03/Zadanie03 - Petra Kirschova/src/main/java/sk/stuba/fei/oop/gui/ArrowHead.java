package sk.stuba.fei.oop.gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class ArrowHead implements Drawable{
    private int height;
    private int width;
    private Point2D topPoint;
    private Point2D leftPoint;
    private Point2D rightPoint;
    private Point2D bottomMiddlePoint;

    //konstruktor
    public ArrowHead(double startX, double startY, double endX, double endY, int width, int height){
        this.width = width;
        this.height = height;

        //rozdiel koncovych a zaciatocnych suradnic bodov
        double dx = endX - startX;
        double dy = endY - startY;

        //vzdialenost koncoveho a zaciatocneho bodu
        double dist = distance(startX,startY,endX,endY);

        //suradnice laveho a praveho vrcholu pred otocenim
        double rightX = dist - height;
        double leftX = rightX;

        double rightY = width;
        double leftY = -width;

        //uhol ciary
        double sin = dy/dist;
        double cos = dx/dist;

        //otocenie
        double newRightX = rightX*cos - rightY*sin + startX;
        double newRightY = rightX*sin + rightY*cos + startY;

        double newLeftX = leftX*cos - leftY*sin + startX;
        double newLeftY = leftX*sin + leftY*cos + startY;

        topPoint = new Point2D.Double(endX,endY);
        leftPoint = new Point2D.Double (newLeftX,newLeftY);
        rightPoint = new Point2D.Double(newRightX,newRightY);

        //bod v strede zakladne trojuholnika
        double midX=(leftPoint.getX()+ rightPoint.getX())/2.0;
        double midY =(leftPoint.getY()+ rightPoint.getY())/2.0;
        bottomMiddlePoint = new Point2D.Double(midX, midY);
    }

    //gettery
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public Point2D getTopPoint() {
        return topPoint;
    }
    public Point2D getLeftPoint() {
        return leftPoint;
    }
    public Point2D getRightPoint() {
        return rightPoint;
    }
    public Point2D getBottomMiddlePoint() {
        return bottomMiddlePoint;
    }

    //vzdialenost 2 bodov
    public double distance(double x1, double y1, double x2, double y2){
       return Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
    }

    //vykreslenie
    @Override
    public void drawElement(Graphics2D g2) {
        int[] xpoints = {(int) topPoint.getX(),(int) leftPoint.getX(), (int)(rightPoint.getX())};
        int[] ypoints = {(int) topPoint.getY(),(int) leftPoint.getY(), (int) rightPoint.getY()};
        g2.fillPolygon(xpoints,ypoints,3);
    }

    //vrati, ci sa kliklo na vrchol sipky
    @Override
    public boolean ActionAvailable(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        return intersects(leftPoint.getX(),leftPoint.getY(),rightPoint.getX(),rightPoint.getY(),
                topPoint.getX(),topPoint.getY(),x,y);

    }

    //neudeje sa nic
    @Override
    public void reactToAction(PNCanvas pnCanvas, MouseEvent e) {

    }
    @Override
    public void remove(PNCanvas pnCanvas) {

    }

    //polygon nema intersects metodu
    public boolean intersects(double x1, double y1, double x2,double y2, double x3, double y3, double x, double y){
        double A = area (x1, y1, x2, y2, x3, y3);
        double A1 = area (x, y, x2, y2, x3, y3);
        double A2 = area (x1, y1, x, y, x3, y3);
        double A3 = area (x1, y1, x2, y2, x, y);

        return (A == A1 + A2 + A3);
    }
    public double area(double x1, double y1, double x2, double y2,double x3, double y3){
        return Math.abs((x1*(y2-y3) + x2*(y3-y1)+
                x3*(y1-y2))/2.0);
    }





    @Override
    public Rectangle getBounds() {
        return null;
    }
    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }
    @Override
    public boolean contains(double x, double y) {
        return false;
    }
    @Override
    public boolean contains(Point2D p) {
        return false;
    }
    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return false;
    }
    @Override
    public boolean intersects(Rectangle2D r) {
        return false;
    }
    @Override
    public boolean contains(double x, double y, double w, double h) {
        return false;
    }
    @Override
    public boolean contains(Rectangle2D r) {
        return false;
    }
    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return null;
    }
    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return null;
    }
}
