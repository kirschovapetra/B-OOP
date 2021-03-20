import java.awt.*;
import java.awt.geom.Ellipse2D;

public class MyEllipse extends Ellipse2D.Double implements Drawable {

    public MyEllipse(double x, double y, double w, double h) {
        super(x, y, w, h);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.draw(this);
    }
}
