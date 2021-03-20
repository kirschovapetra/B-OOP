package cv7;

import javafx.scene.shape.Ellipse;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import static java.lang.Thread.sleep;

//gradient
public class MyCanvas4 extends Canvas {
    Ellipse ball;
    int size;
    int height;
    int width;
    int paramX = 1;
    int paramY = 1;


    public MyCanvas4() {

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        width= getWidth();
        height = getHeight();
        size =height/4;
        ball = new Ellipse(width/2,height/2,size,size);

        Color col = new Color(107, 99, 255);
        Color white = new Color(255, 255, 255);

        while (true) {
            g.setColor(col);
            g.fillOval((int) (ball.getCenterX() - size / 2), (int) (ball.getCenterY() - size / 2), size, size);

            try {
                sleep(10);
                g.setColor(white);
                g.fillRect(0, 0, width, height);
                g.setColor(col);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            moveBall();
        }
    }

    public void moveBall(){
        if (ball.getCenterX()+size/2 >=width) {
            paramX *= -1;
        }
        if (ball.getCenterY()+size/2 >=height){
            paramY *= -1;
        }
        if (ball.getCenterX()-size/2 <=0) {
            paramX *= -1;
        }
        if (ball.getCenterY()-size/2 <=0){
            paramY *= -1;
        }

        ball.setCenterX(ball.getCenterX() + paramX);
        ball.setCenterY(ball.getCenterY() + paramY);
    }
}
