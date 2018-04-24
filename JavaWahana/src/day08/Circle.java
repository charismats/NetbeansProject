/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day08;

/**
 *
 * @author charisma
 */
public class Circle extends TwoDShape{
    private int radius;

    public Circle(){
        super(0,0);
        radius = 1;
    }
    public Circle(int r){
        super(0,0);
        radius = r;
    }
    
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    @Override
    public double getArea(){
        return Math.PI * radius * radius;
    }
    @Override 
    public double getKeliling(){
        return Math.PI * 2 * radius;
    }
    
     @Override
    public String toString(){
        return "center at ("+getCx()+","+getCy()+") and radius = "+radius;
    }
}
