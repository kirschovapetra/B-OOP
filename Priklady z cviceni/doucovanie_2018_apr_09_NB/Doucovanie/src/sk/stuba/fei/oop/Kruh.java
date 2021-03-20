/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stuba.fei.oop;

import java.awt.Graphics;

/**
 *
 * @author Ondrej Gallo
 *
 */
public class Kruh extends GeomTvar{
    private int polomer;

    public Kruh() {
        super();
    }

    public Kruh(int polomer) {
        super();
        this.polomer = polomer;
    }
    public Kruh(int x, int y, int polomer) {
        super(x,y);
        this.polomer = polomer;
    }    
    @Override
    public double Obvod() {
        return 2*Math.PI*polomer;
    }

    @Override
    public double Obsah() {
        return Math.PI*Math.pow(polomer, 2);
    }

    @Override
    public void vykresli(Graphics g) {
        g.drawOval(this.getX(), this.getY(), 2*polomer, 2*polomer);
    }
}
