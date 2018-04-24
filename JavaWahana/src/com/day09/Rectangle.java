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
public class Rectangle extends TwoDShape{

    private double panjang;
    private double lebar;

    public Rectangle(double p, double l){
        panjang = p;
        lebar = l;
    }
    
    public double getPanjang() {
        return panjang;
    }

    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    public double getLebar() {
        return lebar;
    }

    public void setLebar(double lebar) {
        this.lebar = lebar;
    }
    
    @Override
    public double hitungKeliling() {
        return 2 * (panjang + lebar);
    }

    @Override
    public double hitungLuas() {
        return panjang * lebar;
    }

    @Override
    public String toString() {
        return super.toString() + " Panjang = "+ panjang + " Lebar = "+lebar; //To change body of generated methods, choose Tools | Templates.
    }
    
}
