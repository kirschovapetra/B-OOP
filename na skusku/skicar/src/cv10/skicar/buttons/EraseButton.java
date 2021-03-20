package cv10.skicar.buttons;

import cv10.skicar.listeners.EraseAdapter;

import java.awt.*;

public class EraseButton extends Button {
    private EraseAdapter eraseAdapter;

    public EraseButton(String label, EraseAdapter eraseAdapter) throws HeadlessException {
        super(label);
        this.eraseAdapter = eraseAdapter;
    }

    public EraseAdapter getEraseAdapter() {
        return eraseAdapter;
    }

    public void setEraseAdapter(EraseAdapter eraseAdapter) {
        this.eraseAdapter = eraseAdapter;
    }
}
