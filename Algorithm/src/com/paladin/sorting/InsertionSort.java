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
public class InsertionSort {
    private int [] num;
    
    public InsertionSort(int[] val){
        num = Arrays.copyOf(val, val.length);
    }
    
    public void RunAlgorithm(){
        for(int i = 0; i < num.length ;i++){
            int key = num[i];
            int j = i;
            while( j > 0 && num[j-1] > key ){
                num[j] = num[j-1];
                j--;
            }
            num[j] = key;
        }
    }
    public void print(){
           System.out.print("[");
        for (int v : num) {
            System.out.print(v + ",");
        }
        System.out.println("\b]");
    }
    public static void main(String[]args){
        int[] arr = {20, 1, 3, 0, 30, 4, -5, -2, -1, 100, 20, 25};
        InsertionSort is = new InsertionSort(arr);
        is.print();
        is.RunAlgorithm();
        is.print();
    }     
}
