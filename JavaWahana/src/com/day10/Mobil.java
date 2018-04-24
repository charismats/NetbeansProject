/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day10;

import com.day08.*;

/**
 *
 * @author CHAR0
 */
public class Mobil {

    private String merk;
    private String nama_pemilik;
    private String warna;
    private int tahun;
    
    //Constructor
    public Mobil(){
        this.merk = "Honda";
        this.nama_pemilik ="Charisma";
        this.warna = "biru";
        this.tahun = 2010;
    }
    
    public Mobil(String m, String n, String w, int t){
        merk = m;
        nama_pemilik = n;
        warna = w;
        tahun = t;
    }
    
    public void info(){
        System.out.println("Hello from mobil");
        System.out.println("Merk : " + merk);
        System.out.println("Nama Pemilik : "+nama_pemilik);
        System.out.println("Warna : "+warna);
        System.out.println("Tahun : "+tahun);
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getNama_pemilik() {
        return nama_pemilik;
    }

    public void setNama_pemilik(String nama_pemilik) {
        this.nama_pemilik = nama_pemilik;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }
    
    public String getWarna(){
        return warna;
    }
    public void setWarna(String warna){
        this.warna = warna;
    }
}


