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
 * @since April,2014
 */
public class HeapSort {
    private int [] num;
    private int [] heap;
    private int count = 0;
    public HeapSort(int[] val){
        num = Arrays.copyOf(val, val.length);
        heap = new int[num.length];
    }
    
    public void RunAlgorithm(){
        //insertion into heap
        for(int i = 0 ; i < num.length;i++){
            InsertElem(num[i]);
        }
        //printHeap();
        //deletion of least element
        for(int i = 0 ; i < num.length; i++){
            int leastElement = DeleteLeastElem();
            num[i] = leastElement;
            //System.out.println("Least element = "+leastElement);
            //printHeap();
        }
        //printHeap();
    }
   
    private void InsertElem(int elem){
        if( count == heap.length){
            return;
        }
        int hole = count++;
        
        if( count == 1){
            heap[hole] = elem;
            return;
        }
        //parent
        int p = root(hole);
        while( p >= 0){
            if( heap[p] > elem){
                heap[hole] = heap[p];
                hole = p;
                p = root(hole);
            }else{
                break;
            }
        }
        //final placing of element into hole
        heap[hole] = elem;
    }
    
    private int DeleteLeastElem(){
        int lastElem = heap[count-1];
        int least = heap[0];//the least element is at the top
        int hole = 0;
        boolean hasLeft;
        boolean hasRight;
        int min_child = 0;
        while(true){
            hasLeft = left(hole) <= count-1 ? true: false;
            hasRight = right(hole) <= count-1 ? true : false;
            if( !hasLeft && !hasRight){
                heap[hole] = lastElem;
                break;
            }
            //if have 2 children
            if(hasLeft && hasRight){
                if(heap[left(hole)] <= heap[right(hole)]){
                    min_child = left(hole);
                }else{
                    min_child = right(hole);
                }
            }
            //if have 1 child
            else if( hasLeft){  
                min_child = left(hole);
            }
            if( lastElem <= heap[min_child]){
                heap[hole] = lastElem;
                break;
            }
            heap[hole] = heap[min_child];
            hole = min_child;
        }
        heap[count-1] = -1;
        count--;
        return least;
    }
    private int root(int i ){
        if( i == 0)
            return -1;
        return (i-1) >> 1;
    }
    private int left(int i){
        return (i << 1) + 1;
    }
    private int right(int i){
        return (i << 1) + 2;
    }
    private void Swap(int idxA, int idxB){
        int tmp = num[idxA];
        num[idxA] = num[idxB];
        num[idxB] = tmp;
    }
    
   public void printHeap(){
       System.out.println("Heap content : ");
        System.out.print("[");
        for (int v : heap) {
            System.out.print(v + ",");
        }
        System.out.println("\b]");
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
        HeapSort hs = new HeapSort(arr);
        hs.print();
        hs.RunAlgorithm();
        hs.print();
    }
}
