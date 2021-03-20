package gui;

import java.awt.*;
import java.awt.event.MouseEvent;

public interface Drawable extends Shape {
    public void drawObject(Graphics2D g2);
    //vrati true, ak sa kliklo do objektu
    public boolean ActionAvailable(MouseEvent e);

    //co sa stane po kliknuti
    public void changeColor(Color color, MouseEvent e);
}
