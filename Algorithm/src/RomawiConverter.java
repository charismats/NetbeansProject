/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CHAR0
 */
public class RomawiConverter {
    String [] roms = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    int [] decs = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    public int decimal;
    public String romawi;
    public RomawiConverter(){
        decimal = 0;
        romawi = "";
    }
    
    public void convertToRomawi(){
        int n = decimal;
        romawi = "";
        for(int i = decs.length - 1; i >= 0; i--){
            int dec = decs[i];
            while( n >= dec){
                romawi += roms[i];
                n -= dec;
            }
        }
    }
    public int getValue(String x){
        for(int i = 0; i < roms.length;i++){
           if( x.equals(roms[i]))
               return decs[i];
        }
        return 0;
    }
    public void convertToDecimal(){
        String n = romawi;
        decimal = 0;
        for(int i = 0; i < n.length() ; i++){
           if( i == 0){
               String t = n.charAt(i) +  "";
               int val = getValue(t);
               decimal += val;
           }else{
               String t1 = n.charAt(i) + "";
               int val1 = getValue(t1);
               String t2 = n.charAt(i-1) + "";
               int val2 = getValue(t2);
               if( val1 > val2){
                   decimal -= val2;
                   decimal += val1 - val2;
               }else{
                   decimal += val1;
               }        
           }
        }
    }
    public static void main(String[]args){
        RomawiConverter rc = new RomawiConverter();
        rc.decimal = 21;
        rc.convertToRomawi();
        System.out.println("Romawi = "+rc.romawi);
        rc.romawi = "XCIV";
        rc.convertToDecimal();
        System.out.println("Decimal = "+rc.decimal);
    }
}
