/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author charisma
 */
public class DecimalHexa {
    
    public static String intToHexa(String i){
        String h = "";
        String sHex = "0123456789ABCDEF";
        int n = Integer.parseInt(i);
        /*for(int j = 0 ; j <4; j++){
            int idx1 = n >> (j*8+4);
            int idx2 = n >> (j*8);
            h += sHex.charAt(idx1 & 0x0F) + sHex.charAt(idx2 & 0x0F);
        }*/
        int BASE = 16;
        while( n > 0){
            h = sHex.charAt( n % BASE) + h;
            n /= BASE;
        }
        return h;
    }
    public static void main(String[]args){
        String n = "256";
        String h = intToHexa(n);
        System.out.println("Hexa dari "+n + " adalah " + h);
    }
}
