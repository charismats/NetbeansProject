/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maxsumsubsequence.src;

/**
 *
 * @author CHAR0
 */
public class MaximumSumSubsequence {
    public int doDP(int[]arr){
        int[] SumSub = new int[arr.length];
        SumSub[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            SumSub[i] = Math.max(SumSub[i-1] + arr[i], arr[i]);
        }
        return SumSub[arr.length-1];
    }
    public static void main(String[] args) {
        MaximumSumSubsequence mss = new MaximumSumSubsequence();
        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
        int maxSum = mss.doDP(arr);
        System.out.println("MaxSumSubsequence : "+maxSum);
    }
}
