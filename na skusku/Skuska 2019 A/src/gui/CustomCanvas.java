package gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CustomCanvas extends Canvas {
    private Color color = Color.BLACK;
    private List<Drawable> drawableShapes = new LinkedList<Drawable>();
    private MouseEvent click;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Drawable drawable: drawableShapes){
            drawable.drawObject((Graphics2D) g);
        }
    }

    public void removeAllMouseListeners() {
        MouseListener[] mouseListeners = getMouseListeners();
        MouseMotionListener[] motionListeners = getMouseMotionListeners();
        for (MouseListener mouseListener: mouseListeners){
            removeMouseListener(mouseListener);
        }
        for (MouseMotionListener motionListener: motionListeners){
            removeMouseMotionListener(motionListener);
        }
    }

    public void addDrawable(Drawable drawable){
        drawableShapes.add(drawable);
    }

    public void action(MouseEvent e){
        Collections.reverse(drawableShapes);
        for (Drawable drawable : drawableShapes) {
            if (drawable.ActionAvailable(e)) {
                drawable.changeColor(color,e);
                repaint();
                break; //aby sa vykonala len 1 akcia
            }
        }
        Collections.reverse(drawableShapes);
    }
}

