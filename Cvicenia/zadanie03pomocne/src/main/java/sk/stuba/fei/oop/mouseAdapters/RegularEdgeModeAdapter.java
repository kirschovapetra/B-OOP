package sk.stuba.fei.oop.mouseAdapters;

import sk.stuba.fei.oop.gui.PNCanvas;
import sk.stuba.fei.oop.gui.Place2D;
import sk.stuba.fei.oop.gui.Transition2D;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegularEdgeModeAdapter extends MouseAdapter {
    private PNCanvas pnCanvas;

    public RegularEdgeModeAdapter(PNCanvas pnCanvas) {
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
        pnCanvas.addRegularEdgeMode();
    }
}
