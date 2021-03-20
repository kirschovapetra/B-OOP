import java.awt.*;
import java.awt.geom.Rectangle2D;

public class MyRectangle extends Rectangle2D.Double implements Drawable {

    public MyRectangle(double x, double y, double w, double h) {
        super(x, y, w, h);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.draw(this);
    }
}
