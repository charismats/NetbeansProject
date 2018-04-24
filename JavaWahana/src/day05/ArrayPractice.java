/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day05;
import java.util.Random;
/**
 *
 * @author charisma
 */
public class ArrayPractice {
    public static void main(String[]args){
        int [] rndArr = new int[10];
        Random rnd = new Random();
        for(int i = 0; i < rndArr.length;){
            int val = rnd.nextInt(10) + 1;
            if( val % 2 == 0){
                rndArr[i++] = val;
            }
        }
        
        printArray(rndArr);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 2 *(i+1);
        }
        printArray(arr);
        
        int total = sumArray(arr);
        System.out.println("Total element in array = "+total);
    }
    public static void printArray(int[]arr){
        System.out.println("Isi element dalam array : ");
        for (int i = 0; i < arr.length; i++) {
            int b = arr[i];
            System.out.println(b);
        }
    }
    
    public static int sumArray(int[]arr){
        int tot = 0;
        for (int i = 0; i < arr.length; i++) {
            tot += arr[i];
        }
        return tot;
    }
}
