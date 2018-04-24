/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paladin.src;

/**
 *
 * @author CHAR0
 */
public class RomawiDecimal {
    private final String[] rom = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD","D", "CM", "M"};
    private final int[] dec ={1,4,5,9,10,40,50,90,100,400,500,900,1000}; 
    public String decToRomawi(long num){
        String roms = "";
        for (int i = rom.length-1; i >= 0; i--) {
            while( num >= dec[i]){
                roms += rom[i];
                num -= dec[i];
            }
            
        }
        return roms;
    }
    public long romtoDecimal(String roms){
        long num = 0;
        for(int i = 0; i < roms.length(); i++){
            String depanStr = roms.charAt(i) + "";
            int depanInt = getDec(depanStr);
            if( i > 0){
                String belakangStr = roms.charAt(i-1) + "";
                int belakangInt = getDec(belakangStr);
                if( belakangInt < depanInt){
                    num -= belakangInt;
                    num += (depanInt - belakangInt);
                }else{
                    num += depanInt;
                }
            }else{
                num += depanInt;
            }
        }
        return num;
    }
    public int getDec(String a){
        int decimal = 0;
        for(int i = 0; i < rom.length;i++){
            if( rom[i].equals(a)){
                decimal = dec[i];
                break;
            }
        }
        return decimal;
    }
    public static void main(String[] args) {
        RomawiDecimal romDec = new RomawiDecimal();
        String roms = romDec.decToRomawi(24);
        System.out.println("Rom = "+roms);
        long decimal = romDec.romtoDecimal(roms);
        System.out.println("Dec = "+decimal);
    }
}
