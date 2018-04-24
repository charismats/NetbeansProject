/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day10;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author CHAR0
 */
public class MobilIO {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("mobil.txt"));
            int n = Integer.parseInt(br.readLine());
            Mobil [] mobils = new Mobil[n];
            for(int i = 0; i < mobils.length; i++){
                String nama = br.readLine();
                String merk = br.readLine();
                String warna = br.readLine();
                int tahun = Integer.parseInt(br.readLine());
                mobils[i] = new Mobil(merk, nama, warna, tahun);
                
            }
            for(Mobil m : mobils){
                m.info();
            }
        } catch (Exception e) {
        }
    }
}
