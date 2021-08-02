/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soal2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author CHAR0
 */
public class DawalaCepot {
//    private static int [][] map = {
//        {1,2,2,2,2,2,2,1},
//        {1,3,3,3,3,0,0,1},
//        {1,0,0,4,0,0,0,1},
//        {1,0,0,0,0,0,0,1},
//        {0,0,0,0,0,0,0,1},
//        {1,0,0,0,0,0,0,1},
//        {1,2,2,2,2,2,2,1},
//        {1,3,3,0,0,0,3,1},
//        {1,0,0,0,5,0,0,1},
//        {1,2,2,2,2,2,2,1}
//    };
//    
//    private static int [][] map = {
//        {1,2,2,2,2,2,2,1},
//        {1,3,3,3,3,0,0,1},
//        {1,0,0,4,0,0,0,1},
//        {1,0,0,0,0,0,0,1},
//        {1,0,0,0,0,0,0,1},
//        {1,0,0,0,0,0,0,1},
//        {1,2,2,0,2,2,2,1},
//        {1,3,3,0,0,0,3,1},
//        {1,0,0,0,5,0,0,1},
//        {1,2,2,2,2,2,2,1}
//    };
    
//    private static int [][] map = {
//        {1,2,2,2,2,2,2,1},
//        {1,3,3,3,3,0,0,1},
//        {1,0,0,5,0,0,0,1},
//        {1,0,0,0,0,0,0,1},
//        {1,0,0,0,0,0,0,1},
//        {1,0,0,0,0,0,0,1},
//        {1,2,2,0,2,2,2,1},
//        {1,3,3,0,0,0,3,1},
//        {1,0,0,0,4,0,0,1},
//        {1,2,2,2,0,2,2,1}
//    };
    private static int[][]map;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int p = sc.nextInt();
        int l = sc.nextInt();
        map = new int[p][l];
        sc.nextLine();
        for(int i = 0; i < p; i++){
            String line = sc.nextLine();
            for(int j = 0; j < line.length(); j++){
                if( line.charAt(j) == '|')
                    map[i][j] = 1;
                else if ( line.charAt(j) == '-')
                    map[i][j] = 2;
                else if ( line.charAt(j) == 'C')
                    map[i][j] = 4;
                else if( line.charAt(j) == ' ')
                    map[i][j] = 0;
                else if ( line.charAt(j) == 'X')
                    map[i][j] = 3;
                else if( line.charAt(j) == 'D')
                    map[i][j] = 5;
            }
        }
        boolean lumpat = searchLumpat();
        boolean cepotOK = searchCepot();
        if(cepotOK){
            System.out.println("Dawala bertemu Cepot");
        }else{
            System.out.println("Dawala tidak bertemu Cepot");
        }
        if(lumpat){
            System.out.println("ada jalan Cepot lumpat");
        }else{
            System.out.println("tidak ada jalan Cepot lumpat");
        }
    }
    
    private static boolean searchLumpat(){
        Node start = null;
        for(int i = 0 ; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if( map[i][j] == 4){
                    start = new Node();
                    start.i = i;
                    start.j = j;
                    break;
                }
            }
            if( start != null)
                break;
        }
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(start);
        boolean [][] visited = new boolean[map.length][map[0].length];
        while(queue.size() > 0){
            Node curr = queue.remove(0);
            if( visited[curr.i][curr.j])
                continue;
            visited[curr.i][curr.j] = true;
            if( curr.j == 0 || curr.j == map[0].length-1 ||
                    curr.i == 0 || curr.i == map.length-1)
                return true;
                
            //tengok kanan
            if(curr.j + 1 < map[0].length && map[curr.i][curr.j+1] == 0)
            {
                Node next = new Node();
                next.i = curr.i;
                next.j = curr.j+1;
                queue.add(next);
            }
            //tengok kiri 
            if(curr.j - 1 >= 0 && map[curr.i][curr.j-1] == 0)
            {
                Node next = new Node();
                next.i = curr.i;
                next.j = curr.j-1;
                queue.add(next);
            }
            //tengok atas
            if(curr.i - 1 >= 0 && map[curr.i-1][curr.j] == 0)
            {
                Node next = new Node();
                next.i = curr.i-1;
                next.j = curr.j;
                queue.add(next);
            }
            //tengok bawah
            if(curr.i + 1 < map.length && map[curr.i+1][curr.j] == 0)
            {
                Node next = new Node();
                next.i = curr.i+1;
                next.j = curr.j;
                queue.add(next);
            }
        }
        return false;
    }
    
    private static boolean searchCepot(){
        Node start = null;
        for(int i = 0 ; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if( map[i][j] == 5){
                    start = new Node();
                    start.i = i;
                    start.j = j;
                    break;
                }
            }
            if( start != null)
                break;
        }
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(start);
        boolean [][] visited = new boolean[map.length][map[0].length];
        while(queue.size() > 0){
            Node curr = queue.remove(0);
            //System.out.println("Current Node : "+curr);
            if( visited[curr.i][curr.j])
                continue;
            visited[curr.i][curr.j] = true;
            if( map[curr.i][curr.j] == 4)
                return true;
                
            //tengok kanan
            if(curr.j + 1 < map[0].length && ( map[curr.i][curr.j+1] == 0 || map[curr.i][curr.j+1] == 4) )
            {
                Node next = new Node();
                next.i = curr.i;
                next.j = curr.j+1;
                queue.add(next);
            }
            //tengok kiri 
            if(curr.j - 1 >= 0 && ( map[curr.i][curr.j-1] == 0 || map[curr.i][curr.j-1] == 4))
            {
                Node next = new Node();
                next.i = curr.i;
                next.j = curr.j-1;
                queue.add(next);
            }
            //tengok atas
            if(curr.i - 1 >= 0 && ( map[curr.i-1][curr.j] == 0 || map[curr.i-1][curr.j] == 4))
            {
                Node next = new Node();
                next.i = curr.i-1;
                next.j = curr.j;
                queue.add(next);
            }
            //tengok bawah
            if(curr.i + 1 < map.length && ( map[curr.i+1][curr.j] == 0 || map[curr.i+1][curr.j] == 4))
            {
                Node next = new Node();
                next.i = curr.i+1;
                next.j = curr.j;
                queue.add(next);
            }
        }
        return false;
    }
    
    private static class Node{
        public int i;
        public int j;
        
        @Override
        public String toString(){
            return "(i,j) = ("+i+","+j+")";
        }
    }
}
