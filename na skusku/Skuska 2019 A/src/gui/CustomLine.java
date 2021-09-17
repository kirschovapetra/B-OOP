package gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.*;

public class CustomLine extends Line2D.Double implements Drawable{
    private Color color = Color.BLACK; //defaultne je nastavena cierna farba

    public CustomLine(Color color) {
        this.color = color;
    }

    public CustomLine(double x1, double y1, double x2, double y2, Color color) {
        super(x1, y1, x2, y2);
        this.color = color;
    }

    public CustomLine(Point2D p1, Point2D p2, Color color) {
        super(p1, p2);
        this.color = color;
    }

    @Override
    public void drawObject(Graphics2D g2) {
        g2.setColor(color);
        g2.drawLine((int)this.getX1(),(int)this.getX2(),(int)this.getY1(),(int)this.getY2());
    }

    @Override
    public boolean ActionAvailable(MouseEvent e){
        //okolo kliku mysou sa vytvori stvorec
        int rectSize = 5;
        Rectangle2D rect = new Rectangle2D.Double(e.getX()-rectSize/2.0,e.getY()-rectSize/2.0,rectSize,rectSize);

        //ci pretina stvorec ciaru
        return rect.intersectsLine(new Line2D.Double((int)this.getX1(),(int)this.getX2(),(int)this.getY1(),(int)this.getY2()));
    }

    @Override
    public void changeColor(Color color, MouseEvent e) {
        setColor(color);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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
