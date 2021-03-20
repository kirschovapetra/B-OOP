package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseDraggedListener extends MouseAdapter {
    public int startX,startY;
    public int endX,endY;
    public CustomCanvas canvas;

    public MyMouseDraggedListener(CustomCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mousePressed(MouseEvent evt) {
        startX = evt.getX();
        startY = evt.getY();
        System.out.println("(" + startX + "," + startY + ")");
    }
    @Override
    public void mouseDragged(MouseEvent evt) {
        endX = evt.getX();
        endY = evt.getY();
        System.out.println("(" + endX + "," + endY + ")");
        canvas.repaint();
    }
    @Override
    public void mouseReleased(MouseEvent evt) {
        endX = evt.getX();
        endY = evt.getY();
        System.out.println("(" + endX + "," + endY + ")");
        canvas.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent evt) {
        int x = evt.getX();
        int y = evt.getY();
        System.out.println("(" + x + "," + y + ")");
    }
}