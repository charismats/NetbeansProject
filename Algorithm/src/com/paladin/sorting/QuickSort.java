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
public class QuickSort {
    private int[] num;
    public QuickSort(int[] val){
        num = Arrays.copyOf(val, val.length);
    }
    
    public void RunAlgorithm(){
        QuickSort(0, num.length-1);
    }
    public void QuickSort(int start, int end){
        if( start < end){
            int pivotIndex = (start + end)/2;
            pivotIndex = Partition(pivotIndex, start, end);
            //print();
            QuickSort(start, pivotIndex-1);
            QuickSort(pivotIndex+1, end);
        }
    }
    
    public int Partition(int pivotIdx, int start, int end){
        int storeIdx = start;
        int pivotValue = num[pivotIdx];
        swap(pivotIdx, end);
        for(int i = start; i < end; i++){
            if( num[i] <= pivotValue){
                swap(i,storeIdx);
                storeIdx++;
            }
        }
        swap(storeIdx,end);
        return storeIdx;
    }
    
    public void swap(int idxA, int idxB){
        int temp = num[idxA];
        num[idxA] = num[idxB];
        num[idxB] = temp;
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
        QuickSort qs = new QuickSort(arr);
        qs.print();
        qs.RunAlgorithm();
        qs.print();
    }
}
