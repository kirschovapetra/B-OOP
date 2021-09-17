package sk.stuba.fei.oop;

import sk.stuba.fei.oop.gui.PNFrame;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        try {
            PNFrame pnFrame = new PNFrame();
            pnFrame.setVisible(true);
        }
        catch (HeadlessException exception){
            System.out.println(exception);
        }

    }
}