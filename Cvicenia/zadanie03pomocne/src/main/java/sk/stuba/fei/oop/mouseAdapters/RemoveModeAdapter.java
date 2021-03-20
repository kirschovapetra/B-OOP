package sk.stuba.fei.oop.mouseAdapters;

import sk.stuba.fei.oop.gui.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;

public class RemoveModeAdapter extends MouseAdapter {
    private PNCanvas pnCanvas;

    public RemoveModeAdapter(PNCanvas pnCanvas) {
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
        pnCanvas.removeMode();
    }
}

