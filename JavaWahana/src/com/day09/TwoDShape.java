/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day09;

/**
 *
 * @author CHAR0
 */
public class TwoDShape {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public double hitungLuas(){
        return 0.0;
    }
    public double hitungKeliling(){
        return 0;
    }
    
    @Override
    public String toString() {
        return " X = "+ x + " Y = "+y; //To change body of generated methods, choose Tools | Templates.
    }
}
