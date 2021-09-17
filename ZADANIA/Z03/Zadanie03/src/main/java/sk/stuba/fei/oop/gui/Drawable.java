package sk.stuba.fei.oop.gui;

import sk.stuba.fei.oop.petrinet.Vertex;

import java.awt.*;
import java.awt.event.MouseEvent;

public interface Drawable extends Shape {
    //vykreslenie elementu
    public void drawElement(Graphics2D g2);

    //vymazanie elementu
    public void remove(PNCanvas pnCanvas);

    //vrati true, ak sa kliklo do objektu
    public boolean ActionAvailable(MouseEvent e);

    //co sa stane po kliknuti
    public void reactToAction(PNCanvas pnCanvas,MouseEvent e);
}
