/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.paladin;

import java.util.HashMap;

/**
 *
 * @author charisma
 */
public class LongestCommonSubstring {
    private String text;
    private HashMap<Character, Integer> mapLongest;
    public LongestCommonSubstring(String value){
        text = value;
        mapLongest = new HashMap<Character, Integer>();
    }
    
    public void RunAlgorithm(){
        int length = text.length();
        for(int i = 0; i < length-1; ){
            char c1 = text.charAt(i);
            char c2 = text.charAt(i+1);
            
            String longString = "" + c1;
            int longest = 1;
            
            while( c1 == c2){
                longString += c2;
                c1 = c2;
                longest++;
                i++;
                c2 = text.charAt(i+1);
            }
            if( !mapLongest.containsKey(c1)){
                mapLongest.put(c1, longest);
            }else{
                mapLongest.put(c1, Math.max(longest, mapLongest.get(c1)));
            }
            System.out.println("Longest substring : " + longString);
            if( longest == 1)
                i++;
        }
        
        for(Character c : mapLongest.keySet()){
            System.out.println("Key : "+c +", Value : "+mapLongest.get(c));
        }
    }
    public static void main(String[]args){
        
        LongestCommonSubstring lcs = new LongestCommonSubstring("aaAAaaaabbcdcdc");
        lcs.RunAlgorithm();
    }
}
