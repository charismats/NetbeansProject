/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.partition.src;

/**
 *
 * @author CHAR0
 */
public class Partition {
    public boolean doDP(int [] arr){
        int sum = 0;
        for(int n : arr)
            sum += n;
        if( sum %2 != 0)
            return false;
        
        boolean [][] Soln = new boolean[arr.length+1][sum / 2 + 1];
        for(int i = 0; i <= arr.length; i++){
            Soln[i][0] = true;
        }
        for(int j = 1; j < Soln[0].length; j++)
            Soln[0][j] = false;
        
        for(int i = 1; i < Soln.length; i++){
            for(int j = 1; j < Soln[0].length; j++){
                if( j >= arr[i-1])
                    Soln[i][j] = Soln[i-1][j] || Soln[i-1][j-arr[i-1]];
                else
                    Soln[i][j] = Soln[i-1][j];
            }
        }
        return Soln[arr.length][sum/2];
    }
    public static void main(String[] args) {
        Partition part = new Partition();
        int[]arr = {3,1};
        boolean canPartition = part.doDP(arr);
        System.out.println("Can partition : "+canPartition);
    }
}
