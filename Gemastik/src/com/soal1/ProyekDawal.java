/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soal1;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author CHAR0
 */
public class ProyekDawal {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        Inputan [] inputs = new Inputan[num];
        for(int i = 0; i < num; i++){
            Inputan input = new Inputan();
            input.kota1 = sc.next();
            input.x1 = sc.nextInt();
            input.y1 = sc.nextInt();
            input.r1 = sc.nextInt();
            input.kota2 = sc.next();
            input.x2 = sc.nextInt();
            input.y2 = sc.nextInt();
            input.r2 = sc.nextInt();
            
            inputs[i] = input;
            inputs[i].calculateDist();
        }
        
        Arrays.sort(inputs);
        for(int i = inputs.length-1; i>= 0; i--){
            System.out.println(inputs[i].kota1 + " " + inputs[i].kota2 + " " + (int)inputs[i].dist);
        }
    }
    private static class Inputan implements Comparable<Inputan>{
        String kota1, kota2;
        int x1, x2;
        int y1, y2;
        int r1, r2;
        double dist;
        @Override
        public int compareTo(Inputan o) {
            if( dist < o.dist)
                return -1;
            if( dist > o.dist)
                return 1;
            return 0;
        }
        
        public void calculateDist(){
            dist = Math.hypot(x2-x1, y2-y1);
        }
        
        
    }
}
