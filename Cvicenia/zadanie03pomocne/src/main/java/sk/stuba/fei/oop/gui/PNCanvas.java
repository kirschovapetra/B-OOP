package sk.stuba.fei.oop.gui;
import sk.stuba.fei.oop.exceptions.TransitionNotFirableException;
import sk.stuba.fei.oop.exceptions.TransitionNotFoundException;
import sk.stuba.fei.oop.petrinet.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PNCanvas extends Canvas {
    public static final int ELEMENT_SIZE = 25; //konstantna velkost elementu siete

    private PetriNet petriNet;          //vykreslovana petriho siet
    private List<Drawable> pnElements;  //list grafickych objektov reprezentujucich petriho siet
    private List<MouseEvent> clicks;    //zoznam kliknuti mysou
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

    public List<MouseEvent> getClicks() {
        return clicks;
    }
    public void setClicks(List<MouseEvent> clicks) {
        this.clicks = clicks;
    }


    public int getOldClicksCount() {
        return oldClicksCount;
    }

    public void setOldClicksCount(int oldClicksCount) {
        this.oldClicksCount = oldClicksCount;
    }

    //vyprazdni sa cele canvas
    public void clear(){
        petriNet.clear();
        pnElements.clear();
        clearClicks();
        repaint();
    }
    public void clearClicks(){
        clicks.clear();
        oldClicksCount = 0;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //vykreslenie vsetkych objektov
        for (Drawable currentPnElement: pnElements){
            currentPnElement.drawElement((Graphics2D) g);
        }
    }


    public void addPTEdge(Place2D startPlace2D, Transition2D endTransition2D){
        Place startPlace = startPlace2D.getPlace();
        Transition endTransition = endTransition2D.getTransition();

        PTEdge ptEdge = new PTEdge(new IdGenerator().getId(), startPlace, endTransition);
        RegularEdge2D regularEdge2D = new RegularEdge2D(ptEdge, startPlace2D.getX(), startPlace2D.getY(), endTransition2D.getX(), endTransition2D.getY());

        petriNet.addEdge(ptEdge);
        pnElements.add(regularEdge2D);
    }
    public void addTPEdge(Transition2D startTransition2D,Place2D endPlace2D){
        Transition startTransition =startTransition2D.getTransition();
        Place endPlace = endPlace2D.getPlace();

        TPEdge tpEdge = new TPEdge(new IdGenerator().getId(), startTransition, endPlace);
        RegularEdge2D regularEdge2D = new RegularEdge2D(tpEdge, startTransition2D.getX(), startTransition2D.getY(), endPlace2D.getX(), endPlace2D.getY());


        petriNet.addEdge(tpEdge);
        pnElements.add(regularEdge2D);
    }



    public void removeElement(Drawable element){
        if (element instanceof Edge2D){
            removeEdge(element);
        }
        else if (element instanceof Place2D){
            removePlace(element);
        }
        else if (element instanceof Transition2D){
            removeTransition(element);
        }
    }
    public void removeEdge(Drawable element){
        long id =((Edge2D) element).getEdge().getId();
        petriNet.delEdge(id);
        pnElements.remove(element);
    }
    public void removePlace(Drawable element){
        long id = ((Place2D) element).getPlace().getId();
        List<Drawable>tmpPnElements = new LinkedList(pnElements);

        for (Drawable currentElement: tmpPnElements){
            if (currentElement instanceof Edge2D) {
                long vertexStartId = ((Edge2D) currentElement).getEdge().getVertexStart().getId();
                long vertexEndId = ((Edge2D) currentElement).getEdge().getVertexEnd().getId();
                if (vertexStartId == id || vertexEndId == id) {
                    removeEdge(currentElement);
                }
            }
        }
        petriNet.delPlace(id);
        pnElements.remove(element);
    }
    public void removeTransition(Drawable element){
        long id = ((Transition2D) element).getTransition().getId();
        List<Drawable>tmpPnElements = new LinkedList(pnElements);

        for (Drawable currentElement: tmpPnElements){
            if (currentElement instanceof Edge2D) {
                long vertexStartId = ((Edge2D) currentElement).getEdge().getVertexStart().getId();
                long vertexEndId = ((Edge2D) currentElement).getEdge().getVertexEnd().getId();
                if (vertexStartId == id || vertexEndId == id) {
                    removeEdge(currentElement);
                }
            }
        }
        petriNet.delTransition(id);
        pnElements.remove(element);
    }


    public Place2D findClickedPlace(MouseEvent e){
        for (Drawable currentElement: pnElements){
            if (currentElement.ActionAvailable(e) && currentElement instanceof Place2D){
                return (Place2D)currentElement;
            }
        }
        return null;
    }
    public Transition2D findClickedTransition(MouseEvent e){
        for (Drawable currentElement: pnElements){
            if (currentElement.ActionAvailable(e) && currentElement instanceof Transition2D){
                return (Transition2D) currentElement;
            }
        }
        return null;
    }

    public void removeAllMouseListeners(){
        MouseListener[] mouseListeners = getMouseListeners();
        for (MouseListener currentMouseListener: mouseListeners) {
            removeMouseListener(currentMouseListener);
        }
    }

    public void addPlaceMode(){
        int clicksCount = clicks.size();

        if (clicksCount > oldClicksCount){  //ak bolo nove kliknutie
            MouseEvent lastClick = clicks.get(clicksCount - 1); //zoberie sa posledne kliknutie

            int x = lastClick.getX() - ELEMENT_SIZE / 2;
            int y = lastClick.getY() - ELEMENT_SIZE / 2;


            //nove place
            Place place = new Place(new IdGenerator().getId());
            petriNet.addPlace(place);
            pnElements.add(new Place2D(place, x, y));

            repaint();
            oldClicksCount = clicksCount;
        }
    }
    public void addTransitionMode(){
        int clicksCount = clicks.size();

        if (clicksCount > oldClicksCount){  //ak bolo nove kliknutie
            MouseEvent lastClick = clicks.get(clicksCount - 1); //zoberie sa posledne kliknutie

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
    public void addRegularEdgeMode() {
        int clicksCount = clicks.size();

        if (clicksCount - oldClicksCount == 2) {
            MouseEvent lastClick = clicks.get(clicksCount - 1);
            MouseEvent previousClick = clicks.get(clicksCount - 2);

            Place2D startPlace2D = findClickedPlace(previousClick);
            Transition2D startTransition2D = findClickedTransition(previousClick);
            //PT
            if (startPlace2D!=null){
                Transition2D endTransition2D = findClickedTransition(lastClick);
                if (endTransition2D != null) {
                    addPTEdge(startPlace2D, endTransition2D);
                }
            }
            //TP
            else if (startTransition2D!=null){
                Place2D endPlace2D = findClickedPlace(lastClick);
                if (endPlace2D != null) {
                    addTPEdge(startTransition2D, endPlace2D);
                }
            }
            else{
                clearClicks();
            }

            repaint();
            oldClicksCount = clicksCount;

        }
    }
    public void addResetEdgeMode() {
        int clicksCount = clicks.size();

        if (clicksCount - oldClicksCount == 2) {

            MouseEvent lastClick = clicks.get(clicksCount - 1);
            MouseEvent previousClick = clicks.get(clicksCount - 2);

            Place2D startPlace2D = findClickedPlace(previousClick);
            Transition2D endTransition2D = findClickedTransition(lastClick);

            if (startPlace2D!= null && endTransition2D!=null) {
                Place startPlace = startPlace2D.getPlace();
                Transition endTransition = endTransition2D.getTransition();

                ResetEdge resetEdge = new ResetEdge((new IdGenerator()).getId(), startPlace, endTransition);
                ResetEdge2D resetEdge2D = new ResetEdge2D(resetEdge, startPlace2D.getX(), startPlace2D.getY(), endTransition2D.getX(), endTransition2D.getY());

                petriNet.addEdge(resetEdge);
                pnElements.add(resetEdge2D);

                repaint();
                oldClicksCount = clicksCount;
            }
            else{
                clearClicks();
            }
        }
    }
    public void removeMode(){
        int clicksCount = clicks.size();

        if (clicksCount > oldClicksCount) {  //ak bolo nove kliknutie
            MouseEvent lastClick = clicks.get(clicksCount - 1); //zoberie sa posledne kliknutie
            Collections.reverse(pnElements);
            for (Drawable currentElement : pnElements) {
                if (currentElement.ActionAvailable(lastClick)) {
                    removeElement(currentElement);
                    break;
                }
            }
            Collections.reverse(pnElements);
            repaint();
        }
    }
    public void simulationMode() {
        int clicksCount = clicks.size();
        MouseEvent lastClick = clicks.get(clicksCount - 1);

        for (Drawable currentPnElement : pnElements) {
            //TODO skusit zmenit tak, aby sa nepouzivalo instanceof

            //transition = spusti sa
            if (currentPnElement.ActionAvailable(lastClick)) {
                if (currentPnElement instanceof Transition2D) {
                    long toFireId = ((Transition2D) currentPnElement).getTransition().getId();
                    try {
                        petriNet.fireTransition(toFireId);
                    }
                    //ak prechod nie je spustitelny, po kliknuti sa neudeje nic
                    catch (TransitionNotFirableException exception) {
                    } catch (TransitionNotFoundException exception) {
                    }

                }
                //place = pridavaju/odoberaju sa tokeny
                else if (currentPnElement instanceof Place2D) {
                    long toSetTokensId = ((Place2D) currentPnElement).getPlace().getId();
                    //lave tlacidlo = pridavaju sa tokeny
                    if (lastClick.getButton() == MouseEvent.BUTTON1) {
                        ((Place2D) currentPnElement).getPlace().updateTokens(1);
                    }
                    //prave tlacidlo = odoberaju sa tokeny
                    else if (lastClick.getButton() == MouseEvent.BUTTON3) {
                        //moze vyhodit vynimku, ak sa snazime odoberat neexistujuce tokeny
                        try {
                            ((Place2D) currentPnElement).getPlace().updateTokens(-1);
                        }
                        //ak sa snazime odobrat neexistujuce tokeny, neudeje sa nic
                        catch (IllegalArgumentException exception) {
                        }
                    }
                }
                repaint();
            }
        }
    }


}
