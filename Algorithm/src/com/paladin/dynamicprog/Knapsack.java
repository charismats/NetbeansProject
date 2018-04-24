/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paladin.dynamicprog;

/**
 *
 * @author CHAR0
 */
public class Knapsack {

    private int[] w = {2, 3, 4, 5};
    private int[] b = {3, 4, 5, 6};
    private int[][] Dict;

    public int runAlgorithm(int M) {
        Dict = new int[w.length + 1][M + 1];
        for(int j = 0; j < Dict[0].length; j++)
            Dict[0][j] = 0;
            
        for (int i = 1; i < Dict.length; i++) {
            for (int j = 0; j < Dict[0].length; j++) {
                if( j >= w[i-1]){
                    Dict[i][j] = Math.max(Dict[i - 1][j], Dict[i - 1][j - w[i-1]] + b[i-1]);
                }else{
                    Dict[i][j] = Dict[i-1][j];
                }
            }
        }
        printDictionary();
        return Dict[w.length][M];
    }

    private void printDictionary() {
        for (int i = 0; i < Dict.length; i++) {
            for (int j = 0; j < Dict[0].length; j++) {
                System.out.print(Dict[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Knapsack k = new Knapsack();
        int max_benefit = k.runAlgorithm(5);
        System.out.println("Max Benefit = " + max_benefit);
    }
}
