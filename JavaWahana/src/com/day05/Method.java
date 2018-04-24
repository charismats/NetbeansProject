/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day05;

import java.util.Arrays;

/**
 *
 * @author CHAR0
 */
public class Method {
    public static void printMessage(String message){
        System.out.println(message);
    }
    
    public static int sum(int a, int b){
        return a + b;
    }
    public static void printArray(int[] arr){
        System.out.println("Elements in array : ");
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            int j = arr[i];
            System.out.print(j+ " ");
        }
        System.out.println(" ]");
    }
    
    public static int linearSearch(int[]arr, int key){
        for (int i = 0; i < arr.length; i++) {
            if( arr[i] == key)
                return i;
            
        }
        return -1;
    }
    public static int binarySearch(int[] arr, int start, int end, int key){
        if( start <= end){
            int mid = (start + end )/2;
            if( arr[mid] == key)
                return mid;
            if( key < arr[mid])
                return binarySearch(arr, start, mid-1, key);
            else
                return binarySearch(arr, mid+1, end, key);
        }
        return -1;
    }
    public static void main(String[] args) {
        printMessage("Hello World");
        int total = sum(3,4);
        System.out.println("Total = "+total);
        int[] arr = {5,1,2,4,3,10,9};
        printArray(arr);
        int key = 3;
        int pos = linearSearch(arr, key);
        System.out.println("Index of "+key+" found at "+pos);
        
        
        Arrays.sort(arr);
        printArray(arr);
        pos = binarySearch(arr,0, arr.length-1, 5);
        System.out.println("Index found at "+pos);
    }
}
