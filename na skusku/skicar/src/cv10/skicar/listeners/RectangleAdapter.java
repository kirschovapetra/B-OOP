package cv10.skicar.listeners;

import cv10.skicar.SkicarCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class RectangleAdapter extends MouseAdapter {
    private SkicarCanvas skicarCanvas;
    private Point startPoint;
    private Point endPoint;
    private int width = 0;
    private int height = 0;

    public RectangleAdapter(SkicarCanvas skicarCanvas) {
        super();
        this.skicarCanvas = skicarCanvas;
    }

    public SkicarCanvas getSkicarCanvas() {
        return skicarCanvas;
    }
    public void setSkicarCanvas(SkicarCanvas skicarCanvas) {
        this.skicarCanvas = skicarCanvas;
    }

    public Point getStartPoint() {
        return startPoint;
    }
    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }
    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        startPoint = new Point(e.getX(),e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        Point endPoint = new Point(e.getX(),e.getY());
        calculate(endPoint);
        skicarCanvas.rectangleMode(startPoint,width,height);

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
    }

    public void calculate(Point endPoint){
        width = Math.abs(endPoint.x-startPoint.x);
        height = Math.abs(endPoint.y-startPoint.y);

        int minX = Math.min(startPoint.x,endPoint.x);
        int minY = Math.min(startPoint.y,endPoint.y);

        startPoint.setLocation(minX,minY);

    }

}
