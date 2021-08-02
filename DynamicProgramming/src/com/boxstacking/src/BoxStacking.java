/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boxstacking.src;

import java.util.ArrayList;
import java.util.Collections;


/**
 *
 * @author CHAR0
 */
public class BoxStacking {
    class Box implements Comparable<Box>{
        public int width;
        public int height;
        public int length;

        @Override
        public int compareTo(Box o) {
            if( length * width < o.length * o.width)
                return -1;
            if( length * width > o.length * o.width)
                return 1;
            return 0;
            
        }

        
        
    }
    private ArrayList<Box> boxes;
    
    private void createRotationsBox(int [] l, int[] w, int [] h){
        boxes = new ArrayList<>();
        int N = l.length;
        for(int i = 0; i < N;i++){
            Box box = new Box();
            // copy original box
            box.height = h[i];
            box.length = Math.max(l[i], w[i]);
            box.width = Math.min(l[i], w[i]);
 
            boxes.add(box);
            
            box = new Box();
            // First rotation of box
            box.height = w[i];
            box.length = Math.max(l[i], h[i]);
            box.width = Math.min(l[i], h[i]);
 
            boxes.add(box);
            
            // Second rotation of box
            box = new Box();
            box.height = l[i];
            box.length = Math.max(w[i], h[i]);
            box.width = Math.min(w[i], h[i]);
 
            boxes.add(box);
        }
        Collections.sort(boxes, Collections.reverseOrder());
    }
    public int doDP(int[] length, int [] width, int[] height){
        createRotationsBox(length, width, height);
        int[] dp  = new int[boxes.size()];
        int[] parent = new int[boxes.size()];
        
        for(int i = 0 ; i < dp.length; i++){
            dp[i] = boxes.get(i).height;
            parent[i] = i;
        }
        
        for(int i = 1; i < boxes.size(); i++){
            for(int j = 0; j < i; j++){
                Box boxi = boxes.get(i);
                Box boxj = boxes.get(j);
                if( boxi.length < boxj.length && boxi.width  < boxj.width){
                    if( dp[i] < boxi.height + dp[j]){
                        dp[i] = boxi.height + dp[j];
                        parent[i] = j;
                    }
                }
            }
        }
        int maxHeight = -1;
        for(int n : dp){
            System.out.print(n + " ");
            if ( maxHeight < n)
                maxHeight = n;
        }
        System.out.println("");
        for(int par : parent){
            System.out.print(par + " ");
        }
        System.out.println("");
        return maxHeight;
    }
    
    public static void main(String[] args) {
        BoxStacking bs = new BoxStacking();
        int [] length = { 4, 1};;
        int [] width = { 6, 2 };
        int [] height = { 7, 3 };
        int maxHeight = bs.doDP(length, width, height);
        System.out.println("Max Height : "+maxHeight);
    }
}
