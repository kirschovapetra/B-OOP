/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stuba.fei.oop;

import java.awt.Frame;

/**
 *
 * @author Ondrej Gallo
 *
 */
public class Doucovanie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Frame okno = new Frame();
        okno.setSize(400, 400);
        MyCanvas platno = new MyCanvas();
        platno.addMouseListener(platno);    //platno bude pocuvat na udalosti od mysi
        okno.add(platno);
        //priklad manualneho pridavania na platno...
        platno.vlozGeomTvar(new Kruh(30, 30, 50));
        platno.vlozGeomTvar(new Kruh(100, 50, 30));
        platno.vlozGeomTvar(new Stvorec(150, 100, 30));
        okno.setVisible(true);
    }
    
}
