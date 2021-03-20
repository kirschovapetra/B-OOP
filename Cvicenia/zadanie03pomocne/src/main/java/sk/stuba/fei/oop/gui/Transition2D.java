package sk.stuba.fei.oop.gui;
import sk.stuba.fei.oop.petrinet.Transition;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


public class Transition2D implements Drawable {
    private Rectangle2D rectangle2D;        //graficka podoba prechodu
    private Transition transition;          //prislusny prechod
    private int x;                          //suradnice
    private int y;


    //konstruktor
    public Transition2D(Transition transition,int x, int y) throws IllegalArgumentException{
        if (transition == null){
            throw new IllegalArgumentException("Nespravny zadany Transition");
        }
        this.rectangle2D = new Rectangle2D.Double(x,y, PNCanvas.ELEMENT_SIZE, PNCanvas.ELEMENT_SIZE);
        this.transition = transition;
        this.x = x;
        this.y = y;
    }

    //gettery, settery
    public Rectangle2D getRectangle2D() {
        return rectangle2D;
    }
    public void setRectangle2D(Rectangle2D rectangle2D) {
        this.rectangle2D = rectangle2D;
    }
    public Transition getTransition() {
        return transition;
    }
    public void setTransition(Transition transition) {
        this.transition = transition;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    //vykreslenie
    public void drawElement(Graphics2D g2) {
        //biela vypln
        g2.setColor(new Color(255,255,255));
        g2.fill(rectangle2D);

        //spustitelny prechod - zeleny
        if (transition.isFirable()){
            g2.setColor(new Color(31, 191,0));
        }
        //nespustitelny prechod - cerveny
        else{
            g2.setColor(new Color(163, 32,0));
        }
        g2.draw(rectangle2D);

        //nazov prechodu
        if (transition.getName()!=null) {
            g2.drawString(transition.getName(), x, y + PNCanvas.ELEMENT_SIZE + 15);
        }
    }


    //vrati, ci sa kliklo do transition
    public boolean ActionAvailable(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        return rectangle2D.contains(x,y);
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
