/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dpfaktorial;

/**
 *
 * @author CHAR0
 */
public class FaktorialDP {
    public long faktorialDP(int N){
        long[] dp = new long[N+1];
        if( N < 2)
            return 1;
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= N; i++){
            dp[i] = i * dp[i-1];
        }
        return dp[N];
    }
    public static void main(String[] args) {
        FaktorialDP fdp = new FaktorialDP();
        int N = 20;
        int[] arr = {2,2,2,2,2};
        int sum = 0;
        for(int n: arr)
            sum += n;
        int sisaN = N - sum;
        int a = sisaN + arr.length -1;
        System.out.println("a = " + a + " sisaN = "+ sisaN+ "a - sisaN= "+(a-sisaN));
        
        long fakt = fdp.faktorialDP(N);
        long faktA = fdp.faktorialDP(a);
        long faktSisaN = fdp.faktorialDP(sisaN);
        long faktA_SisaN = fdp.faktorialDP(a - sisaN);
        System.out.println(faktA + " " + faktSisaN + " " + faktA_SisaN);
        long ways = fdp.faktorialDP(a) / (fdp.faktorialDP(sisaN) * fdp.faktorialDP(a-sisaN));
        System.out.println(ways);
    }
}
