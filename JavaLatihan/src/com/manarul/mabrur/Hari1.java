/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manarul.mabrur;

/**
 *
 * @author CHAR0
 */
public class Hari1 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        int a = 11;
        System.out.println("a = "+a);
        int alas = 10;
        int tinggi = 5;
        /*
        operator aritmatik:
        + 
        -
        *
        /
        %
        */
        int luas = alas * tinggi /2;
        System.out.println("luas = "+luas);
        int sisi = 4;
        int luas2 = sisi * sisi;
        System.out.println("luas persegi : "+luas2);
        if(a == 10){
            System.out.println("a sama dengan 10");
        }else{
            System.out.println("a tdk sama dengan 10");
        }
        if( a % 2 == 0){
            System.out.println("genap");
        }else{
            System.out.println("ganjil");
        }
        int i = 0;
        while(i < 5){
            System.out.println("i = "+i);
            i++;
        }
        i = 0;
        do{
            System.out.println("i = "+i);
            i++;
        }while(i < 5);
    }
}
