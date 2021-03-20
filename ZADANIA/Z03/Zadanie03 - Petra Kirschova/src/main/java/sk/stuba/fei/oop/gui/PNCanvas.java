package sk.stuba.fei.oop.gui;
import sk.stuba.fei.oop.petrinet.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PNCanvas extends Canvas {
    public static final int ELEMENT_SIZE = 25; //konstantna velkost elementu siete

    private PetriNet petriNet;              //vykreslovana petriho siet
    private List<Drawable> pnElements;      //list grafickych objektov reprezentujucich petriho siet
    private List<MouseEvent> clicks;        //zoznam kliknuti mysou
    private int oldClicksCount = 0;         //pocet kliknuti pred vykonanim urc. akcie, na zaciatku 0

    //konstruktory
    public PNCanvas() {
        pnElements = new LinkedList<Drawable>();
        petriNet = new PetriNet();
        clicks = new LinkedList<MouseEvent>();

    }
    public PNCanvas(List<Drawable> pnElements, PetriNet petriNet) {
        this.pnElements = pnElements;
        this.petriNet = petriNet;
        clicks = new LinkedList<MouseEvent>();

    }

    //gettery, settery
    public PetriNet getPetriNet() {
        return petriNet;
    }
    public void setPetriNet(PetriNet petriNet) {
        this.petriNet = petriNet;
    }

    public List<Drawable> getPnElements() {
        return pnElements;
    }
    public void setPnElements(List<Drawable> pnElements) {
        this.pnElements = pnElements;
    }

    public int getOldClicksCount() {
        return oldClicksCount;
    }
    public void setOldClicksCount(int oldClicksCount) {
        this.oldClicksCount = oldClicksCount;
    }

    public List<MouseEvent> getClicks() {
        return clicks;
    }
    public void setClicks(List<MouseEvent> clicks) {
        this.clicks = clicks;
    }

    //pridanie noveho kliknutia do zoznamu
    public void addClick(MouseEvent e){
        this.clicks.add(e);
    }

    //vykreslovanie
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //vykreslenie vsetkych objektov
        for (Drawable currentPnElement: pnElements){
            currentPnElement.drawElement((Graphics2D) g);
        }
    }

    //vyprazdni sa cele canvas
    public void clear(){
        petriNet.clear();
        pnElements.clear();
        clearClicks();
        repaint();
    }
    //vynuluju sa kliknutia
    public void clearClicks(){
        clicks.clear();
        oldClicksCount = 0;
    }

    //pridanie PT hrany
    public void addPTEdge(Place2D startPlace2D, Transition2D endTransition2D){
        Place startPlace = startPlace2D.getPlace();
        Transition endTransition = endTransition2D.getTransition();
        try{
            PTEdge ptEdge = new PTEdge(new IdGenerator().getId(), startPlace, endTransition);
            RegularEdge2D regularEdge2D = new RegularEdge2D(ptEdge, startPlace2D.getX(), startPlace2D.getY(),
                    endTransition2D.getX(), endTransition2D.getY());

            petriNet.addEdge(ptEdge);
            pnElements.add(regularEdge2D);
        }
        catch(IllegalArgumentException exception){}
    }
    //pridanie TP hrany
    public void addTPEdge(Transition2D startTransition2D, Place2D endPlace2D){
        Transition startTransition =startTransition2D.getTransition();
        Place endPlace = endPlace2D.getPlace();

        try {
            TPEdge tpEdge = new TPEdge(new IdGenerator().getId(), startTransition, endPlace);
            RegularEdge2D regularEdge2D = new RegularEdge2D(tpEdge, startTransition2D.getX(), startTransition2D.getY(),
                    endPlace2D.getX(), endPlace2D.getY());

            petriNet.addEdge(tpEdge);
            pnElements.add(regularEdge2D);
        }
        catch(IllegalArgumentException exception){}
    }

    //vymazanie Drawable elementu
    public void removeElement(Drawable element){
        element.remove(this);
    }

    //vymazu sa vsetky Mouse Listenery
    public void removeAllMouseListeners(){
        MouseListener[] mouseListeners = this.getMouseListeners();

        for (MouseListener currentMouseListener: mouseListeners) {
            removeMouseListener(currentMouseListener);
        }
    }


    //ak bolo kliknute na Place2D, vrati ho, ak nie, vrati null
    public Place2D findClickedPlace(MouseEvent e){
        for (Drawable currentElement: pnElements){
            if (currentElement.ActionAvailable(e) && currentElement instanceof Place2D){
                return (Place2D)currentElement;
            }
        }
        return null;
    }

    //ak bolo kliknute na Transition2D, vrati ho, ak nie, vrati null
    public Transition2D findClickedTransition(MouseEvent e){
        for (Drawable currentElement: pnElements){
            if (currentElement.ActionAvailable(e) && currentElement instanceof Transition2D){
                return (Transition2D) currentElement;
            }
        }
        return null;
    }


    //mod na pridavanie Place
    public void addPlaceMode(){
        int clicksCount = clicks.size();

        if (clicksCount > oldClicksCount){  //ak bolo nove kliknutie
            MouseEvent lastClick = clicks.get(clicksCount - 1); //zoberie sa posledne kliknutie

            //suradnice posledneho kliknutia
            int x = lastClick.getX() - ELEMENT_SIZE / 2;
            int y = lastClick.getY() - ELEMENT_SIZE / 2;

            //nove Place
            Place place = new Place(new IdGenerator().getId());
            petriNet.addPlace(place);
            pnElements.add(new Place2D(place, x, y));

            repaint();
            oldClicksCount = clicksCount;
        }
    }

    //mod na pridavanie Transition
    public void addTransitionMode(){
        int clicksCount = clicks.size();

        if (clicksCount > oldClicksCount){  //ak bolo nove kliknutie
            MouseEvent lastClick = clicks.get(clicksCount - 1); //zoberie sa posledne kliknutie

            //suradnice posledneho kliknutia
            int x = lastClick.getX() - ELEMENT_SIZE / 2;
            int y = lastClick.getY() - ELEMENT_SIZE / 2;

            //novy transition
            Transition transition = new Transition(new IdGenerator().getId());
            petriNet.addTransition(transition);
            pnElements.add(new Transition2D(transition, x, y));

            repaint();
            oldClicksCount = clicksCount;
        }
    }

    //mod na pridavanie RegularEdge
    public void addRegularEdgeMode() {
        int clicksCount = clicks.size();

        //beru sa vzdy 2 kliknutia
        if (clicksCount - oldClicksCount == 2) {
            MouseEvent lastClick = clicks.get(clicksCount - 1);
            MouseEvent previousClick = clicks.get(clicksCount - 2);

            //zisti sa, ci to je PT alebo TP hrana
            Place2D startPlace2D = findClickedPlace(previousClick);
            Transition2D startTransition2D = findClickedTransition(previousClick);

            //PT
            if (startPlace2D != null){
                Transition2D endTransition2D = findClickedTransition(lastClick);
                if (endTransition2D != null) {
                    addPTEdge(startPlace2D, endTransition2D);
                }
            }
            //TP
            else if (startTransition2D != null){
                Place2D endPlace2D = findClickedPlace(lastClick);
                if (endPlace2D != null) {
                    addTPEdge(startTransition2D, endPlace2D);
                }
            }
            //ak nebolo spravne kliknute, kliknutia sa vymazu a zacina sa odznova
            else{
                clearClicks();
            }

            repaint();
            oldClicksCount = clicksCount;

        }
    }

    //mod na pridavanie ResetEdge
    public void addResetEdgeMode() {
        int clicksCount = clicks.size();

        //beru sa vzdy 2 kliknutia
        if (clicksCount - oldClicksCount == 2) {

            MouseEvent lastClick = clicks.get(clicksCount - 1);
            MouseEvent previousClick = clicks.get(clicksCount - 2);

            //ResetEdge je vzdy PT
            Place2D startPlace2D = findClickedPlace(previousClick);
            Transition2D endTransition2D = findClickedTransition(lastClick);

            if (startPlace2D != null && endTransition2D != null) {
                Place startPlace = startPlace2D.getPlace();
                Transition endTransition = endTransition2D.getTransition();

                try {
                    ResetEdge resetEdge = new ResetEdge((new IdGenerator()).getId(), startPlace, endTransition);
                    ResetEdge2D resetEdge2D = new ResetEdge2D(resetEdge, startPlace2D.getX(), startPlace2D.getY(),
                            endTransition2D.getX(), endTransition2D.getY());

                    petriNet.addEdge(resetEdge);
                    pnElements.add(resetEdge2D);

                    repaint();
                    oldClicksCount = clicksCount;
                }
                catch(IllegalArgumentException exception){}
            }
            //ak nebolo spravne kliknute, kliknutia sa vymazu a zacina sa odznova
            else{
                clearClicks();
            }
        }
    }

    //mod na mazanie
    public void removeMode(){
        int clicksCount = clicks.size();

        if (clicksCount > oldClicksCount) {  //ak bolo nove kliknutie
            MouseEvent lastClick = clicks.get(clicksCount - 1); //zoberie sa posledne kliknutie

            //mazat sa bude vzdy od konca = ten element, co je na vrchu
            Collections.reverse(pnElements);
            for (Drawable currentElement : pnElements) {
                if (currentElement.ActionAvailable(lastClick)) {
                    removeElement(currentElement);
                    break; //vymaze sa len jeden
                }
            }
            Collections.reverse(pnElements);
            repaint();
        }
    }

    //spustanie prechodov a pridavanie/odoberanie tokenov
    public void playMode() {
        int clicksCount = clicks.size();
        MouseEvent lastClick = clicks.get(clicksCount - 1);

        //ak su na sebe viacere elementy, spusti sa ten, ktory je na vrchu
        Collections.reverse(pnElements);
        for (Drawable currentPnElement : pnElements) {
            if (currentPnElement.ActionAvailable(lastClick)) {
                currentPnElement.reactToAction(this, lastClick);
                repaint();
                break; //aby sa vykonala len 1 akcia
            }
        }
        Collections.reverse(pnElements);
    }
}
