/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paladin.transitive.closure;

/**
 *
 * @author CHAR0
 */
public class TransitiveClosure {
    public int[][] graph = {
        {0,1,0,0},
        {0,0,0,1},
        {0,0,0,0},
        {1,0,1,0}
    };
    
    public int [][] TC;
    
    public TransitiveClosure(){
        TC = new int[graph.length][graph[0].length];
    }
    public void runAlgorithm(){
        //copy graph into TC
        for(int i = 0; i < graph.length;i++){
            for(int j = 0; j < graph[0].length; j++){
                TC[i][j] = graph[i][j];
            }
        }
        
        //main algo
        for(int k = 0; k < graph.length; k++ ){
            for(int i = 0; i < graph.length; i++)
                for(int j = 0; j < graph[0].length; j++){
                    if( i != k && j != k){
                        TC[i][j] = TC[i][j] | (TC[i][k] & TC[k][j]);
                    }
                }
        }
        
        printTC();
    }
    
    private void printTC(){
        System.out.println("Transitive Closure Matrix : ");
        for(int i = 0; i < TC.length; i++){
            for(int j = 0; j < TC[0].length; j++){
                System.out.print(TC[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        TransitiveClosure tc = new TransitiveClosure();
        tc.runAlgorithm();
    }
}
