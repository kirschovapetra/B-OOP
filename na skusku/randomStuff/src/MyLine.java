import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class MyLine extends Line2D.Double implements Drawable {

    public MyLine(Point2D p1, Point2D p2) {
        super(p1, p2);
    }

    public MyLine(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.draw(this);
    }
}
