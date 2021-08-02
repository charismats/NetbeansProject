/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soal7;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author CHAR0
 */
public class KartuKeren {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] arr = {10,20,30,40};
        boolean palindrome = isPalindrome(arr);
        if( palindrome){
            System.out.println(0); 
        }
        else{
            Arrays.sort(arr);
            int countSame =0;
            for(int i = 1; i < arr.length;i++){
                if( arr[i] == arr[i-1]){
                    countSame++;
                }
            }
            //System.out.println("Count Same = "+ countSame);
            if(countSame == 0 ){
                if( arr.length % 2 == 0)
                    System.out.println(arr.length-1);
                else
                    System.out.println(arr.length);
            }else{
                int remaining = arr.length - countSame * 2;
                System.out.println((int)Math.ceil(remaining / 2.0));
            }
        }
    }
    static boolean isPalindrome(int[]arr){
        for(int i = 0; i< arr.length/2; i++){
            if(arr[i] != arr[arr.length-1-i])
                return false;
        }
        return true;
    }
}
