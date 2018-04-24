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
public class Rectangle extends TwoDShape{
    private int panjang;
    private int lebar;

    public Rectangle(){
        super(0,0);
        panjang = lebar = 1;
    }
    public Rectangle(int p, int l){
        super(0,0);
        panjang = p;
        lebar = l;
    }
    public int getPanjang() {
        return panjang;
    }

    public void setPanjang(int panjang) {
        this.panjang = panjang;
    }

    public int getLebar() {
        return lebar;
    }

    public void setLebar(int lebar) {
        this.lebar = lebar;
    }
    
    @Override
    public double getArea(){
        return panjang * lebar;
    }
    @Override 
    public double getKeliling(){
        return 2 * (panjang + lebar);
    }
    
     @Override
    public String toString(){
        return "center at ("+getCx()+","+getCy()+") and panjang = "+ panjang + ", lebar = "+lebar;
    }
}
