/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mincoinchange.src;

import java.util.Arrays;

/**
 *
 * @author CHAR0
 */
public class MinimumCoinChange {
    private int[] coins = {1,5,10,20,50};
    public int doDP(int N){
        int [] Soln = new int[N+1];
        Arrays.fill(Soln, 1000);
        Soln[0] = 0;
        Soln[1] = 1;
        
        for(int i = 2; i<= N; i++){
            for(int j = 0; j < coins.length; j++){
                if( i >= coins[j] && Soln[i] > Soln[i-coins[j]] + 1){
                    Soln[i] = Soln[i-coins[j]] + 1;
                }
            }
        }
//        for(int sol : Soln){
//            System.out.println(sol);
//        }
        return Soln[N];
    }
    public static void main(String[] args) {
        MinimumCoinChange mcc = new MinimumCoinChange();
        int N = 10;
        int minCoins = mcc.doDP(N);
        System.out.println("Minimum Coin Change : " + minCoins);
    }
}
