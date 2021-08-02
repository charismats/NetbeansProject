/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiling.src;

/**
 *
 * @author CHAR0
 */
public class Tiling {
    public int doDP(int N){
        int[] DP = new int[N+1];
        for(int i = 1; i <= N; i++){
            if( i <= 2)
                DP[i] = i;
            else
                DP[i] = DP[i-1] + DP[i-2];
        }
        return DP[N];
    }
    
    public static void main(String[] args) {
        Tiling tile = new Tiling();
        int N = 4;
        System.out.println("Ways : " + tile.doDP(N));
    }
}
