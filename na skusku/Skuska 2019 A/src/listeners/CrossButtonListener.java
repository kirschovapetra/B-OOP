package listeners;

import gui.Cross;
import gui.CustomCanvas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CrossButtonListener extends MouseAdapter {
    public int startX,startY;
    public int endX,endY;
    private CustomCanvas canvas;
    private Cross cross;
    private int width = 0;
    private int height = 0;

    public CrossButtonListener(CustomCanvas canvas) throws IllegalArgumentException{
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
        calculate();

        cross.setColor(canvas.getColor());
        cross.change(startX,startY,width,height);
        canvas.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        startX = e.getX();
        startY = e.getY();
        endX = e.getX();
        endY = e.getY();
        calculate();

        cross = new Cross(startX,startY,width,height,canvas.getColor());
        canvas.addDrawable(cross);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);

        endX = e.getX();
        endY = e.getY();
        calculate();

        cross.change(startX,startY,width,height);

    }

    public void calculate(){
        width = Math.abs(endX-startX);
        height = Math.abs(endY-startY);

        int minX = Math.min(startX,endX);
        int minY = Math.min(startY,endY);

        startX = minX;
        startY = minY;

    }

}
