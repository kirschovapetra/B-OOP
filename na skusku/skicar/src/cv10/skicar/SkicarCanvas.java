package cv10.skicar;

import java.awt.*;
import java.awt.event.MouseListener;

public class SkicarCanvas extends Canvas{
    private Graphics g;
    private int width;
    private int height;


    public SkicarCanvas() {

    }

    @Override
    public void paint(Graphics g) {
        width = getWidth();
        height = getHeight();
        super.paint(g);

    }

    public void removeAllMouseListeners(){
        MouseListener[] listeners = getMouseListeners();
        for (MouseListener listener: listeners){
            removeMouseListener(listener);

        }
    }
    public void rectangleMode(Point startPoint,int width, int height){
       getGraphics().drawRect(startPoint.x,startPoint.y,width,height);

    }
    public void ellipseMode(Point startPoint,int width, int height){
        getGraphics().drawOval(startPoint.x,startPoint.y,width,height);
    }

    public void lineMode(Point startPoint, Point endPoint){
        getGraphics().setColor(new Color(0,0,0));
        getGraphics().drawLine(startPoint.x,startPoint.y,endPoint.x,endPoint.y);
    }

    public void reset(){
        getGraphics().setColor(new Color(255,255,255));
        getGraphics().fillRect(0,0,width,height);
        getGraphics().setColor(new Color(0,0,0));
        repaint();
    }

}
