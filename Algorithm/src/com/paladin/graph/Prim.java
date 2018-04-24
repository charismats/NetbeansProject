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
public class Prim {

    public ArrayList<Vertice> setVertices;
    public ArrayList<Edge> MSTEdges;
    public ArrayList<Vertice> MST;

    public int[][] graph = {
        {0, 7, 0, 5, 0, 0, 0},
        {7, 0, 8, 9, 7, 0, 0},
        {0, 8, 0, 0, 5, 0, 0},
        {5, 9, 0, 0, 15, 6, 0},
        {0, 7, 5, 15, 0, 8, 9},
        {0, 0, 0, 6, 8, 0, 11},
        {0, 0, 0, 0, 9, 11, 0}

    };

    public Prim() {
        setVertices = new ArrayList<>();
        MSTEdges = new ArrayList<>();
        MST = new ArrayList<>();
    }

    public void runAlgorithm() {
        //1. Initialize key and parent vertices
        for (int i = 0; i < graph.length; i++) {
            Vertice v = new Vertice();
            v.id = i;
            v.key = Integer.MAX_VALUE;
            v.parent = -1;
            if (i == 0) {
                v.key = 0;
            }
            setVertices.add(v);
        }
        Collections.sort(setVertices);
        while (!setVertices.isEmpty()) {
            Vertice current = setVertices.remove(0);
            int currId = current.id;
            MST.add(current);
            if (current.parent != -1) {
                Edge e = new Edge();
                e.v1 = current.id;
                e.v2 = current.parent;
                e.weight = graph[e.v1][e.v2];
                MSTEdges.add(e);
            }
            //for each vertex neighbour
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[currId][j] > 0) {
                    Vertice neighbour = getNeighbour(j);
                    //System.out.println(neighbour);
                    if (neighbour != null && isInSetVertices(j) && graph[currId][j] < getKeyValue(j)) {
                        updateKeyAndParent(current, neighbour);
                    }
                }
            }
            Collections.sort(setVertices);
        }

        System.out.println("MST Found: ");
        printMST();
    }

    public void printMST() {
        System.out.println("MST contains vertices : ");
        for (Vertice vertice : MST) {
            char v = (char) (vertice.id + 'A');
            System.out.println("Vertice : " + v);
        }
        System.out.println("List of edges in MST : ");
        for (int i = 0; i < MSTEdges.size(); i++) {
            Edge e = MSTEdges.get(i);
            char V1 = (char) (e.v1 + 'A');
            char V2 = (char) (e.v2 + 'A');
            System.out.println(V1 + " -> " + V2 + " = " + e.weight);
        }
    }

    public void updateKeyAndParent(Vertice current, Vertice neighbour) {
        neighbour.parent = current.id;
        neighbour.key = graph[current.id][neighbour.id];
    }

    public Vertice getNeighbour(int verticeId) {
        for (int i = 0; i < setVertices.size(); i++) {
            if (verticeId == setVertices.get(i).id) {
                return setVertices.get(i);
            }
        }
        return null;
    }

    public int getKeyValue(int verticeId) {
        for (int i = 0; i < setVertices.size(); i++) {
            Vertice v = setVertices.get(i);
            if (verticeId == v.id) {
                return v.key;
            }
        }
        return 0;
    }

    public boolean isInSetVertices(int id) {
        for (int i = 0; i < setVertices.size(); i++) {
            Vertice v = setVertices.get(i);
            if (id == v.id) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Prim prim = new Prim();
        prim.runAlgorithm();
    }
}

class Vertice implements Comparable<Vertice> {

    public int id;
    public int key;
    public int parent;

    @Override
    public int compareTo(Vertice o) {
        if (key > o.key) {
            return 1;
        }
        if (key < o.key) {
            return -1;
        }
        return 0;
    }
}
