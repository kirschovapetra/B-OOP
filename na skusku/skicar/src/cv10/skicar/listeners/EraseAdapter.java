package cv10.skicar.listeners;

import cv10.skicar.SkicarCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EraseAdapter extends MouseAdapter {
    private SkicarCanvas skicarCanvas;

    public EraseAdapter(SkicarCanvas skicarCanvas) {
        super();
        this.skicarCanvas = skicarCanvas;
    }

    public SkicarCanvas getSkicarCanvas() {
        return skicarCanvas;
    }
    public void setSkicarCanvas(SkicarCanvas skicarCanvas) {
        this.skicarCanvas = skicarCanvas;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        /*(skicarCanvas.getGraphics()).setColor(new Color(255,255,255));
        skicarCanvas.rectangleMode(new Point(0,0),skicarCanvas.getWidth(),skicarCanvas.getHeight());
        (skicarCanvas.getGraphics()).setColor(new Color(0,0,0));*/
    }
}
