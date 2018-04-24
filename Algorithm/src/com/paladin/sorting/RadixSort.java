/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.paladin.sorting;
import java.util.Arrays;
/**
 *
 * @author charisma
 * @version 1.0
 */
public class RadixSort {
    private int[] num;
    private int BASE = 10;
    
    public RadixSort(int[] a){
        num = Arrays.copyOf(a, a.length);
    }
    
    public void RunAlgorithm(){
        int [] bucket = new int[BASE];
        int exp = 1;
        int max = num[0];
        for(int i = 1 ; i < num.length;i++){
            if( max < num[i])
                max = num[i];
        }
        int [] b = new int[num.length]; //temporary array
        while( max > exp){
            Arrays.fill(bucket, 0);
            //digit allocation
            for(int i = 0; i < num.length; i++){
                int digit = num[i] / exp % BASE;
                bucket[digit]++;
            }
            
            for(int i = 1; i < BASE; i++){
                bucket[i] += bucket[i-1];
            }
            
            for( int i = num.length-1 ; i >= 0; i--){
                int digit = num[i] / exp % BASE;
                b [ --bucket[digit] ] = num[i];
            }
            
            for( int i = 0 ; i < b.length; i++)
                num[i] = b[i];
            
            
            exp *= BASE;
        }
    }
    
    public void PrintArray(){
        System.out.print("[");
        for(int n : num){
            System.out.print(n + " ");
        }
        System.out.println("]");
    }
    public static void main(String[]args){
        int [] a = { 20, 10,2,1,30};
        RadixSort rs = new RadixSort(a);
        System.out.println("Before sorting: ");
        rs.PrintArray();
        rs.RunAlgorithm();
        System.out.println("After sorting: ");
        rs.PrintArray();
    }
}
