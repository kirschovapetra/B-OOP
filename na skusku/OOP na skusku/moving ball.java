import java.awt.*;
import java.awt.geom.Ellipse2D;


//gradient
public class CustomCanvas extends Canvas {
    private Ellipse2D ball;
    public static final int BALL_RADIUS = 30;
    private int height;
    private int width;
    private int paramX = 1;
    private int paramY = 1;
    private double x = 50;
    private double y = 50;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);

        width = getWidth();
        height = getHeight();

        ball = new Ellipse2D.Double(x - BALL_RADIUS, y - BALL_RADIUS, BALL_RADIUS * 2, BALL_RADIUS * 2);
        g2.fill(ball);

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        moveBall();

    }

    public void moveBall(){

        if (ball.getCenterX()+BALL_RADIUS >=width) {
            paramX *= -1;
        }
        if (ball.getCenterY()+BALL_RADIUS >=height){
            paramY *= -1;
        }
        if (ball.getCenterX()-BALL_RADIUS <=0) {
            paramX *= -1;
        }
        if (ball.getCenterY()-BALL_RADIUS<=0){
            paramY *= -1;
        }

        x = ball.getCenterX() + paramX;
        y = ball.getCenterY() + paramY;

        repaint();


    }
}
