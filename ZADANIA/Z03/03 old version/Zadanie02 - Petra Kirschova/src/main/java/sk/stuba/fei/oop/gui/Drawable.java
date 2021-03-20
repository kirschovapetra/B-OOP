package sk.stuba.fei.oop.gui;

import java.awt.*;
import java.awt.event.MouseEvent;

public interface Drawable extends Shape {
    //vykreslenie elementu
    public void drawElement(Graphics2D g2);

    //vrati true, ak sa ma nieco stat po kliknuti na dany objekt
    public boolean ActionAvailable(MouseEvent e);


}
