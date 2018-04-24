/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day03;

import java.util.Random;

/**
 *
 * @author CHAR0
 */
public class Looping {
    public static void main(String[] args) {
        int i = 0;
        /*
        while( i < 10 ){
            System.out.println("i = "+i);
            i++;
        }
        i = 0;
        do{
            System.out.println("i = "+i);
            i++;
        }while( i < 10);
        
        for(i = 0; i < 10; i++){
            System.out.println("i = "+i);
        }*/
        for(int j = 0; j < 5; j++){
            System.out.println("*");
        }
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k <= j; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5-j; k++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2*j+1; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for(int j = 0; j < 5;j++){
            for(int k = 0 ; k <= j; k++){
                if( (j+k) % 2 == 0)
                    System.out.print("A");
                else
                    System.out.print("B");
               
            }
             System.out.println();
        }
        /*
        Random rand = new Random();
        for(int j = 0; j < 10; j++){
            int r = rand.nextInt(100) + 1;
            while( r % 2 == 1)
                r = rand.nextInt(100) + 1;
            System.out.println("r = "+r);
        }*/
        int n = 0;
        for(i = 0; i < 5; i++){
            for(int j = 0; j <= i; j++){
                System.out.print(n + " ");
                n += 2;
            }
            System.out.println("");
        }
    }
}
