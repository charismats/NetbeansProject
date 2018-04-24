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
public class Triangle extends TwoDShape{
    private int alas;
    private int tinggi;
    private int sisi1;
    private int sisi2;
    private int sisi3;

    public int getSisi1() {
        return sisi1;
    }

    public void setSisi1(int sisi1) {
        this.sisi1 = sisi1;
    }

    public int getSisi2() {
        return sisi2;
    }

    public void setSisi2(int sisi2) {
        this.sisi2 = sisi2;
    }

    public int getSisi3() {
        return sisi3;
    }

    public void setSisi3(int sisi3) {
        this.sisi3 = sisi3;
    }
    
    public Triangle(){
        super(0,0);
        alas = tinggi = sisi1 = sisi2 = sisi3 = 1;
    }
    public Triangle(int a, int t){
        alas = a;
        tinggi = t;
    }
    
    public int getAlas() {
        return alas;
    }

    public void setAlas(int alas) {
        this.alas = alas;
    }

    public int getTinggi() {
        return tinggi;
    }
    
    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }
    
    @Override
    public double getArea() {
        return 0.5 * alas * tinggi;
    }
    
    @Override 
    public double getKeliling(){
        return sisi1 + sisi2 + sisi3;
    }
    
    @Override
    public String toString(){
        return "center at ("+getCx()+","+getCy()+") and alas = "+ alas + ", tinggi = "+tinggi;
    }
}
