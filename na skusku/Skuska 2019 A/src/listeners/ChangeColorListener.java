package listeners;

import gui.CustomCanvas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangeColorListener extends MouseAdapter {
    private CustomCanvas canvas;

    public ChangeColorListener(CustomCanvas canvas) throws IllegalArgumentException{
        if (canvas==null)
            throw new IllegalArgumentException("treba zadat canvas");
        this.canvas = canvas;
    }

    public CustomCanvas getCanvas() {
        return canvas;
    }

    public void setCanvas(CustomCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        canvas.action(e);
    }
}
