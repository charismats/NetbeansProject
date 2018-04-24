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
public class SelectionSort {
    private int[] num;
    
    public SelectionSort(int [] val){
        num = Arrays.copyOf(val, val.length);
    }
    
    public void RunAlgorithm(){
        for(int i = 0; i < num.length; i++){
            int min = num[i];
            int index_min = i;
            //find the minimum values in the array after i
            for(int j = i+1; j < num.length;j++){
                if( min > num[j]){
                    min = num[j];
                    index_min = j;
                }
            }
            if( index_min != i){
                //swap index_min and i
                int temp = num[i];
                num[i] = min;
                num[index_min] = temp;
            }
        }
    }
    
    public void print(){
           System.out.print("[");
        for (int v : num) {
            System.out.print(v + ",");
        }
        System.out.println("\b]");
    }
    public static void main(String []args){
        int[] arr = {20, 1, 3, 0, 30, 4, -5, -2, -1, 100, 20, 25};
        SelectionSort ss = new SelectionSort(arr);
        ss.print();
        ss.RunAlgorithm();
        ss.print();
    }
}
