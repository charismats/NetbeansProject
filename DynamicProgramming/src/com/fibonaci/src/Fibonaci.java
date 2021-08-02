/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fibonaci.src;

/**
 *
 * @author CHAR0
 */
public class Fibonaci {
    public int fib(int n){
        int [] soln = new int[n+1];
        soln[0] = 0;
        soln[1] = 1;
        for(int i = 2; i <= n; i++){
            soln[i] = soln[i-1] + soln[i-2];
        }
        return soln[n];
    }
    
    public static void main(String[] args) {
        Fibonaci fibo = new Fibonaci();
        System.out.println("Fibonaci : "+fibo.fib(4));
    }
}
