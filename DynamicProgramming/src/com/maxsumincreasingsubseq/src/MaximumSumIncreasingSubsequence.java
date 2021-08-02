/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maxsumincreasingsubseq.src;

/**
 *
 * @author CHAR0
 */
public class MaximumSumIncreasingSubsequence {
    public int doDP(int[] array){
        int[] msis = new int[array.length];
        for(int i = 0; i < array.length; i++){
            msis[i] = array[i];
        }
        for(int i = 1; i < array.length; i++){
            for(int j = 0; j < i ; j++){
                if( array[i] > array[j] && msis[i] < msis[j] + array[i])
                    msis[i] = msis[j] + array[i];
            }
        }
        int maxsum = -1;
        for(int n : msis)
            if( maxsum < n)
                maxsum = n;
        return maxsum;
    }
    public static void main(String[] args) {
        MaximumSumIncreasingSubsequence msis = new MaximumSumIncreasingSubsequence();
        int [] sequence = {1,101,2,3,100,4,5};
        int maxsum = msis.doDP(sequence);
        System.out.println("Maximum sum increasing subsequence : "+maxsum);
    }
}
