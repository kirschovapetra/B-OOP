package sk.stuba.fei.oop.buttons;

import sk.stuba.fei.oop.mouseAdapters.TransitionModeAdapter;

import java.awt.*;

//button na pridavanie transition
public class AddTransitionButton extends Button {
    private TransitionModeAdapter transitionModeAdapter; //adapter na zachytavanie kliknutia

    //konstruktory
    public AddTransitionButton() throws HeadlessException {
    }

    public AddTransitionButton(String label) throws HeadlessException {
        super(label);
    }

    public AddTransitionButton(TransitionModeAdapter transitionModeAdapter) throws HeadlessException {
        this.transitionModeAdapter = transitionModeAdapter;
    }

    public AddTransitionButton(String label, TransitionModeAdapter transitionModeAdapter) throws HeadlessException {
        super(label);
        this.transitionModeAdapter = transitionModeAdapter;
    }

    //getter, setter
    public TransitionModeAdapter getTransitionModeAdapter() {
        return transitionModeAdapter;
    }

    public void setTransitionModeAdapter(TransitionModeAdapter transitionModeAdapter) {
        this.transitionModeAdapter = transitionModeAdapter;
    }
}
