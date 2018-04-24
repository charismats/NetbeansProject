/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paladin.compression;

/**
 *
 * @author CHAR0
 */
public class RunLengthEncoding {
    public String encode(String text){
        String encoded = "";
        int count = 0;
        char enc = ' ';
        for(int i = 0; i < text.length(); i++){
            if( i == 0){
                count = 1;
                enc = text.charAt(i);
            }else{
                if( text.charAt(i) == text.charAt(i-1)){
                    count++;
                }else{
                    encoded += count + "" + enc;
                    count = 1;
                    enc = text.charAt(i);
                }
            }
        }
        encoded += count + "" + enc;
        return encoded;
    }
    public String decode(String text){
        String decoded = "";
        for(int i = 0; i < text.length() ; i+=2){
            int count = Integer.parseInt(text.charAt(i) + "");
            char c = text.charAt(i+1);
            for(int j = 0; j < count ; j++){
                decoded += "" + c;
            }
        }
        return decoded;
    }
    public static void main(String[] args) {
        RunLengthEncoding rle = new RunLengthEncoding();
        String encoded = rle.encode("aaaaabbbcccr");
        System.out.println("Encoded = "+encoded);
        encoded = rle.encode("001110001111");
        System.out.println("Encoded = "+encoded);
        String decoded = rle.decode(encoded);
        System.out.println("Decoded = "+decoded);
    }
}
