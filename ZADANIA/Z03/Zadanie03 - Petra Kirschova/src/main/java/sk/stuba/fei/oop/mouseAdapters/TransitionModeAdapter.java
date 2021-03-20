package sk.stuba.fei.oop.mouseAdapters;

import sk.stuba.fei.oop.gui.PNCanvas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TransitionModeAdapter extends MouseAdapter {
    PNCanvas pnCanvas;  //canvas, na ktore sa adapter vztahuje

    //konstruktor
    public TransitionModeAdapter(PNCanvas pnCanvas) {
        this.pnCanvas = pnCanvas;
    }

    //getter, setter
    public PNCanvas getPnCanvas() {
        return pnCanvas;
    }
    public void setPnCanvas(PNCanvas pnCanvas) {
        this.pnCanvas = pnCanvas;
    }

    //po kliknuti sa spusti pridavanie Transition
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        pnCanvas.addClick(e);
        //pridavanie Transition
        pnCanvas.addTransitionMode();

    }
}
