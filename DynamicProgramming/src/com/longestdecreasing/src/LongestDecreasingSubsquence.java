/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.longestdecreasing.src;

import java.util.Arrays;

/**
 *
 * @author CHAR0
 */
public class LongestDecreasingSubsquence {
     public int doDP(int[] arr){
        int[] Soln = new int[arr.length];
        Arrays.fill(Soln,1);
        
        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if( arr[i] < arr[j] && Soln[i] < Soln[j] + 1){
                    Soln[i] = Soln[j] + 1;
                }
            }
        }
        int LDS = -1;
        for(int num: Soln){
            if(LDS < num)
                LDS = num;
        }
        return LDS;
    }
    
    public static void main(String[] args) {
        int[] sequence = {10, 22, 9, 33, 8, 50, 7, 60};
        LongestDecreasingSubsquence lds = new LongestDecreasingSubsquence();
        
        int LDS = lds.doDP(sequence);
        System.out.println("LDS : " + LDS);
    }
}
