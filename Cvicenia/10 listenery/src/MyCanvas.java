import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class MyCanvas extends Canvas implements MouseListener {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

     public void drawSquareOnClick(Graphics g,MouseEvent e){
         g.drawRect(e.getX(),e.getY(),30,30);

     }

    @Override
    public void mouseClicked(MouseEvent e) {
        Graphics g = super.getGraphics();
        g.setColor(new Color(0,0,0));
        drawSquareOnClick(g,e);

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
