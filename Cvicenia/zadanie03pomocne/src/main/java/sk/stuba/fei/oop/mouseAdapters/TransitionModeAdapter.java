package sk.stuba.fei.oop.mouseAdapters;

import sk.stuba.fei.oop.gui.PNCanvas;
import sk.stuba.fei.oop.gui.Transition2D;
import sk.stuba.fei.oop.petrinet.IdGenerator;
import sk.stuba.fei.oop.petrinet.Transition;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TransitionModeAdapter extends MouseAdapter {
    PNCanvas pnCanvas;

    public TransitionModeAdapter(PNCanvas pnCanvas) {
        this.pnCanvas = pnCanvas;
    }

    public PNCanvas getPnCanvas() {
        return pnCanvas;
    }

    public void setPnCanvas(PNCanvas pnCanvas) {
        this.pnCanvas = pnCanvas;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        pnCanvas.getClicks().add(e);
        pnCanvas.addTransitionMode();

    }
}
