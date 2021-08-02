/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astar.paladin;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author CHAR0
 */
public class AStar {
    public static final int GRIDSIZE = 20;
    public int[][] graph;
    public ArrayList<Node> path;
    public PriorityQueue<Node> openList;
    public ArrayList<Node> closedList;
    public boolean foundDestination;
    public AStar(){
        graph = new int[GRIDSIZE][GRIDSIZE];
        path = new ArrayList<>();
        openList = new PriorityQueue<>();
        closedList = new ArrayList<>();
    }
    
    public void searchPath(Node start, Node end){
        start.parent = null;
        calculateF(start, end);
        openList.add(start);
        
        foundDestination = false;
        while(openList.size() > 0){
            Node curr = openList.remove();
            if( isVisited(curr))
                continue;
            closedList.add(curr);
            path.add(curr);
            //System.out.println(curr);
            if( curr.id == end.id){
                System.out.println("Destination found");
                foundDestination = true;
                break;
            }
            //4 direction 
            //kanan
            if(curr.x + 1 < graph[0].length && graph[curr.y][curr.x+1] != 2) //2 is boundary
            {
                Node newNode = new Node(curr.y * graph.length + (curr.x + 1), curr.y, curr.x+1);
                newNode.parent = curr;
                calculateF(newNode, end);
                openList.add(newNode);
//                System.out.println("Kanan Masuk");
            }
            //kiri
            if(curr.x - 1 >= 0 && graph[curr.y][curr.x-1] != 2) //2 is boundary
            {
                Node newNode = new Node(curr.y * graph.length + (curr.x-1), curr.y, curr.x-1);
                newNode.parent = curr;
                calculateF(newNode, end);
                openList.add(newNode);
//                System.out.println("Kiri Masuk");
            }
            //atas
            if(curr.y - 1 >= 0 && graph[curr.y-1][curr.x] != 2) //2 is boundary
            {
                Node newNode = new Node((curr.y-1) * graph.length + curr.x, curr.y-1, curr.x);
                newNode.parent = curr;
                calculateF(newNode, end);
                openList.add(newNode);
//                System.out.println("Atas Masuk");
            }
            //bawah
            if(curr.y + 1 < graph.length && graph[curr.y+1][curr.x] != 2) //2 is boundary
            {
                Node newNode = new Node((curr.y + 1) * graph.length + curr.x, curr.y+1, curr.x);
                newNode.parent = curr;
                calculateF(newNode, end);
                openList.add(newNode);
//                System.out.println("Bawah Masuk");
            }
            
            //OpenList contains
//            System.out.println("Open List contains: ");
//            for(Node n : openList){
//                System.out.println(n);
//            }
        }
        System.out.println("Algorithm terminates");
        if( !foundDestination){
            System.out.println("Cannot find solution");
        }
        else{
            System.out.println("Path: ");
            printPath();
        }
    }
    
    private void printPath(){
        Node curr = path.get(path.size() -1);
        while( curr != null){
            System.out.println(curr);
            curr = curr.parent;
        }
        
    }
    public boolean isVisited(Node curr){
        for(Node n : closedList){
            if( n.id == curr.id)
                return true;
        }
        return false;
    }
    public void calculateF(Node next, Node end){
        //manhattan distance
        next.G = 1;
        next.H = Math.abs(end.x - next.x) + Math.abs(end. y- next.y);
        next.F = next.G + next.H;
    }
    
    public static void main(String[] args) {
        AStar astar = new AStar();
        int startx = 0, starty = 0;
        int endx = 3, endy = 4;
        Node start = new Node(starty * AStar.GRIDSIZE + startx, starty, startx );
        
        Node end = new Node(endy * AStar.GRIDSIZE + endx, endy, endx );
        
        astar.searchPath(start, end);
    }
}
