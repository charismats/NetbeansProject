/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astar.paladin;

/**
 *
 * @author CHAR0
 */
public class Node implements Comparable<Node>{
    public double G;
    public double H;
    public double F;
    public int id;
    public int x;
    public int y;
    public Node parent;
    
    public Node(int id, int y, int x){
        this.id = id;
        this.x = x;
        this.y = y;
        G = H = F = 0.0;
    }

    @Override
    public int compareTo(Node o) {
        if( this.F < o.F)
            return -1;
        if ( this.F > o.F)
            return 1;
        return 0;
    }
    
    @Override
    public String toString(){
        return "id = "+ this.id + "(" + this.y + ","+this.x+") = F = "+ this.F;
    }
    
    
}
