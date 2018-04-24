/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.octal.arithmetic;

/**
 *
 * @author CHAR0
 */
public class OctalArithmetic {
    public long toOctal(long n){
        long res = 0;
        long pow = 1;
        while( n > 0){
            int dig = (int) n % 8;
            n /= 8;
            res += pow * dig;
            pow *= 10;
        }
        return res;
    }
    
    public long toDecimal(long n){
        long res = 0;
        long pow = 1;
        while( n > 0){
            int dig = (int) n % 10;
            n /= 10;
            res += pow * dig;
            pow *= 8;
        }
        return res;
    }
    
    public long addition(long a, long b){
        long decA = toDecimal(a);
        long decB = toDecimal(b);
        long res = decA + decB;
        return toOctal(res);
    }
    
    
    public long subtraction(long a, long b){
        long decA = toDecimal(a);
        long decB = toDecimal(b);
        long res = decA - decB;
        return toOctal(res);
    }
    
    public long multiplication(long a, long b){
        long decA = toDecimal(a);
        long decB = toDecimal(b);
        long res = decA * decB;
        return toOctal(res);
    }
    public static void main(String[] args) {
        OctalArithmetic octal = new OctalArithmetic();
        System.out.println(octal.toOctal(9));
        System.out.println(octal.toDecimal(77));
        System.out.println(octal.addition(10, 10));
        System.out.println(octal.subtraction(541, 153));
        System.out.println(octal.multiplication(125, 21));
    }
}
