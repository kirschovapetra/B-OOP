package sk.stuba.fei.oop.buttons;

import sk.stuba.fei.oop.mouseAdapters.RemoveModeAdapter;

import java.awt.*;

public class RemoveButton extends Button  {
    private RemoveModeAdapter removeModeAdapter;
    public RemoveButton() throws HeadlessException {
    }
    public RemoveButton(String label) throws HeadlessException {
        super(label);
    }
    public RemoveButton(RemoveModeAdapter removeModeAdapter) throws HeadlessException {
        this.removeModeAdapter = removeModeAdapter;
    }
    public RemoveButton(String label, RemoveModeAdapter removeModeAdapter) throws HeadlessException {
        super(label);
        this.removeModeAdapter = removeModeAdapter;
    }

    public RemoveModeAdapter getRemoveModeAdapter() {
        return removeModeAdapter;
    }

    public void setRemoveModeAdapter(RemoveModeAdapter removeModeAdapter) {
        this.removeModeAdapter = removeModeAdapter;
    }
}
