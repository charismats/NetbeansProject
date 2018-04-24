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
public class TwoDShape {
    private int cx;
    private int cy;

    public TwoDShape(){
        cx = cy = 0;
    }
    public TwoDShape(int x, int y){
        cx = x;
        cy = y;
    }
    
    public int getCx() {
        return cx;
    }

    public void setCx(int cx) {
        this.cx = cx;
    }

    public int getCy() {
        return cy;
    }

    public void setCy(int cy) {
        this.cy = cy;
    }
    
    public double getArea(){ return 0;}
    public double getKeliling() {return 0;}
}
