/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.longestcommonsubseq.src;

/**
 *
 * @author CHAR0
 */
public class LongestCommonSubsequence {
    public String lcsStr = "";
    public int doDP(String A, String B){
        int[][] lcs = new int[A.length()+1][B.length()+1];
        
        for(int i = 0; i <= A.length(); i++){
            for(int j = 0; j <= B.length(); j++){
                if( i == 0 || j == 0){
                    lcs[i][j] =0;
                }else if ( A.charAt(i-1) == B.charAt(j-1)){
                    lcs[i][j] = lcs[i-1][j-1]+1;
                }else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        getLCS(lcs,A,B);
        return lcs[A.length()][B.length()];
    }
     private void getLCS(int[][] lcs, String A, String B){
        lcsStr = "";
        int i = A.length();
        int j = B.length();
        
        while( i > 0 && j > 0){
            if( A.charAt(i-1) == B.charAt(j-1) ){
                lcsStr = A.charAt(i-1) + lcsStr;
                i--;
                j--;
            }else if ( lcs[i-1][j] > lcs[i][j-1]){
                i--;
            }else {
                j--;
            }
        }
    }
    public static void main(String[] args) {
        String A = "MXXXXAXXXNG";
        String B = "MYYYYAYYYN**G";
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println("LCS : " + lcs.doDP(A, B));
        System.out.println("LCS String : "+ lcs.lcsStr);
    }
}
