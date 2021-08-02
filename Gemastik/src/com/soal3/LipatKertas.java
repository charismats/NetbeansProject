/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soal3;

import java.util.Scanner;

/**
 *
 * @author CHAR0
 */
public class LipatKertas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int [] panjang = new int[n];
        int [] lebar = new int[n];
        int [] kali = new int[n];
        
        for(int i = 0; i < n; i++){
            panjang[i] = sc.nextInt();
            lebar[i] = sc.nextInt();
            kali[i] = sc.nextInt();
        }
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < kali[i]; j++){
                if( panjang[i] > lebar[i]){
                    panjang[i] /= 2;
                }else
                    lebar[i] /= 2;
            }
            if(panjang[i] > lebar[i])
                System.out.println(panjang[i] + " " + lebar[i]);
            else
                System.out.println(lebar[i] + " " + panjang[i]);
        }
        
    }
}
