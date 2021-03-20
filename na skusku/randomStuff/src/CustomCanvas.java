import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CustomCanvas extends Canvas {
    private Color color = Color.BLACK;
    private Color bgColor = Color.WHITE;

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int x;
        int y;
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.setBackground(bgColor);
        MyEllipse ellipse = new MyEllipse(
                new Random().nextInt(getWidth()),
                new Random().nextInt(getHeight()),
                25,25);
        MyRectangle rectangle = new MyRectangle(
                new Random().nextInt(getWidth()),
                new Random().nextInt(getHeight()),
                25,25);
        MyLine line = new MyLine(
                new Random().nextInt(getWidth()),
                new Random().nextInt(getHeight()),
                new Random().nextInt(getWidth()),
                new Random().nextInt(getHeight()));

        List<Drawable> drawable = new LinkedList<Drawable>();
        drawable.add(ellipse);drawable.add(rectangle);drawable.add(line);

        for (Drawable d: drawable){
            d.draw(g2);
        }
    }
}
