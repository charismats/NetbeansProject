/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day04;

import java.util.Random;
import java.util.Scanner;
import java.util.Hashtable;

/**
 *
 * @author CHAR0
 */
public class Array {
    public static void main(String[] args) {
        /*
        //1. cara 1 mendeklarasikan array
        int [] arr = new int[5];
        arr[0] = 2;
        arr[1] = 1;
        arr[2] = 3;
        arr[3] = 1;
        arr[4] = 5;
        for (int i = 0; i < arr.length; i++) {
            int j = arr[i];
            System.out.println(j);
        }
        //2. cara 2 mendeklarasikan array
        int [] arr2 = {1,3,4,1,2,1};
        for (int i = 0; i < arr2.length; i++) {
            int j = arr2[i];
            System.out.println(j);
            
        }
        Random r = new Random();
        int [] arr3 = new int[5];
        for (int i = 0; i < arr3.length; i++) {
            int j = r.nextInt(10) + 1;
            arr3[i] = j;
            System.out.println(j);
            
        }
        Scanner sc = new Scanner(System.in);
        String names[] = new String[5];
        int lengthNames[] = new int[5];
        
        for(int i = 0; i < names.length; i++){
            System.out.println("Masukkan nama anda : ");
            names[i] = sc.nextLine().trim();
            lengthNames[i] = names[i].length();
        }
        for(String val: names){
            System.out.println(val + " " + val.length());
        }*/
        
        int [] genap = new int[5];
        int k = 0;
        for(int i = 1; i < 11; i++){
            if( i % 2 == 0){
                genap[k] = i;
                k++;
            }
        }
        for(int n : genap){
            System.out.println(n);
        }
        
        Hashtable<String, Object> hash = new Hashtable<String, Object>();
        hash.put("nama", "Charisma");
        hash.put("umur", 28);
        hash.put("alamat", "JL Mahesa Utara II / 419");
        hash.put("dob", "7 Maret 1988");
        
        for(String key: hash.keySet()){
            System.out.println(key + "=>" + hash.get(key));
        }
        int [] nilai = {90,80, 70, 60, 90};
        
    }
}
