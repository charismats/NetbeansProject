/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soal9;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author CHAR0
 */
public class Blokade {

    private int[][] graph = {
        {0, 2, 3, 4},
        {2, 0, 5, -1},
        {3, 5, 0, 2},
        {4, -1, 2, 0}
    };
    boolean[] positifCity;
    public ArrayList<Edge> MSTEdges;
    public ArrayList<Edge> listEdges;

    public Blokade() {
        positifCity = new boolean[graph.length];
        positifCity[3] = true;
        MSTEdges = new ArrayList<Edge>();
        listEdges = new ArrayList<Edge>();
    }

    public int runMSTBlockade() {
        //initialization
        for (int i = 0; i < graph.length; i++) {
            for (int j = i + 1; j < graph[i].length; j++) {
                if (graph[i][j] != 0) {
                    Edge e = new Edge();
                    e.v1 = i;
                    e.v2 = j;
                    e.weight = graph[i][j];
                    if( ! positifCity[i] && !positifCity[j])
                        MSTEdges.add(e);
                }
            }
        }
        
        Collections.sort(MSTEdges, Collections.reverseOrder());
        //printMST();
        int edgeCount = 0;
        while (edgeCount < MSTEdges.size()) {
            Edge maxEdge = MSTEdges.get(edgeCount);
            MSTEdges.remove(edgeCount);
            if (isDisconnected(maxEdge)) {
                //System.out.println("Edge ndak jadi removed = " + (char) (maxEdge.v1 + 'A') + " -> " + (char) (maxEdge.v2 + 'A'));
                MSTEdges.add(edgeCount,maxEdge);
                edgeCount++;
            }
            
        }
        System.out.println("Algorithm finished");
        printMST();
        return countMobilityMST();
    }
    private int countMobilityMST(){
        int sumMobility = 0;
        for(Edge e: MSTEdges){
            sumMobility += e.weight;
        }
        return sumMobility;
    }
     private void printMST() {
        System.out.println("List of edges in MST : ");
        for (int i = 0; i < MSTEdges.size(); i++) {
            Edge e = MSTEdges.get(i);
            char V1 = (char) (e.v1 + 'A');
            char V2 = (char) (e.v2 + 'A');
            System.out.println(V1 + " -> " + V2 + " = " + e.weight);
        }
    }

    private boolean isDisconnected(Edge e) {
        int v1 = e.v1;
        int v2 = e.v2;
        int countEdge1 = 0;
        int countEdge2 = 0;
        for(Edge edge: MSTEdges){
            if( edge.v1 == v1 || edge.v2 == v1)
                countEdge1++;
            if( edge.v1 == v2 || edge.v2 == v2)
                countEdge2++;
        }
        if( countEdge1 == 0 || countEdge2 == 0)
            return true;
        
        return false;
    }


    public static void main(String[] args) {
        Blokade blok = new Blokade();
        int minMobility = blok.runMSTBlockade();
        System.out.println(minMobility);
    }

    class Edge implements Comparable<Edge> {

        public int v1;
        public int v2;
        public int weight;

        @Override
        public int compareTo(Edge o) {
            if (weight > o.weight) {
                return 1;
            }
            if (weight < o.weight) {
                return -1;
            }
            return 0;
        }
    }
}
