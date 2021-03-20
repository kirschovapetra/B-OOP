package sk.stuba.fei.oop.buttons;

import sk.stuba.fei.oop.mouseAdapters.PlaceModeAdapter;

import java.awt.*;

public class AddPlaceButton extends Button{
    private PlaceModeAdapter placeModeAdapter;

    public AddPlaceButton() throws HeadlessException {
    }
    public AddPlaceButton(String label) throws HeadlessException {
        super(label);
    }
    public AddPlaceButton(PlaceModeAdapter placeModeAdapter) throws HeadlessException {
        this.placeModeAdapter = placeModeAdapter;
    }
    public AddPlaceButton(String label, PlaceModeAdapter placeModeAdapter) throws HeadlessException {
        super(label);
        this.placeModeAdapter = placeModeAdapter;
    }

    public PlaceModeAdapter getPlaceModeAdapter() {
        return placeModeAdapter;
    }
    public void setPlaceModeAdapter(PlaceModeAdapter placeModeAdapter) {
        this.placeModeAdapter = placeModeAdapter;
    }
}
