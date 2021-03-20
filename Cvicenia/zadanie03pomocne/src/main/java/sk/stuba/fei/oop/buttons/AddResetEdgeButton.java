package sk.stuba.fei.oop.buttons;

import sk.stuba.fei.oop.mouseAdapters.ResetEdgeModeAdapter;

import java.awt.*;

public class AddResetEdgeButton extends Button  {
    ResetEdgeModeAdapter resetEdgeModeAdapter;
    public AddResetEdgeButton() throws HeadlessException {
    }
    public AddResetEdgeButton(String label) throws HeadlessException {
        super(label);
    }
    public AddResetEdgeButton(ResetEdgeModeAdapter resetEdgeModeAdapter) throws HeadlessException {
        this.resetEdgeModeAdapter = resetEdgeModeAdapter;
    }
    public AddResetEdgeButton(String label, ResetEdgeModeAdapter resetEdgeModeAdapter) throws HeadlessException {
        super(label);
        this.resetEdgeModeAdapter = resetEdgeModeAdapter;
    }

    public ResetEdgeModeAdapter getResetEdgeModeAdapter() {
        return resetEdgeModeAdapter;
    }

    public void setResetEdgeModeAdapter(ResetEdgeModeAdapter resetEdgeModeAdapter) {
        this.resetEdgeModeAdapter = resetEdgeModeAdapter;
    }
}
