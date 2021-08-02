/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.editdistance.src;

/**
 *
 * @author CHAR0
 */
public class MinimumEditDistance {
    
    public int doDP(String A, String B){
        int[][] ED = new int[A.length() + 1][B.length() + 1];
        for(int i = 0; i <= A.length(); i++){
            for(int j = 0 ; j <= B.length(); j++){
                if( i == 0){
                    ED[i][j] = j;
                }
                else if( j == 0){
                    ED[i][j] = i;
                }
                else if( A.charAt(i-1) == B.charAt(j-1)){
                    ED[i][j] = ED[i-1][j-1];
                }else{
                    ED[i][j] = 1 + Math.min(ED[i-1][j], Math.min(ED[i][j-1], ED[i-1][j-1]));
                }
            }
        }
        return ED[A.length()][B.length()];
    }
    public static void main(String[] args) {
        MinimumEditDistance med = new MinimumEditDistance();
        String A = "CART";
        String B = "MARCH";
        int minED = med.doDP(A, B);
        System.out.println("Minimum Edit Distance : "+minED);
    }
    
}
