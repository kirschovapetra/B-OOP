package cv6;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

//snehuliak
public class MyCanvas3 extends Canvas{

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(3));

        int height = getHeight();
        int width = getWidth();
        double sizeSmall = height/6.0;
        double sizeMiddle = height/4.0;
        double sizeBig = height/3.0;
        double sizeHands = height/7.0;
        double sizeEyes = height/30;
        double sizeMouth = height/40;

        Point2D middlePointSmall = new Point2D.Double(width/2.0,height/5.0);
        drawCircle((Graphics2D)g,middlePointSmall,sizeSmall);

        Point2D middlePointMiddle = new Point2D.Double(middlePointSmall.getX(),
                middlePointSmall.getY()+sizeSmall/2.0+sizeMiddle/2.0);
        drawCircle((Graphics2D)g,middlePointMiddle,sizeMiddle);

        Point2D middlePointBig = new Point2D.Double(middlePointMiddle.getX(),
                middlePointMiddle.getY()+sizeMiddle/2.0+sizeBig/2.0);
        drawCircle((Graphics2D)g,middlePointBig,sizeBig);

        Point2D middlePointHand1 = new Point2D.Double(middlePointMiddle.getX()-sizeMiddle/2.0-sizeHands/2.0,
                middlePointMiddle.getY());
        drawCircle((Graphics2D)g,middlePointHand1,sizeHands);
        Point2D middlePointHand2 = new Point2D.Double(middlePointMiddle.getX()+sizeMiddle/2.0+sizeHands/2.0,
                middlePointMiddle.getY());
        drawCircle((Graphics2D)g,middlePointHand2,sizeHands);

        g2.setColor(new Color(87, 140,255));
        Point2D middlePointEye1 = new Point2D.Double(middlePointSmall.getX()-sizeSmall/5.0,middlePointSmall.getY()-sizeSmall/8.0);
        fillCircle((Graphics2D)g,middlePointEye1,sizeEyes);
        Point2D middlePointEye2 = new Point2D.Double(middlePointSmall.getX()+sizeSmall/5.0,middlePointSmall.getY()-sizeSmall/8.0);
        fillCircle((Graphics2D)g,middlePointEye2,sizeEyes);
        g2.setColor(new Color(0,0,0));

        Point2D middlePointM1 = new Point2D.Double(middlePointSmall.getX()-sizeSmall/4.0,middlePointSmall.getY()+sizeSmall/8.0);
        fillCircle((Graphics2D)g,middlePointM1,sizeMouth);
        Point2D middlePointM2 = new Point2D.Double(middlePointSmall.getX()+sizeSmall/4.0,middlePointSmall.getY()+sizeSmall/8.0);
        fillCircle((Graphics2D)g,middlePointM2,sizeMouth);
        Point2D middlePointM3 = new Point2D.Double(middlePointSmall.getX()-sizeSmall/11.0,middlePointSmall.getY()+sizeSmall/5.0);
        fillCircle((Graphics2D)g,middlePointM3,sizeMouth);
        Point2D middlePointM4 = new Point2D.Double(middlePointSmall.getX()+sizeSmall/11.0,middlePointSmall.getY()+sizeSmall/5.0);
        fillCircle((Graphics2D)g,middlePointM4,sizeMouth);

        double sizeButton = sizeEyes;
        Point2D middlePointB1 = new Point2D.Double(middlePointMiddle.getX(), middlePointMiddle.getY()-sizeMiddle/5.0);
        fillCircle((Graphics2D)g,middlePointB1,sizeButton);
        Point2D middlePointB2 = new Point2D.Double(middlePointMiddle.getX(), middlePointMiddle.getY()+sizeMiddle/5.0);
        fillCircle((Graphics2D)g,middlePointB2,sizeButton);
        Point2D middlePointB3 = new Point2D.Double(middlePointBig.getX(), middlePointBig.getY()-sizeBig/5.0);
        fillCircle((Graphics2D)g,middlePointB3,sizeButton);
        Point2D middlePointB4 = new Point2D.Double(middlePointBig.getX(), middlePointBig.getY()+sizeBig/5.0);
        fillCircle((Graphics2D)g,middlePointB4,sizeButton);




    }
    public void drawCircle(Graphics2D g2,Point2D middlePoint, double size){
        Ellipse2D e = new Ellipse2D.Double(middlePoint.getX()-size/2.0,middlePoint.getY()-size/2.0,size,size);
        g2.draw(e);
    }
    public void fillCircle(Graphics2D g2,Point2D middlePoint, double size){
        Ellipse2D e = new Ellipse2D.Double(middlePoint.getX()-size/2.0,middlePoint.getY()-size/2.0,size,size);
        g2.fill(e);
    }



}
