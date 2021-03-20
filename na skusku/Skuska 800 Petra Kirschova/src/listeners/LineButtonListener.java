package listeners;

import gui.CustomCanvas;
import gui.CustomLine;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LineButtonListener extends MouseAdapter {
    private int startX,startY;
    private int endX,endY;
    private CustomCanvas canvas;
    private CustomLine line;

    public LineButtonListener(CustomCanvas canvas) throws IllegalArgumentException{
        if (canvas==null)
            throw new IllegalArgumentException("treba zadat canvas");
        this.canvas = canvas;
    }

    public CustomCanvas getCanvas() {
        return canvas;
    }

    public void setCanvas(CustomCanvas canvas) {
        this.canvas = canvas;
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        endX = e.getX();
        endY = e.getY();
        line.setColor(canvas.getColor());

        line.setLine(startX,endX,startY,endY);
        canvas.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        startX = e.getX();
        startY = e.getY();
        endX = startX;
        endY = startY;

        line = new CustomLine(startX,startY,endX,endY,canvas.getColor());
        canvas.addDrawable(line);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        endX = e.getX();
        endY = e.getY();

        line.setLine(startX,endX,startY,endY);


    }
}
