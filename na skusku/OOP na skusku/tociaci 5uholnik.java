package cv7;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;

import static java.lang.Thread.sleep;

public class MyCanvas5 extends Canvas {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int w = getWidth();
        int h = getHeight();
        Polygon p = makePolygon();
        Point center = new Point(w/2,h/2);
        while (true) {
            g.setColor(new Color(0,0,0));
            g.drawPolygon(p);
            int[]xPoints = p.xpoints;
            int[]yPoints = p.ypoints;
            for (int i=0;i<p.npoints;i++){
                Point point = new Point(xPoints[i],yPoints[i]);
                rotateAroundCenter(point,center,15);
                p.xpoints[i] = (int)point.getX();
                p.ypoints[i] = (int)point.getY();
            }
            try {
                sleep(100);
                g.setColor(new Color(255,255,255));
                g.fillRect(0,0,getWidth(),getHeight());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
    public Polygon makePolygon(){
        int size = 50;
        int w = getWidth();
        int h = getHeight();
        Point center = new Point(w/2,h/2);
        Point point = new Point(w/2,h/2-size);

        int[] xPoints = new int[5];
        int[] yPoints = new int[5];

        double alpha = Math.toRadians(360/5);


        for (int i=0;i<5;i++) {
            xPoints[i] = (int)point.getX();
            yPoints[i] = (int)point.getY();
            rotateAroundCenter(point, center,alpha);
        }
        Polygon p = new Polygon(xPoints,yPoints,5);
        return p;
    }

    public void rotateAroundCenter(Point point, Point center,double alpha){

        double x =(point.getX() - center.getX())*Math.cos(alpha) - (point.getY() - center.getY())* Math.sin(alpha);
        double y =(point.getX() - center.getX())*Math.sin(alpha) + (point.getY() - center.getY())* Math.cos(alpha);

        point.setLocation(x+center.getX(),y+center.getY());

    }
}
