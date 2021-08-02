/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soal5;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author CHAR0
 */
public class BarisPangkat {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            a[i] = (int)Math.pow(a[i], i+1);
            System.out.println(a[i]);
        }
        
        BigInteger bigPow = new BigInteger(a[0] + "");
        for(int i = 1; i < n; i++){
            bigPow = bigPow.pow(a[i]);
        }
        System.out.println(bigPow);
        BigInteger result = bigPow.mod(new BigInteger("100000037"));
        System.out.println(result);
    }
}
