package sk.stuba.fei.oop.gui;

import sk.stuba.fei.oop.petrinet.Edge;
import sk.stuba.fei.oop.petrinet.Vertex;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public abstract class Edge2D implements Drawable{
    private Line2D line2D;          //graficka podoba Edge
    private Edge edge;              //prislusna Edge
    private Point2D startPoint;     //zaciatocny bod
    private Point2D endPoint;       //koncovy bod
    private int weight = 1;         //nasobnost

    //konstruktory
    public Edge2D(Edge edge, Point2D startPoint, Point2D endPoint, int weight) throws IllegalArgumentException {
        if (edge == null){
            throw new IllegalArgumentException("Nespravna zadana hrana");
        }

        if (startPoint == null || endPoint == null){
            throw new IllegalArgumentException("Nespravny vstupny alebo vystupny bod");
        }

        //zaciatocny a koncovy bod posunuty do stredu objektov
        Point2D shiftedStartPoint = shiftToCenter(startPoint);
        Point2D shiftedEndPoint = shiftToCenter(endPoint);

        //skutocny zaciatocny a koncovy bod hrany bude bod dotyku hrany s Place/Transition
        Point2D finalStartPoint = findLineCircleIntersection(shiftedEndPoint, shiftedStartPoint, shiftedStartPoint);
        Point2D finalEndPoint = findLineSquareIntersection(shiftedStartPoint, shiftedEndPoint, endPoint);

        this.edge = edge;
        this.startPoint = finalStartPoint;
        this.endPoint = finalEndPoint;

        this.line2D = new Line2D.Double(finalStartPoint, finalEndPoint);

        if (weight<1)
            throw new IllegalArgumentException("Nasobnost hrany musi byt kladna");

        this.weight = weight;


    }

    public Edge2D(Edge edge, double x1, double y1, double x2, double y2, int weight) throws IllegalArgumentException  {
        if (edge == null){
            throw new IllegalArgumentException("Nespravna zadana hrana");
        }


        Point2D tmpStartPoint = new Point2D.Double(x1,y1);
        Point2D tmpEndPoint = new Point2D.Double(x2,y2);

        //zaciatocny a koncovy bod posunuty do stredu objektov
        Point2D shiftedStartPoint = shiftToCenter(tmpStartPoint);
        Point2D shiftedEndPoint = shiftToCenter(tmpEndPoint);

        //skutocny zaciatocny a koncovy bod hrany bude bod dotyku hrany s Place/Transition
        Point2D finalStartPoint = findLineCircleIntersection(shiftedEndPoint, shiftedStartPoint,shiftedStartPoint);
        Point2D finalEndPoint = findLineSquareIntersection(shiftedStartPoint, shiftedEndPoint,tmpEndPoint);

        this.edge = edge;
        this.startPoint = finalStartPoint;
        this.endPoint = finalEndPoint;

        this.line2D = new Line2D.Double(finalStartPoint, finalEndPoint);

        if (weight<1)
            throw new IllegalArgumentException("Nasobnost hrany musi byt kladna");

        this.weight = weight;
    }

    public Edge2D(Edge edge, Point2D startPoint, Point2D endPoint) throws IllegalArgumentException  {
        if (edge == null){
            throw new IllegalArgumentException("Nespravna zadana hrana");
        }

        if (startPoint == null || endPoint == null){
            throw new IllegalArgumentException("Nespravny vstupny alebo vystupny bod");
        }

        //zaciatocny a koncovy bod posunuty do stredu objektov
        Point2D shiftedStartPoint = shiftToCenter(startPoint);
        Point2D shiftedEndPoint = shiftToCenter(endPoint);

        //skutocny zaciatocny a koncovy bod hrany bude bod dotyku hrany s Place/Transition
        Point2D finalStartPoint = findLineCircleIntersection(shiftedEndPoint, shiftedStartPoint,shiftedStartPoint);
        Point2D finalEndPoint = findLineSquareIntersection(shiftedStartPoint, shiftedEndPoint,endPoint);

        this.edge = edge;
        this.startPoint = finalStartPoint;
        this.endPoint = finalEndPoint;

        this.line2D = new Line2D.Double(finalStartPoint, finalEndPoint);
    }

    public Edge2D(Edge edge, double x1, double y1, double x2, double y2) throws IllegalArgumentException  {
        if (edge == null){
            throw new IllegalArgumentException("Nespravna zadana hrana");
        }
        this.edge = edge;

        Point2D tmpStartPoint = new Point2D.Double(x1,y1);
        Point2D tmpEndPoint = new Point2D.Double(x2,y2);

        //zaciatocny a koncovy bod posunuty do stredu objektov
        Point2D shiftedStartPoint = shiftToCenter(tmpStartPoint);
        Point2D shiftedEndPoint = shiftToCenter(tmpEndPoint);

        //skutocny zaciatocny a koncovy bod hrany bude bod dotyku hrany s Place/Transition
        Point2D finalStartPoint = findLineCircleIntersection(shiftedEndPoint, shiftedStartPoint,shiftedStartPoint);
        Point2D finalEndPoint = findLineSquareIntersection(shiftedStartPoint, shiftedEndPoint,tmpEndPoint);

        this.edge = edge;
        this.startPoint = finalStartPoint;
        this.endPoint = finalEndPoint;

        this.line2D = new Line2D.Double(finalStartPoint, finalEndPoint);
    }

    //gettery, settery
    public Line2D getLine2D() {
        return line2D;
    }
    public Edge getEdge() {
        return edge;
    }

    public Point2D getStartPoint() {
        return startPoint;
    }
    public Point2D getEndPoint() {
        return endPoint;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) throws IllegalArgumentException{
        if (weight<1)
            throw new IllegalArgumentException("Nasobnost hrany musi byt kladna");
        this.weight = weight;
    }

    //vykreslenie
    @Override
    public abstract void drawElement(Graphics2D g2);

    //vrati, ci sa kliklo na edge
    @Override
    public boolean ActionAvailable(MouseEvent e){
        //okolo kliku mysou sa vytvori stvorec
        int rectSize = 3;
        Rectangle2D rect = new Rectangle2D.Double(e.getX()-rectSize/2.0,e.getY()-rectSize/2.0,rectSize,rectSize);

        //ci pretina stvorec hranu
        return rect.intersectsLine(line2D);
    }

    //neudeje sa nic
    @Override
    public void reactToAction(PNCanvas pnCanvas, MouseEvent e) {
    }


    //mazanie
    @Override
    public void remove(PNCanvas pnCanvas) {
        long id =edge.getId();
        pnCanvas.getPetriNet().delEdge(id);
        pnCanvas.getPnElements().remove(this);
    }

    //posun bodu do stredu objektu
    public Point2D shiftToCenter(Point2D point){
        return new Point2D.Double(point.getX()+PNCanvas.ELEMENT_SIZE/2.0,point.getY()+PNCanvas.ELEMENT_SIZE/2.0);
    }

    //najde bod prieniku usecky (sourcePoint, destPoint) a obdlznikom s bodom laveho horneho rohu elementPoint
    public Point2D findLineSquareIntersection(Point2D sourcePoint, Point2D destPoint, Point2D elementPoint){
        Point2D intersection = new Point();

        //objekt ma 4 body (topLeft = elementPoint)
        Point2D topRight = new Point2D.Double(elementPoint.getX()+PNCanvas.ELEMENT_SIZE,elementPoint.getY());
        Point2D bottomLeft = new Point2D.Double(elementPoint.getX(),elementPoint.getY()+PNCanvas.ELEMENT_SIZE);
        Point2D bottomRight = new Point2D.Double(elementPoint.getX()+PNCanvas.ELEMENT_SIZE,elementPoint.getY()+PNCanvas.ELEMENT_SIZE);

        //objekt je tvoreny(ohraniceny) 4 useckami (transition = stvorec, place = kruh, ale je v pisany do stvorca)
        Line2D topLine = new Line2D.Double(elementPoint,topRight);
        Line2D bottomLine = new Line2D.Double(bottomLeft,bottomRight);
        Line2D leftLine = new Line2D.Double(elementPoint,bottomLeft);
        Line2D rightLine = new Line2D.Double(topRight,bottomRight);

        //usecka, ktora predstavuje hranu
        Line2D edgeLine = new Line2D.Double(sourcePoint,destPoint);

        //ak hrana pretina niektoru z hranicnych useciek, najde sa na nej bod prieniku
        if (edgeLine.intersectsLine(topLine)){
            intersection = getIntersection(edgeLine,topLine);
        }
        else if(edgeLine.intersectsLine(bottomLine)){
            intersection = getIntersection(edgeLine,bottomLine);
        }
        else if (edgeLine.intersectsLine(leftLine)) {
            intersection = getIntersection(edgeLine,leftLine);
        }
        else if(edgeLine.intersectsLine(rightLine)){
            intersection = getIntersection(edgeLine,rightLine);
        }

        return intersection;
    }

    //vrati prienik 2 useciek
    public Point2D getIntersection(Line2D line1, Line2D line2){
        Point2D intersection = new Point2D.Double();

        //(x1,y1) = zaciatocny bod line1
        double x1 = line1.getX1();
        double y1 = line1.getY1();

        //(x2,y2) = koncovy bod line1
        double x2 = line1.getX2();
        double y2 = line1.getY2();

        //(x3,y3) = zaciatocny bod line2
        double x3 = line2.getX1();
        double y3 = line2.getY1();

        //(x4,y4) = koncovy bod line2
        double x4 = line2.getX2();
        double y4 = line2.getY2();

        //vzorec z wikipedie :D
        double d = (x1-x2)*(y3-y4)-(y1-y2)*(x3-x4);
        double interX = ((x1*y2-y1*x2)*(x3-x4)-(x1-x2)*(x3*y4-y3*x4))/d;
        double interY = ((x1*y2-y1*x2)*(y3-y4)-(y1-y2)*(x3*y4-y3*x4))/d;

        intersection.setLocation(interX,interY);

        return intersection;

    }

    //najde bod prieniku usecky (sourcePoint, destPoint) a kruhom so stredom v bode center
    public Point2D findLineCircleIntersection(Point2D sourcePoint,Point2D destPoint, Point2D center) {
        //rozdiel koncovych a zaciatocnych suradnic bodov usecky
        double baX = destPoint.getX() - sourcePoint.getX();
        double baY = destPoint.getY() - sourcePoint.getY();
        //rozdiel suradnic stredu kruhu a zaciatocnych suradnic usecky
        double caX = center.getX() - sourcePoint.getX();
        double caY = center.getY() - sourcePoint.getY();

        //podla vzorca na vypocet priesecnika usecky a kruhu

        //koeficienty kvadratickej rovnice
        double a = Math.pow(baX,2) + Math.pow(baY,2);
        double b = baX * caX + baY * caY;
        double c = Math.pow(caX,2) + Math.pow(caY,2) - Math.pow(PNCanvas.ELEMENT_SIZE/2.0,2);

        double p = b / a;
        double q = c / a;

        double disc = Math.pow(p,2) - q;

        //staci nam iba 1 priesecnik, netreba pocitat +/-
        double abScalingFactor = -p + Math.sqrt(disc);

        Point2D point2D = new Point2D.Double(sourcePoint.getX() - baX * abScalingFactor, sourcePoint.getY() - baY * abScalingFactor);

        return point2D;
    }


}

