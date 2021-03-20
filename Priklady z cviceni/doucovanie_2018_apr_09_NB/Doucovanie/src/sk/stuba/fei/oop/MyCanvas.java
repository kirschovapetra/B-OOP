/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stuba.fei.oop;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ondrej Gallo
 *
 */
public class MyCanvas extends Canvas implements MouseListener{
    private List<GeomTvar> geomTvary;

    public MyCanvas() {
        super();
        this.geomTvary = new ArrayList<>();
    }
  
    public void vlozGeomTvar(GeomTvar geomTvar){
        this.geomTvary.add(geomTvar);
    }
    @Override
    public void paint(Graphics g) {
        for(GeomTvar gt:geomTvary){
            gt.vykresli(g);
        }
    }

    public List<GeomTvar> getGeomTtvary() {
        return geomTvary;
    }

    public void setGeomUtvary(List<GeomTvar> geomTvary) {
        this.geomTvary = geomTvary;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("x="+e.getX()+", y="+e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
