/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paladin.dynamicprog;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author CHAR0
 */
public class MoneyChange {
    private int[] coin = {2,3,5,6};
    public int countMoneyChange(int n){
        int[] change = new int[n+1];
        change[0] = 0;
        int idx = 0;
        for(int i = 1; i < change.length; i++){
            for(int j = 0; j < coin.length; j++){
                if( i >= coin[j] ){
                    if( i - coin[j] != 0 && change[i-coin[j]] != 0)
                        change[i]++;
                    else if( i-coin[j] == 0)
                        change[i]++;
                }
            }
        }
        return change[n];
    }
     public long countWays(int n){
        long[]table = new long[n+1];
        Arrays.fill(table, 0);
        int m = coin.length;
        table[0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = coin[i]; j <= n; j++){
                table[j] += table[j - coin[i]];
                System.out.print("S["+i+"] = "+ coin[i]);
                System.out.println("table["+j+"] = "+table[j]);
            }
        }
        return table[n];
    }
     
    public static void main(String[] args) {
        MoneyChange mc = new MoneyChange();
        //int count = mc.countMoneyChange(5);
        long count = mc.countWays(5);
        System.out.println("count = "+count);
    }
}

class Solution{
    public ArrayList<Integer> coins = new ArrayList<>();
}
