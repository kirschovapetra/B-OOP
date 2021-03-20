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
public abstract class GeomTvar {
    private int x;
    private int y;
    public abstract double Obvod();
    public abstract double Obsah();
    public abstract void vykresli(Graphics g);

    public GeomTvar(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public GeomTvar() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
