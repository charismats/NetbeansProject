/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paladin.sorting;

/**
 *
 * @author CHAR0
 */
public class CountingSort {
    public int[] sort(int[] arr){
        int max = -1;
        for(int i: arr){
            if( max < i)
                max = i;
        }
        int[] bins = new int[max+1];
        //counting elements
        for(int i : arr){
            bins[i]++;
        }
        for(int i = 1; i < bins.length; i++){
            bins[i] += bins[i-1];
        }
        
        int [] sortedarr = new int[arr.length];
        for(int i : arr){
            sortedarr[--bins[i]] = i;
        }
        return sortedarr;
    }
    
    public void printArr(int[]arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        CountingSort cs = new CountingSort();
        int[] arr = {1,0,3,1,3,1};
        cs.printArr(arr);
        int[] sorted = cs.sort(arr);
        cs.printArr(sorted);
    }
}
