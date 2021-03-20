import java.awt.*;

public class CustomCanvas2 extends Canvas {

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Dimension d=getSize();
        int w = d.width;
        int h = d.height;
        int smallCircleDiameter = w/10;
        int bigCircleDiameter = w/5;

        g.setColor(new Color(0,255,0));
        g.drawLine(w/2+smallCircleDiameter/2,h/2+smallCircleDiameter/2,w*3/4,h*3/4);

        g.setColor(new Color(255,255,0));
        g.fillOval(w/2,h/2,smallCircleDiameter,smallCircleDiameter);

        g.setColor(new Color(255,0,0));
        g.fillOval(w/2+smallCircleDiameter,h/2-smallCircleDiameter/2,bigCircleDiameter,bigCircleDiameter);

        g.setColor(new Color(0, 100, 255));
        g.fillOval(w/2-smallCircleDiameter*2,h/2-smallCircleDiameter/2,bigCircleDiameter,bigCircleDiameter);

        g.setColor(new Color(200, 10, 255));
        g.fillOval(w/2-smallCircleDiameter/2,h/2-smallCircleDiameter*2,bigCircleDiameter,bigCircleDiameter);

        g.setColor( new Color(255, 100, 0));
        g.fillOval(w/2-smallCircleDiameter/2,h/2+smallCircleDiameter,bigCircleDiameter,bigCircleDiameter);



    }
}
