/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.longestincreasing.src;

import java.util.Arrays;

/**
 *
 * @author CHAR0
 */
public class LongestIncreasingSubsequence {
    public int doDP(int[] arr){
        int[] Soln = new int[arr.length];
        Arrays.fill(Soln,1);
        
        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if( arr[i] > arr[j] && Soln[i] < Soln[j] + 1){
                    Soln[i] = Soln[j] + 1;
                }
            }
        }
        int LIS = -1;
        for(int num: Soln){
            if(LIS < num)
                LIS = num;
        }
        return LIS;
    }
    
    public static void main(String[] args) {
        int[] sequence = {10, 22, 9, 33, 21, 50, 41, 60};
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        
        int LIS = lis.doDP(sequence);
        System.out.println("LIS : " + LIS);
    }
}
