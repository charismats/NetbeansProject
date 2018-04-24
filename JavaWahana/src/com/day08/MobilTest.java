/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day08;

/**
 *
 * @author CHAR0
 */
public class MobilTest {
    public static void main(String[] args) {
        //Membuat object m1 dari kelas Mobil
        Mobil m1 = new Mobil();
        //Mengubah properties dari m1
        m1.setMerk("Honda");
        m1.setNama_pemilik("Charisma");
        m1.setWarna("Biru");
        m1.setTahun(2010);
        m1.sayHello();
        System.out.println("Merk mobil = "+m1.getMerk());
        
        Mobil m2 = new Mobil("Daihatsu", "Charisma", "Hitam", 2009);
        m2.sayHello();
        int r = 3;
        double luas = Math.PI * r * r;
        
    }
}
