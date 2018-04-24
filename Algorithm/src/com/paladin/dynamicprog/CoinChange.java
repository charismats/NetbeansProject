/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paladin.dynamicprog;

import java.util.Arrays;

/**
 *
 * @author CHAR0
 */
public class CoinChange {
    int[] coin = {1,2,3,5};
    int [] min_coin;
    
    public void runAlgorithm(int n){
        min_coin = new int[n+1];
        Arrays.fill(min_coin, 1000);
        min_coin[0] = 0;
        
        for(int i = 1; i < min_coin.length;i++){
            for(int j = 0; j < coin.length; j++){
                int c = coin[j];
                if( i >= c && min_coin[i - c] + 1 < min_coin[i]){
                    min_coin[i] = min_coin[i-c] + 1;
                }
            }
        }
        print_min_coin();
        //return min_coin[n];
    }
    
    public void print_min_coin(){
        for(int i = 0; i < min_coin.length; i++){
            System.out.println("min_coin["+i+"] = "+min_coin[i]);
        }
    }
    
    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        cc.runAlgorithm(10);
    }
}
