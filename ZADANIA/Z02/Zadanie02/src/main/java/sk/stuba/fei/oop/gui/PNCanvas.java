package sk.stuba.fei.oop.gui;
import sk.stuba.fei.oop.exceptions.TransitionNotFirableException;
import sk.stuba.fei.oop.exceptions.TransitionNotFoundException;
import sk.stuba.fei.oop.petrinet.PetriNet;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

public class PNCanvas extends Canvas implements MouseListener {
    private PetriNet petriNet;          //vykreslovana petriho siet
    private List<Drawable> pnElements;  //list grafickych objektov reprezentujucich petriho siet

    //konstruktory
    public PNCanvas() {
        pnElements = new LinkedList<Drawable>();
        petriNet = new PetriNet();
        addMouseListener(this);
    }
    public PNCanvas(List<Drawable> pnElements, PetriNet petriNet) {
        this.pnElements = pnElements;
        this.petriNet = petriNet;
        addMouseListener(this);
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

    //vyprazdni canvas - petriho siet aj zoznam elementov
    public void clear(){
        petriNet.clear();
        pnElements.clear();
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //vykreslenie vsetkych objektov
        for (Drawable currentPnElement: pnElements){
            currentPnElement.drawElement((Graphics2D) g);
        }
    }

    //sleduje sa kliknutie mysou -> spustenie prechodu
    @Override
    public void mouseClicked(MouseEvent e){
        for (Drawable currentPnElement: pnElements){

            if (currentPnElement.ActionAvailable(e)){
                long toFireId = ((Transition2D)currentPnElement).getTransition().getId();
                try {
                    petriNet.fireTransition(toFireId);
                }
                //ak prechod nie je spustitelny, po kliknuti sa neudeje nic
                catch(TransitionNotFirableException exception){}
                catch (TransitionNotFoundException exception){}

                repaint();
            }
        }
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
