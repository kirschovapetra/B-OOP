package sk.stuba.fei.oop.buttons;

import sk.stuba.fei.oop.mouseAdapters.PlayModeAdapter;

import java.awt.*;

//button na spustanie prechodov a pridavanie/odoberanie tokenov
public class PlayButton extends Button{
    private PlayModeAdapter playModeAdapter; //adapter na zachytavanie kliknutia

    //konstruktory
    public PlayButton() throws HeadlessException {
    }

    public PlayButton(String label) throws HeadlessException {
        super(label);
    }

    public PlayButton(PlayModeAdapter playModeAdapter) throws HeadlessException {
        this.playModeAdapter = playModeAdapter;
    }

    public PlayButton(String label, PlayModeAdapter playModeAdapter) throws HeadlessException {
        super(label);
        this.playModeAdapter = playModeAdapter;
    }

    //getter, setter
    public PlayModeAdapter getPlayModeAdapter() {
        return playModeAdapter;
    }

    public void setPlayModeAdapter(PlayModeAdapter playModeAdapter) {
        this.playModeAdapter = playModeAdapter;
    }
}
