/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author CHAR0
 */
public class PeakFinder {
    public int[] data;
    public PeakFinder(){
        data = new int[10];
        Random r = new Random();
        for(int i = 0; i < data.length;i++){
            data[i] = r.nextInt(10);
        }
    }
    
    public int searchPeak(int start, int end){
        int mid = (start+end)/2;
        if( data[mid] < data[mid-1])
           return searchPeak(start, mid-1);
        else if ( data[mid] < data[mid+1])
            return searchPeak(mid+1, end);
        return data[mid];
    }
    public ArrayList<Integer> searchPeak(){
        ArrayList<Integer> peakList = new ArrayList<>();
        for(int i = 0; i < data.length;i++){
            if( i == 0){
                if( data[i] >= data[i+1])
                    peakList.add(data[i]);
            }else if ( i == data.length -1){
                if( data[i] >= data[i-1])
                    peakList.add(data[i]);
            }
            else{
                if( data[i] >= data[i-1] && data[i] >= data[i+1])
                    peakList.add(data[i]);
            }
        }
        return peakList;
    }
    public void printData(){
        for(int i = 0; i < data.length; i++){
            System.out.print(data[i] +  " ");
        }
        System.out.println("");
    }
    public static void main(String[]args){
        PeakFinder pf = new PeakFinder();
        pf.printData();
        int peak = pf.searchPeak(0, pf.data.length-1);
        System.out.println("Peak = "+peak);
        ArrayList<Integer> peakList = pf.searchPeak();
        for (int peak2 : peakList){
            System.out.println("Peak = "+peak2);
        }
    }
}
