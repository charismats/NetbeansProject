/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paladin.dynamicprog;

/**
 *
 * @author CHAR0
 */
public class Fibonaci {
    private int [] fib;
    public Fibonaci(){
        
    }
    public int runAlgorithm(int n){
        fib = new int[n+1];
        fib[0] = 1;
        fib[1] = 1;
        for(int i = 2; i <= n; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
//        if(n == 0 || n == 1)
//            return 1;
//        return runAlgorithm(n-1) + runAlgorithm(n-2);
    }
    public static void main(String[] args) {
        Fibonaci fib = new Fibonaci();
        int n = fib.runAlgorithm(2);
        System.out.println("fib(2) = "+n);
        
    }
}
