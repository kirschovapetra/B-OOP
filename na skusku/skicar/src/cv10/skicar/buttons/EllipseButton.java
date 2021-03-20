package cv10.skicar.buttons;

import cv10.skicar.listeners.EllipseAdapter;

import java.awt.*;

public class EllipseButton extends Button {
    private EllipseAdapter ellipseAdapter;

    public EllipseButton(String label, EllipseAdapter ellipseAdapter) throws HeadlessException {
        super(label);
        this.ellipseAdapter = ellipseAdapter;
    }

    public EllipseAdapter getEllipseAdapter() {
        return ellipseAdapter;
    }

    public void setEllipseAdapter(EllipseAdapter ellipseAdapter) {
        this.ellipseAdapter = ellipseAdapter;
    }
}
