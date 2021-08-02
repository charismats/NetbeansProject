/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pemanasan4;

import java.util.Scanner;

/**
 *
 * @author CHAR0
 */
public class ProdukUnik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = sc.nextInt();
        int max = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        int cA = 0, cB = 0, cC = 0;
        for(int i = min; i<=max;i++){
            if( i % A == 0 && i % B != 0 && i % C != 0)
                cA++;
            else if(i % A != 0 && i % B == 0 && i % C != 0)
                cB++;
            else if(i % A != 0 && i % B != 0 && i % C == 0)
                cC++;
        }
        int total = cA+cB+cC;
        System.out.println(total);
    }
}
