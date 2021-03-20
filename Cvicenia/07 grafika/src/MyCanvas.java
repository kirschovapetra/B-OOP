

import javax.sound.sampled.Line;
import java.awt.*;
import java.awt.geom.Line2D;

import static java.lang.Math.*;


public class MyCanvas extends Canvas {

    public Polygon makePentagon(int x1,int y1,int x_cent, int y_cent){
        Polygon penta = new Polygon();
        int a = 30;
        double alpha = toRadians(72);
        penta.addPoint(x1,y1);

        int x2 = (int) ((x1-x_cent)*Math.cos(alpha)-(y1-y_cent)*Math.sin(alpha)+x_cent);
        int y2 = (int) ((x1-x_cent)*Math.sin(alpha)+(y1-y_cent)*Math.cos(alpha)+y_cent);
        penta.addPoint(x2,y2);

        int x3 = (int) ((x2-x_cent)*Math.cos(alpha)-(y2-y_cent)*Math.sin(alpha)+x_cent);
        int y3 = (int) ((x2-x_cent)*Math.sin(alpha)+(y2-y_cent)*Math.cos(alpha)+y_cent);
        penta.addPoint(x3,y3);

        int x4 = (int) ((x3-x_cent)*Math.cos(alpha)-(y3-y_cent)*Math.sin(alpha)+x_cent);
        int y4 = (int) ((x3-x_cent)*Math.sin(alpha)+(y3-y_cent)*Math.cos(alpha)+y_cent);
        penta.addPoint(x4,y4);

        int x5 = (int) ((x4-x_cent)*Math.cos(alpha)-(y4-y_cent)*Math.sin(alpha)+x_cent);
        int y5 = (int) ((x4-x_cent)*Math.sin(alpha)+(y4-y_cent)*Math.cos(alpha)+y_cent);
        penta.addPoint(x5,y5);

        return penta;
    }
    void rotatePolygon(Polygon p, int x_cent, int y_cent, double alpha){
        int[] Xnew = new int[5];
        int[] Ynew = new int[5];

        Xnew[0] = (int) ((p.xpoints[p.npoints-1]-x_cent)*Math.cos(alpha)-(p.ypoints[p.npoints-1]-y_cent)*Math.sin(alpha)+x_cent);
        Ynew[0] = (int) ((p.xpoints[p.npoints-1]-x_cent)*Math.sin(alpha)+(p.ypoints[p.npoints-1]-y_cent)*Math.cos(alpha)+y_cent);
        for (int i=1;i<p.npoints;i++){
            Xnew[i] = (int) ((p.xpoints[i-1]-x_cent)*Math.cos(alpha)-(p.ypoints[i-1]-y_cent)*Math.sin(alpha)+x_cent);
            Ynew[i] = (int) ((p.xpoints[i-1]-x_cent)*Math.sin(alpha)+(p.ypoints[i-1]-y_cent)*Math.cos(alpha)+y_cent);
        }

        p.xpoints = Xnew;
        p.ypoints = Ynew;
    }
    void rotateLine(Line2D line,int x_cent, int y_cent, double alpha){
        int xnew = (int) ((line.getX1()-x_cent)*Math.cos(alpha)-(line.getY1()-y_cent)*Math.sin(alpha)+x_cent);
        int ynew = (int) ((line.getX1()-x_cent)*Math.sin(alpha)+(line.getY1()-y_cent)*Math.cos(alpha)+y_cent);

        line.setLine(xnew,ynew,x_cent,y_cent);
    }

    double dist(int x1,int y1, int x2, int y2){
        return sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }
    public void paint(Graphics g) {
        super.paint(g);
        //drawPentagon(g);

        g.setColor(new Color(255,0,0));

        Graphics2D g2;
        g2 = (Graphics2D) g;

        int x1 = 250,y1 = 250,x_cent = 180,y_cent =250;




        Polygon penta = makePentagon(x1,y1,x_cent,y_cent);
        while(true) {
            g.drawPolygon(penta);
            rotatePolygon(penta, x_cent, y_cent, 36);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            g.clearRect(0,0,getWidth(),getHeight());
        }
    }

}
