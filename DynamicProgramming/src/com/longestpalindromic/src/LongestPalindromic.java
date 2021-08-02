/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.longestpalindromic.src;

/**
 *
 * @author CHAR0
 */
public class LongestPalindromic {
    public int doDP(String text){
        int[][] LP = new int[text.length()][text.length()];
        for(int i = text.length()/2;i >= 0; i-- ){
            for(int j = text.length()/2; j < text.length(); j++){
                if( j == i+1 ){
                    if( text.charAt(i) == text.charAt(j))
                        LP[i][j] = 2;
                     else
                        LP[i][j] = 1;
                    
                }else if ( i == j){
                    LP[i][j] = 1;
                }
                else{
                    if( text.charAt(i) == text.charAt(j)){
                        LP[i][j] = LP[i+1][j-1] + 2;
                    }else{
                        LP[i][j] = Math.max(LP[i+1][j], LP[i][j-1]);
                    }
                    
                }
            }
        }
        return LP[0][text.length()-1];
    }
    public static void main(String[] args) {
        LongestPalindromic lp = new LongestPalindromic();
        String text = "YAXBXCBZAZY";
        int maxPalindrom = lp.doDP(text);
        System.out.println("MaxPalindrom : "+maxPalindrom);
    }
}
