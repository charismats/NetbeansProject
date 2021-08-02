/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.longestcommonsubstr.src;

/**
 *
 * @author CHAR0
 */
public class LongestCommonSubstring {
    public int doDP(String A, String B){
        int longest = 0;
        int[][] lcs = new int[A.length()+1][B.length()+1];
        for(int i = 1; i <= A.length(); i++){
            for(int j = 1; j <= B.length(); j++){
                if( A.charAt(i-1) == B.charAt(j-1)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                    if( longest < lcs[i][j])
                        longest = lcs[i][j];
                }else{
                    lcs[i][j] = 0;
                }
            }
        }
//        for(int i = 0; i <= A.length(); i++){
//            for(int j = 0; j <= B.length(); j++){
//                System.out.print(lcs[i][j] + " ");
//            }
//            System.out.println("");
//        }
        return longest;
    }
    public static void main(String[] args) {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        String A = "emilyioe";
        String B = "familyone";
        int longest = lcs.doDP(A, B);
        System.out.println("Longest Common Substring : "+longest);
    }
}
