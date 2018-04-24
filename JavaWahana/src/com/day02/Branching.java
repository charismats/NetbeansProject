/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day02;

/**
 *
 * @author CHAR0
 */
import java.util.Random;
import java.util.Scanner;

public class Branching {
    public static void main(String[] args) {
        System.out.println("Branching Lesson");
        int a = 4;
        if( a == 3)
            System.out.println("a sama dengan 3");
        else if( a == 1 )
            System.out.println("a sama dengan 1");
        else if( a == 2){
            System.out.println("a = 2");
        }
        else if( a == 4)
            System.out.println("a = 4");
        
        Random r = new Random();
        int rand = r.nextInt(10);
        System.out.println("random number = "+ rand);
        
        int sw = 10;
        switch(sw){
            case 1:
                System.out.println("sw = 1");
                break;
            case 2:
                System.out.println("sw = 2");
                break;
            case 3:
                System.out.println("sw = 3");
                break;
            case 4:
                System.out.println("sw = 4");
                break;
            default:
                System.out.println("sw lebih dari 4");
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan grade anda: ");
        String grade = sc.nextLine();
        System.out.println("grade = "+grade);
        switch(grade){
            case "A":case "a":
                System.out.println("nilai anda 85 -100");
                break;
            case "B":case "b":
                System.out.println("nilai anda 70 - 84");
                break;
        }
        
        System.out.println("Masukkan nilai anda: ");
        int nilai = sc.nextInt();
        
        if( nilai >= 85 && nilai <= 100){
            System.out.println("Grade A");
        }else if( nilai >= 70 && nilai <= 84){
            System.out.println("Grade B");
        }else if( nilai >= 60 && nilai <= 69){
            System.out.println("Grade C");
        }else{
            System.out.println("Grade D");
        }
    }
}
