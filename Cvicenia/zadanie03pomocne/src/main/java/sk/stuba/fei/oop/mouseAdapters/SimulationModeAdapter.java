package sk.stuba.fei.oop.mouseAdapters;

import sk.stuba.fei.oop.exceptions.TransitionNotFirableException;
import sk.stuba.fei.oop.exceptions.TransitionNotFoundException;
import sk.stuba.fei.oop.gui.Drawable;
import sk.stuba.fei.oop.gui.PNCanvas;
import sk.stuba.fei.oop.gui.Place2D;
import sk.stuba.fei.oop.gui.Transition2D;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SimulationModeAdapter extends MouseAdapter {
    private PNCanvas pnCanvas;

    public SimulationModeAdapter(PNCanvas pnCanvas) {
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
        pnCanvas.simulationMode();
    }
}

