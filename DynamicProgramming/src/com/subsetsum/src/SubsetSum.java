/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.subsetsum.src;

/**
 *
 * @author CHAR0
 */
public class SubsetSum {
    public boolean doDP(int[]arr, int Sum){
        
        boolean [][] DP = new boolean[arr.length+1][Sum+1];
        for(int i = 0; i <= arr.length; i++){
            DP[i][0] = true;
        }
        for(int i = 1; i <= arr.length; i++){
            for(int j = 1; j <= Sum; j++){
                if( arr[i-1] <= j)
                    DP[i][j] = DP[i-1][j] || DP[i-1][j-arr[i-1]];
                else
                    DP[i][j] = DP[i-1][j];
            }
        }
        return DP[arr.length][Sum];
    }
    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int [] arr = {3,34,4,12,5,2};
        boolean subsetFound = ss.doDP(arr, 7);
        System.out.println("Subset Sum : "+subsetFound);
    }
}
