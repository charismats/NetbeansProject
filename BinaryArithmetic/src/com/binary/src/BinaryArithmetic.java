/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.binary.src;

/**
 *
 * @author CHAR0
 */
public class BinaryArithmetic {
    public long toBinary(long n){
        long res = 0;
        long pow = 1;
        while(n > 0){
            int digit = (int) n % 2;
            n /= 2;
            res += pow * digit;
            pow *= 10;
        }
        return res;
    }
    
    public long toDec(long n){
        long res = 0;
        long pow = 1;
        while(n > 0){
            int digit = (int) n % 10;
            n /= 10;
            res += pow * digit;
            pow *= 2;
        }
        return res;
    }
    
    public long addition(long a, long b){
        long decA = toDec(a);
        long decB = toDec(b);
        long res = decA + decB;
        return toBinary(res);
    }
    public long subtraction(long a, long b){
        long decA = toDec(a);
        long decB = toDec(b);
        long res = decA - decB;
        return toBinary(res);
    }
    
    public long multiplication(long a, long b){
        long decA = toDec(a);
        long decB = toDec(b);
        long res = decA * decB;
        return toBinary(res);
    }
    
    public static void main(String[] args) {
        BinaryArithmetic bin = new BinaryArithmetic();
        System.out.println(bin.addition(11, 11));
        System.out.println(bin.subtraction(101, 11));
        System.out.println(bin.multiplication(1100, 101));
        System.out.println(bin.toDec(111100));
    }
}
