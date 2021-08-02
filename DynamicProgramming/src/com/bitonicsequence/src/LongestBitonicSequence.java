/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitonicsequence.src;

import java.util.Arrays;

/**
 *
 * @author CHAR0
 */
public class LongestBitonicSequence {

    public int doDP(int[] sequence) {
        int[] lis = new int[sequence.length];
        int[] lds = new int[sequence.length];
        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        //find lis
        for (int i = 1; i < sequence.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        //find lds

        for (int i = sequence.length-2; i >= 0; i--) {
            for (int j = sequence.length-1; j > i; j--) {
                if (sequence[i] > sequence[j] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                }
            }
        }
        //lis
        System.out.println("LIS : ");
        for(int n : lis){
            System.out.print(n + " ");
        }
        System.out.println("");
        //lds
        System.out.println("LDS : ");
        for(int n : lds){
            System.out.print(n + " ");
        }
        System.out.println("");
        int maxBitonic = lis[0] + lds[0];
        for(int i = 0; i < lis.length; i++){
            if( maxBitonic < lis[i] + lds[i] )
                maxBitonic = lis[i] + lds[i];
        }
        return maxBitonic;
    }

    public static void main(String[] args) {
        LongestBitonicSequence lbs = new LongestBitonicSequence();
        int[] sequence = { 2, 1, 3, 5, 3, 2,2,1};
        int longestBitonic = lbs.doDP(sequence);
        System.out.println("Longest Bitonic Sequence : "+ longestBitonic);
    }
}
