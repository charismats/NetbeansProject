/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day01;

import java.util.Scanner;

/**
 *
 * @author CHAR0
 */
public class HelloJava {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama anda : ");
        String nama = sc.nextLine();
        System.out.println("Nama : " + nama);
        int umur = sc.nextInt();
        sc.nextLine();
        
        String name = "Charisma";
        name += "Tubagus";
        System.out.println(name);
        /*
        + = penjumlahan 
        - = pengurangan
        * = perkalian
        / = pembagian
        % = modulus
        */
        int a = 2*3;
        
        System.out.println("a = "+a);
        System.out.printf("Nama saya : %s\n", nama);
        /*
        comparison operator
        >
        <
        >= 
        <= 
        ==
        != 
        */
        String numStr = "5";
        int num = Integer.parseInt(numStr);
        
    }
}
