/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knapsack.src;

/**
 *
 * @author CHAR0
 */
public class Knapsack {
    private int[] weights = {5,10,3,12};
    private int[] values = {10,40,50,75};
    
    public int doDP(int W, int N){
        int [][] Soln = new int[N+1][W+1];
        for(int i = 0; i <= N; i++){
            for(int w = 0 ; w <= W; w++){
                if( i == 0 || w == 0){
                    Soln[i][w] = 0;
                }else if ( weights[w-1] <= w){
                    Soln[i][w] = Math.max(values[i-1] + Soln[i-1][w-weights[i-1]], Soln[i-1][w]);
                }else{
                    Soln[i][w] = Soln[i-1][w];
                }
            }
        }
        return Soln[N][W];
    }
    
    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int W = 20;
        int N = 3;
        int KS = ks.doDP(W, N);
        System.out.println("Knapsack = " + KS);
    }
}
