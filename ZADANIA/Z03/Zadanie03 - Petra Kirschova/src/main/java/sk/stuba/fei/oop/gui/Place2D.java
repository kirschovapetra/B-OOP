package sk.stuba.fei.oop.gui;

import sk.stuba.fei.oop.petrinet.Place;
import sk.stuba.fei.oop.petrinet.Vertex;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import java.util.LinkedList;
import java.util.List;

public class Place2D implements Drawable {
    private Ellipse2D ellipse2D;    //graficka podoba Place
    private Place place;            //prislusny Place
    private int x;                  //suradnice
    private int y;

    //konstruktor
    public Place2D(Place place, int x, int y) throws IllegalArgumentException {
        if (place == null){
            throw new IllegalArgumentException("Nespravne zadane Place");
        }
        this.ellipse2D = new Ellipse2D.Double(x,y, PNCanvas.ELEMENT_SIZE, PNCanvas.ELEMENT_SIZE);
        this.place = place;
        this.x = x;
        this.y = y;
    }

    //gettery, settery
    public Ellipse2D getEllipse2D() {
        return ellipse2D;
    }
    public void setEllipse2D(Ellipse2D ellipse2D) {
        this.ellipse2D = ellipse2D;
    }

    public Place getPlace() {
        return place;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    //vykreslenie
    public void drawElement(Graphics2D g2) {
        //biela vypln, modry obrys
        g2.setColor(new Color(255, 255, 255));
        g2.fill(ellipse2D);
        g2.setColor(new Color(0, 5, 152));
        g2.draw(ellipse2D);

        float centerX = (float)ellipse2D.getCenterX();
        float centerY = (float)ellipse2D.getCenterY();

        //nazov pod, pocet tokenov do stredu
        g2.drawString(String.valueOf(place.getTokens()),centerX-5,centerY+5);
        if (place.getName()!=null) {
            g2.drawString(place.getName(), x, y + PNCanvas.ELEMENT_SIZE + 15);
        }
    }

    //vrati, ci sa kliklo do place
    @Override
    public boolean ActionAvailable(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        return ellipse2D.contains(x,y);
    }


    //pridavanie/odoberanie tokenov
    @Override
    public void reactToAction(PNCanvas pnCanvas, MouseEvent e) {
        //lave tlacidlo = pridavaju sa tokeny
        if (e.getButton() == MouseEvent.BUTTON1) {
            place.updateTokens(1);
        }
        //prave tlacidlo = odoberaju sa tokeny
        else if (e.getButton() == MouseEvent.BUTTON3) {
            //moze vyhodit vynimku, ak sa snazime odoberat neexistujuce tokeny
            try {
                place.updateTokens(-1);
            }
            //neudeje sa nic
            catch (IllegalArgumentException exception) {
            }
        }

    }

    //mazanie z canvas
    @Override
    public void remove(PNCanvas pnCanvas) {
        long id = place.getId();
        List<Drawable> tmpPnElements = new LinkedList(pnCanvas.getPnElements()); //kopia zoznamu Drawable elementov

        //prechadza sa tmp zoznam, maze sa z povodneho
        for (Drawable currentElement: tmpPnElements){
            //ak sa najde hrana prepojena s Place, vymaze sa
            if (currentElement instanceof Edge2D) {
                long vertexStartId = ((Edge2D) currentElement).getEdge().getVertexStart().getId();
                long vertexEndId = ((Edge2D) currentElement).getEdge().getVertexEnd().getId();

                if (vertexStartId == id || vertexEndId == id) {
                    currentElement.remove(pnCanvas);
                }
            }
        }
        pnCanvas.getPetriNet().delPlace(id);
        pnCanvas.getPnElements().remove(this);
    }





    public Rectangle getBounds() {
        return null;
    }
    public Rectangle2D getBounds2D() {
        return null;
    }
    public boolean contains(double x, double y) {
        return false;
    }
    public boolean contains(Point2D p) {
        return false;
    }
    public boolean intersects(double x, double y, double w, double h) {
        return false;
    }
    public boolean intersects(Rectangle2D r) {
        return false;
    }
    public boolean contains(double x, double y, double w, double h) {
        return false;
    }
    public boolean contains(Rectangle2D r) {
        return false;
    }
    public PathIterator getPathIterator(AffineTransform at) {
        return null;
    }
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return null;
    }
}
