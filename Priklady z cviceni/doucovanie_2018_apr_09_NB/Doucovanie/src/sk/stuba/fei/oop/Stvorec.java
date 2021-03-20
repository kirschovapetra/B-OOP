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
public class Stvorec extends GeomTvar{
    private int velkost;

    public Stvorec() {
        super();
    }
    public Stvorec(int velkost) {
        super();
        this.velkost = velkost;
    }
    public Stvorec(int x, int y, int velkost) {
        super(x,y);
        this.velkost = velkost;
    }
    
    @Override
    public double Obvod() {
        return 2*velkost;
    }

    @Override
    public double Obsah() {
        return Math.pow(velkost, 2);
    }

    @Override
    public void vykresli(Graphics g) {
        g.drawRect(this.getX(), this.getY(), this.velkost, this.velkost);
    }
    
}
