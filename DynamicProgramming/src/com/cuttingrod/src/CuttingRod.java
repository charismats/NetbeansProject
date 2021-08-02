/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuttingrod.src;

/**
 *
 * @author CHAR0
 */
public class CuttingRod {
    private int[] lengths = {1,2,3,4,5,6,7,8};
    private int[] price = {1,5,8,9,10,17,17,20};
    public int doDP(int L){
        int[] Soln = new int[L+1];
        Soln[0] = 0;
        for(int i = 1; i <= L; i++){
            for(int j = 0; j < lengths.length; j++){
                if( i >= lengths[j] && Soln[i] < Soln[i-lengths[j]] + price[j]){
                    Soln[i] = Soln[i-lengths[j]] + price[j];
                }
            }
        }
        return Soln[L];
    }
    public static void main(String[] args) {
        CuttingRod cr = new CuttingRod();
        int L = 5;
        int MaximumPrice = cr.doDP(L);
        System.out.println("Maximum Price : "+MaximumPrice);
    }
}
