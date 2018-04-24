/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author charisma
 */
public class OctalDecimal {
    public static void main(String[]args){
        int n = 134;
        int octal = 0;
        int pow = 1;
        while( n > 0 ){
            int mod = n % 8;
            n /= 8;
            octal += pow * mod;
            pow *= 10;
        }
        System.out.println("Octal = " + octal);
    }
}
