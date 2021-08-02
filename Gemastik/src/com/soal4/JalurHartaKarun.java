/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soal4;

import java.util.Scanner;

/**
 *
 * @author CHAR0
 */
public class JalurHartaKarun {
    private static int[][] map;
    private static int[] harta;
    private static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        harta = new int[n];
        map = new int[n][n];
        visited =new boolean[n];
        
        for(int i = 0; i < n ; i++){
            harta[i] = sc.nextInt();
        }
        for(int i = 0 ; i < k ; i++){
            map[sc.nextInt()][sc.nextInt()] = 1;
        }        
        //find starting point
        int max = -1;
        int start = 0;
        for(int i = 0 ; i < n; i++){
            if( harta[i] > max){
                start = i;
                max = harta[i];
            }
        }
        
        int totalHarta = dfs(start);
        System.out.println(totalHarta);
    }
    private static int dfs(int curr){
        if( visited[curr])
            return 0;
        System.out.println("Visited = "+curr);
        visited[curr] = true;
        int total = harta[curr];
        int max = -1;
        int next = -1;
        for(int j = 0; j < map[0].length; j++){    
            if( curr !=j && map[curr][j] == 1 && harta[j] > max){
                max = harta[j];
                next = j;
               // System.out.println("Next Dalam = "+next);
            }
            //System.out.println("Next Luar  = " + next);
        }
        if ( next != -1)
            total += dfs(next);
        return total;
    }
}
