package sk.stuba.fei.oop.buttons;

import sk.stuba.fei.oop.mouseAdapters.RegularEdgeModeAdapter;

import java.awt.*;

//button na pridavanie RegularEdge
public class AddRegularEdgeButton  extends Button{
    private RegularEdgeModeAdapter regularEdgeModeAdapter; //adapter na zachytavanie kliknutia

    //konstruktory
    public AddRegularEdgeButton() throws HeadlessException {
    }

    public AddRegularEdgeButton(String label) throws HeadlessException {
        super(label);
    }

    public AddRegularEdgeButton(RegularEdgeModeAdapter regularEdgeModeAdapter) throws HeadlessException {
        this.regularEdgeModeAdapter = regularEdgeModeAdapter;
    }

    public AddRegularEdgeButton(String label, RegularEdgeModeAdapter regularEdgeModeAdapter) throws HeadlessException {
        super(label);
        this.regularEdgeModeAdapter = regularEdgeModeAdapter;
    }

    //getter, setter
    public RegularEdgeModeAdapter getRegularEdgeModeAdapter() {
        return regularEdgeModeAdapter;
    }

    public void setRegularEdgeModeAdapter(RegularEdgeModeAdapter regularEdgeModeAdapter) {
        this.regularEdgeModeAdapter = regularEdgeModeAdapter;
    }
}
