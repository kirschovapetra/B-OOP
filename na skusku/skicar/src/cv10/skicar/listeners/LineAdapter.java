package cv10.skicar.listeners;

import cv10.skicar.SkicarCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LineAdapter extends MouseAdapter {
    private SkicarCanvas skicarCanvas;
    private Point startPoint;
    private Point endPoint;
    private int size = 15;
    private boolean drawing = false;

    public LineAdapter(SkicarCanvas skicarCanvas) {
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
        drawing = true;
        startPoint = e.getPoint();
        shift(startPoint);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        endPoint = e.getPoint();
        shift(endPoint);
        skicarCanvas.lineMode(startPoint,endPoint);
    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    public void shift(Point point){
        int x = point.x-size/2;
        int y = point.y-size/2;

        point.setLocation(x,y);
    }


}
