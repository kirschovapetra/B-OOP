package gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import java.util.List;

public class Cross implements Drawable {
    private Color color = Color.BLACK; //default cierna
    private List<Rectangle2D> squares;
    private Rectangle2D squareOutline;
    private int startX,startY;
    private int width,height;
    private int rectSize;

    public Cross(int startX, int startY, int width, int height, Color color) {
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;
        this.color = color;
        squareOutline = new Rectangle2D.Double(startX,startY,width,height);
        rectSize = width/3;

        squares = new LinkedList<Rectangle2D>();
        squares.add(new Rectangle2D.Double(startX+rectSize,startY,rectSize,rectSize));
        squares.add(new Rectangle2D.Double(startX,startY+rectSize,rectSize,rectSize));
        squares.add(new Rectangle2D.Double(startX+2*rectSize,startY+rectSize,rectSize,rectSize));
        squares.add(new Rectangle2D.Double(startX+rectSize,startY+rectSize,rectSize,rectSize));
        squares.add(new Rectangle2D.Double(startX+rectSize,startY+2*rectSize,rectSize,rectSize));

    }
    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRectSize() {
        return rectSize;
    }

    public void setRectSize(int rectSize) {
        this.rectSize = rectSize;
    }


    @Override
    public void drawObject(Graphics2D g2) {
        g2.setColor(color);

        for (Rectangle2D square: squares){
            g2.fill(square);
        }
    }

    @Override
    public boolean ActionAvailable(MouseEvent e) {
        for (Rectangle2D square: squares){
            if(square.contains(e.getX(),e.getY())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void changeColor(Color color, MouseEvent e) {
        setColor(color);
    }
    public void change(int startX, int startY, int width, int height) {
        setStartX(startX);
        setStartY(startY);
        setWidth(width);
        setHeight(height);

        squareOutline.setRect(startX,startY,width,height);
        rectSize = width/3;

        squares.get(0).setRect(startX+rectSize,startY,rectSize,rectSize);
        squares.get(1).setRect(startX,startY+rectSize,rectSize,rectSize);
        squares.get(2).setRect(startX+2*rectSize,startY+rectSize,rectSize,rectSize);
        squares.get(3).setRect(startX+rectSize,startY+rectSize,rectSize,rectSize);
        squares.get(4).setRect(startX+rectSize,startY+2*rectSize,rectSize,rectSize);
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
