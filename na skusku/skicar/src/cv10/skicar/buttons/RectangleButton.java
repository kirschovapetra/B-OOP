package cv10.skicar.buttons;

import cv10.skicar.listeners.RectangleAdapter;

import java.awt.*;


public class RectangleButton extends Button {
    private RectangleAdapter rectangleAdapter;

    public RectangleButton(String label, RectangleAdapter rectangleAdapter) throws HeadlessException {
        super(label);
        this.rectangleAdapter = rectangleAdapter;
    }

    public RectangleAdapter getRectangleAdapter() {
        return rectangleAdapter;
    }

    public void setRectangleAdapter(RectangleAdapter rectangleAdapter) {
        this.rectangleAdapter = rectangleAdapter;
    }
}
