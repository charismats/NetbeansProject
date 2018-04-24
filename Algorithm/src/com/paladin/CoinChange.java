/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paladin;

import java.util.Arrays;

/**
 *
 * @author Dosen-User
 */
public class CoinChange {
    public long countWays(int S[], int m, int n){
        long[]table = new long[n+1];
        Arrays.fill(table, 0);
        table[0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = S[i]; j <= n; j++){
                table[j] += table[j - S[i]];
                System.out.print("S["+i+"] = "+ S[i]);
                System.out.println("table["+j+"] = "+table[j]);
            }
        }
        return table[n];
    }
    public static void main(String[]args){
        int coin[] = {2,3,5,6};
        int m = coin.length;
        int n = 5;
        CoinChange cc = new CoinChange();
        System.out.println(cc.countWays(coin, m, n));
    }
}
