/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hexa.arithmetic;

/**
 *
 * @author CHAR0
 */
public class HexaArithmetic {
    private String[] hexa = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    public String toHexa(long number){
        String ret = "";
        while(number > 0){
           int dig = (int)(number % 16);
           number /= 16;
           ret = hexa[dig] + ret;
        }
        return ret;
    }
    
    public long toDecimal(String hexa){
        long ret = 0;
        long pow = 1;
        for(int i = hexa.length() - 1; i >= 0; i--){
            int dig = getDigit(hexa.charAt(i) + "");
            if( dig != -1){
                ret += pow * dig;
            }
            pow *= 16;
        }
        return ret;
    }
    
    public String addition(String hex1, String hex2){
        long des1 = toDecimal(hex1);
        long des2 = toDecimal(hex2);
        long total = des1 + des2;
        
        return toHexa(total);
        
    }
    
    public String subtraction(String hex1, String hex2){
        long des1 = toDecimal(hex1);
        long des2 = toDecimal(hex2);
        long res = des1 - des2;
        
        return toHexa(res);
    }
    
    public String multiplication(String hex1, String hex2){
        long des1 = toDecimal(hex1);
        long des2 = toDecimal(hex2);
        long res = des1 * des2;
        
        return toHexa(res);
    }
    
    public int getDigit(String a){
        for(int i = 0; i < hexa.length; i++){
            if( hexa[i].equalsIgnoreCase(a))
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        HexaArithmetic hex = new HexaArithmetic();
        String hexa = hex.toHexa(255);
        System.out.println(hexa);
        
        long desimal = hex.toDecimal("FF");
        System.out.println(desimal);
        
        String hexa1 = hex.addition("F", "F");
        System.out.println(hexa1);
        
        System.out.println(hex.subtraction("A17", "532"));
        System.out.println(hex.multiplication("EF3", "42"));
    }
}
