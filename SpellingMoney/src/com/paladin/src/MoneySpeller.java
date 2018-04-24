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
public class MoneySpeller {
    private String[] number = {"se", "satu", "dua", "tiga", "empat", "lima", "enam", "tujuh", "delapan", "sembilan"};
    private String[] satuan = {"satuan","puluh","ratus", "ribu","juta", "milyar"};
    public String Spell(long num){
        String spell = "";
        long divisor = 1000000000;
        int idxDivisor = 5;
        int pembagi = 100;
        int idxSatuan = 2;
        boolean satu = false;
        if ( num == 1){
            satu = true;
        }
        while( num > 0){
            if( num >= divisor){
                if( divisor == 0)
                    break;
                long sisaNum = num / divisor;
                String spellPart = Spell(sisaNum);
                num %= divisor;
                if( divisor != 1)
                    spell += spellPart + satuan[idxDivisor]+ " ";
                else
                    spell += spellPart +  " ";
            }else if( num < 1000){
                
                if(num >= 11 && num <= 19){
                    int digit = (int) num % 10;
                    if( digit != 1)
                        spell += number[digit] + " belas ";
                    else
                        spell += number[0] +  "belas ";
                    num = 0;
                }else{
                    int digit = (int)num / pembagi;
                    
                    if( digit != 0){
                        if( digit != 1 && pembagi > 1)
                            spell += number[digit] + " "+ satuan[idxSatuan] + " ";
                        else if( digit == 1 && pembagi > 1)
                            spell += number[0] + satuan[idxSatuan] +  " ";
                        else
                            spell += number[digit] + " ";
                    }
                }
                
                
                idxSatuan--;
                num %= pembagi;
                pembagi /= 10;
               
            }
            divisor /= 1000;
            idxDivisor--;
        }
        return spell;
    }
    
    public static void main(String[] args) {
        MoneySpeller ms = new MoneySpeller();
        System.out.println(ms.Spell(1121111111));
    }
}
