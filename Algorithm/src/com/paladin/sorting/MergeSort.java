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
 * @since April, 2014
 */
public class MergeSort {
    private int[] num;
    public MergeSort(int[] val){
        num = Arrays.copyOf(val, val.length);
    }
    
    public void RunAlgorithm(){
        MergeSort( 0, num.length-1);
    }
    
    public void MergeSort(int start, int end){
        if( start >= end){
            return;
        }
        int mid = (start + end) /2;
        MergeSort(start, mid);
        MergeSort(mid+1, end);
        Merge(start, mid, mid+1, end);
        
    }
    public void Merge(int startA,int endA, int startB,int endB){
        int[] merged = new int[endB - startA + 1];
        int iA = startA, jB = startB, k = 0;
        while( k <= merged.length-1 && iA <= endA && jB <= endB){
            if( num[iA] <= num[jB]){
                merged[k++] = num[iA++];
            }
            else{
                merged[k++] = num[jB++];
            }
        }
        if( jB > endB){
            while( iA <= endA)
                merged[k++] = num[iA++];
        }else if ( iA > endA ){
            while(jB <= endB)
                merged[k++] = num[jB++];
        }
        
        //copy back to num
        k = 0;
        for(int i= startA; i <= endB; i++){
            num[i] = merged[k++];
        }
        //print();
    }
    
    public void print(){
        System.out.print("[");
        for(int v : num){
            System.out.print(v+ ",");
        }
        System.out.println("\b]");
    }
    
    public static void main(String[]args){
        int [] arr = {20,1,3,0,30,4,-5,-2,-1,100,20,25};
        MergeSort ms = new MergeSort(arr);
        ms.print();
        ms.RunAlgorithm();
        ms.print();
    }
}
