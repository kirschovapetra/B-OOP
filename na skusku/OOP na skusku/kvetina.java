package cv6;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

//kvetina
public class MyCanvas2 extends Canvas {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;

        int height = getHeight();
        int width = getWidth();
        double sizeBig = height/5.0;
        double sizeSmall = height/10.0-5.0;


        Line2D line = new Line2D.Double(width/2,height/2,width/2+80,height/2+80);
        g.setColor(new Color(0,255,0));
        g2.setStroke(new BasicStroke(5));
        g2.draw(line);
        g2.setStroke(new BasicStroke(1));

        Point2D middleY = new Point2D.Double(width/2,height/2);
        Ellipse2D ellipseY = new Ellipse2D.Double(middleY.getX()-sizeSmall/2.0,middleY.getY()-sizeSmall/2.0,sizeSmall,sizeSmall);
        g.setColor(new Color(225, 225, 0));
        g2.fill(ellipseY);


        Point2D middleP = new Point2D.Double(middleY.getX(),middleY.getY()-sizeSmall/2.0-sizeBig/2.0);
        Ellipse2D ellipseP = new Ellipse2D.Double(middleP.getX()-sizeBig/2.0,middleP.getY()-sizeBig/2.0,sizeBig,sizeBig);
        g.setColor(new Color(120, 0, 225));
        g2.fill(ellipseP);

        Point2D middleO = new Point2D.Double(middleY.getX(),middleY.getY()+sizeSmall/2.0+sizeBig/2.0);
        Ellipse2D ellipseO = new Ellipse2D.Double(middleO.getX()-sizeBig/2.0,middleO.getY()-sizeBig/2.0,sizeBig,sizeBig);
        g.setColor(new Color(255, 118, 15));
        g2.fill(ellipseO);

        Point2D middleB = new Point2D.Double(middleY.getX()-sizeSmall/2.0-sizeBig/2.0,middleY.getY());
        Ellipse2D ellipseB = new Ellipse2D.Double(middleB.getX()-sizeBig/2.0,middleB.getY()-sizeBig/2.0,sizeBig,sizeBig);
        g.setColor(new Color(0, 0, 255));
        g2.fill(ellipseB);

        Point2D middleR = new Point2D.Double(middleY.getX()+sizeSmall/2.0+sizeBig/2.0,middleY.getY());
        Ellipse2D ellipseR = new Ellipse2D.Double(middleR.getX()-sizeBig/2.0,middleR.getY()-sizeBig/2.0,sizeBig,sizeBig);
        g.setColor(new Color(255, 0, 0));
        g2.fill(ellipseR);

    }
}
