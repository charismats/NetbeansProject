/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day01;

import java.util.Scanner;
import java.util.*;

/**
 *
 * @author charisma
 */
public class HelloJava {

    public static void main(String[] args) {
//        System.out.println("Hello World");
//        System.out.println("Namaku Eve");

        Scanner sc = new Scanner(System.in);
//        System.out.print("Masukkan nama : ");
//        String name = sc.nextLine();
//        System.out.println("Nama yang tadi baru dimasukkan adalah " + name);
//        System.out.print("Masukkan umur : ");
//        int umur = Integer.parseInt(sc.nextLine());
//        System.out.println("Umurku adalah " + umur);

        int a = 10;
        int b = 3;
        int c = a + b;
        System.out.printf("%d + %d = %d\n", a, b, c);
        c = a - b;
        System.out.printf("%d - %d = %d\n", a, b, c);
        c = a * b;
        System.out.printf("%d * %d = %d\n", a, b, c);
        double d = 1.0 * a / b;
        System.out.printf("%d / %d = %f\n", a, b, d);
        c = a % b;
        System.out.printf("%d mod %d = %d\n", a, b, c);
        
        System.out.println("Masukkan alas ?");
        int alas = sc.nextInt();
        System.out.println("Masukkan Tinggi ?");
        int tinggi = sc.nextInt();
        double luas = 0.5 * alas * tinggi;
        System.out.println("luas  : " + luas);
        
        boolean f = 10 == 5;
        System.out.println("f = " + f);
        boolean g = 10 != 5;
        System.out.println("g = " + g);
        boolean h = 10 > 5;
        System.out.println("h = " + h);
        boolean i = 10 < 5;
        System.out.println("i = " + i);
        boolean j = 10 <= 5;
        System.out.println("j = " + j);
        boolean k = 10 >= 5;
	System.out.println("k = "+k);
    }
}
