/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.staircase.src;

/**
 *
 * @author CHAR0
 */
public class Staircase {
    public int doDP(int N){
        int[] DP = new int[N+1];
        DP[0] = DP[1] = 1;
        for(int i = 2; i <= N; i++){
            DP[i] = DP[i-1] + DP[i-2];
        }
        return DP[N];
    }
    public static void main(String[] args) {
        Staircase st = new Staircase();
        int N = 5;
        System.out.println("Ways : " + st.doDP(N));
    }
}
