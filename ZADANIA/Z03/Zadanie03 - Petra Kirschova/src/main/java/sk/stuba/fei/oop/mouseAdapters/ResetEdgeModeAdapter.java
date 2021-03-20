package sk.stuba.fei.oop.mouseAdapters;

import sk.stuba.fei.oop.gui.PNCanvas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ResetEdgeModeAdapter extends MouseAdapter {
    private PNCanvas pnCanvas;  //canvas, na ktore sa adapter vztahuje

    //konstruktor
    public ResetEdgeModeAdapter(PNCanvas pnCanvas) {
        this.pnCanvas = pnCanvas;
    }

    //getter, setter
    public PNCanvas getPnCanvas() {
        return pnCanvas;
    }
    public void setPnCanvas(PNCanvas pnCanvas) {
        this.pnCanvas = pnCanvas;
    }

    //po kliknuti sa spusti pridavanie ResetEdge
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        pnCanvas.addClick(e);
        //pridavanie ResetEdge
        pnCanvas.addResetEdgeMode();
    }
}
