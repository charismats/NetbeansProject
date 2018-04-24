/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paladin.graph;

/**
 *
 * @author CHAR0
 */
public class Edge implements Comparable<Edge>{
    public int v1;
    public int v2;
    public int weight;

    @Override
    public int compareTo(Edge o) {
        if( weight > o.weight)
            return 1;
        if( weight < o.weight)
            return -1;
        return 0;
    }
}
