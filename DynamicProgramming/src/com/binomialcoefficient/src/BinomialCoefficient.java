/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.binomialcoefficient.src;

/**
 *
 * @author CHAR0
 */
public class BinomialCoefficient {
    public int doDP(int N, int K){
        int[][] Binom  = new int[N+1][K+1];
        for(int i = 0; i <= N; i++){
            for(int j = 0 ; j <= Math.min(i, K); j++){
                if( j == 0 || j == i)
                    Binom[i][j] = 1;
                else
                    Binom[i][j] = Binom[i-1][j-1] + Binom[i-1][j];
            }
        }
        return Binom[N][K];
    }
    public static void main(String[] args) {
        BinomialCoefficient bc = new BinomialCoefficient();
        int N = 3;
        int K = 2;
        System.out.println("Binom : " + bc.doDP(N, K));
    }
}
