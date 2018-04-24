/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paladin.graph;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author CHAR0
 */
public class Kruskal {
    public int[][] graph = {
        {0, 7, 0, 5, 0, 0, 0},
        {7, 0, 8, 9, 7, 0, 0},
        {0, 8, 0, 0, 5, 0, 0},
        {5, 9, 0, 0, 15, 6, 0},
        {0, 7, 5, 15, 0, 8, 9},
        {0, 0, 0, 6, 8, 0,  11},
        {0, 0, 0, 0, 9, 11, 0}
            
    };
    public ArrayList<Edge> listEdges;
    public ArrayList<Set> listSet;
    public Set MST;
    public ArrayList<Edge> MSTEdges;
    public Kruskal(){
        listEdges = new ArrayList<>();
        listSet = new ArrayList<>();
        MST = new Set();
        MSTEdges = new ArrayList<>();
    }
    
    public void runAlgorithm(){
        //1. Make set for each vertex
        for(int i = 0; i < graph.length; i++){
            Set s = new Set();
            s.vertices.add(i);
            listSet.add(s);
        }
        
        //2. make list edges sorted by weight
        for(int i = 0; i < graph.length ; i++){
            for(int j = i; j < graph[0].length; j++){
                if( i != j && graph[i][j] > 0){
                    Edge e = new Edge();
                    e.v1 = i;
                    e.v2 = j;
                    e.weight = graph[i][j];
                    listEdges.add(e);
                }
            }
        }
        Collections.sort(listEdges);
        printAllEdgesInList();
        
        while( !listEdges.isEmpty() && !notFoundMST()){
            Edge removedEdge = listEdges.remove(0);
            int v1 = removedEdge.v1;
            int v2 = removedEdge.v2;
            Set s1 = findSet(v1);
            Set s2 = findSet(v2);
            if( !isSameSet(s1, s2)){
                //union two set
                Union(MST, s1, s2);
                //Union(s1, s2);
                MSTEdges.add(removedEdge);
            }
        }
        
        System.out.println("MST Found");
        printMST();
    }
    
    public void printAllEdgesInList(){
        for(int i = 0; i < listEdges.size(); i++){
            Edge e = listEdges.get(i);
            char V1 = (char)(e.v1 + 'A');
            char V2 = (char)(e.v2 + 'A');
            System.out.println(V1 + " -> "+ V2 + " = "+e.weight);
        }
    }
    
    public static void main(String[]args){
        Kruskal kruskal = new Kruskal();
        kruskal.runAlgorithm();
    }
    
    public boolean isSameSet(Set a, Set b){
        for(int vertice : a.vertices){
            if( !b.vertices.contains(vertice))
                return false;
        }
        return true;
    }
    
    public Set findSet(int vertice){
        for(int i = 0; i < listSet.size(); i++){
            Set s = listSet.get(i);
            if( s.vertices.contains(vertice))
                return s;
        }
        return null;
    }
    public boolean notFoundMST(){
        
        for(int vertice = 0; vertice < graph.length; vertice++){
            if( !MST.vertices.contains(vertice))
                return false;
        }
        return true;
    }
    public void printMST(){
        System.out.println("MST contains vertices : ");
        for(int vertice : MST.vertices){
            char v = (char) ( vertice + 'A');
            System.out.println("Vertice : "+v);
        }
        System.out.println("List of edges in MST : ");
        for(int i = 0; i < MSTEdges.size(); i++){
            Edge e = MSTEdges.get(i);
            char V1 = (char)(e.v1 + 'A');
            char V2 = (char)(e.v2 + 'A');
            System.out.println(V1 + " -> "+ V2 + " = "+e.weight);
        }
    }
    public void Union(Set s1, Set s2, Set s3){
        for(int vertice : s2.vertices){
            if( !s1.vertices.contains(vertice))
                s1.vertices.add(vertice);
            if( !s3.vertices.contains(vertice))
                s3.vertices.add(vertice);
        }
        for(int vertice : s3.vertices){
            if( !s1.vertices.contains(vertice))
                s1.vertices.add(vertice);
            if( !s2.vertices.contains(vertice))
                s2.vertices.add(vertice);
        }
    }
}

class Set{
    public ArrayList<Integer> vertices;
    public Set(){
        vertices = new ArrayList<>();
    }
}   
