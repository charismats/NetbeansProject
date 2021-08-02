/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paladin.graph;

import java.util.ArrayList;

/**
 *
 * @author CHAR0
 */
public class Boruvka {

    public int[][] graph = {
        {0, 7, 0, 5, 0, 0, 0},
        {7, 0, 8, 9, 7, 0, 0},
        {0, 8, 0, 0, 5, 0, 0},
        {5, 9, 0, 0, 15, 6, 0},
        {0, 7, 5, 15, 0, 8, 9},
        {0, 0, 0, 6, 8, 0, 11},
        {0, 0, 0, 0, 9, 11, 0}

    };
    public ArrayList<Set> listSets;
    public Set MST;
    public boolean[][] edgeAdded;
    public ArrayList<Edge> MSTEdges;

    public Boruvka() {
        listSets = new ArrayList<>();
        MSTEdges = new ArrayList<>();
        MST = new Set();
        edgeAdded = new boolean[graph.length][graph[0].length];
    }

    public void runAlgorithm() {
        while (!isAllConnected()) {
            //loop through all nodes and find minimum edge
            Edge minEdge = null;
            boolean isAllConnected = false;
            for (int node = 0; node < graph.length; node++) {
                int minCost = Integer.MAX_VALUE;
                for (int j = 0; j < graph[node].length; j++) {
                    if (node != j && graph[node][j] != 0 && !edgeAdded[node][j] && graph[node][j] < minCost) {
                        minCost = graph[node][j];
                        minEdge = new Edge();
                        minEdge.v1 = node;
                        minEdge.v2 = j;
                        minEdge.weight = graph[node][j];
                    }
                }
                //add minimum edge to the MST
                if (minEdge != null && !edgeAdded(minEdge) && !isAllConnected) {
                    MSTEdges.add(minEdge);
                    Set s = new Set();
                    s.vertices.add(minEdge.v1);
                    s.vertices.add(minEdge.v2);
                    edgeAdded[minEdge.v1][minEdge.v2] = true;

                    if (isSetConnected(MST, s, minEdge) && node != 0) {
//                        System.out.println("Edge added = " + (char) (minEdge.v1 + 'A') + " -> " + (char) (minEdge.v2 + 'A'));
                        Union(MST, s);
                        listSets.add(s);
                        //System.out.println("Enter here");
                    } else if (node == 0) {
//                        System.out.println("Edge added = " + (char) (minEdge.v1 + 'A') + " -> " + (char) (minEdge.v2 + 'A'));
                        Union(MST, s);
                        listSets.add(s);
                    } else {
                        boolean anyConnectedWithExistingSet = false;
                        for (Set s1 : listSets) {
                            if (isSetConnected(s1, s, minEdge)) {
                                Union(s1, s);
//                                System.out.println("Edge added = " + (char) (minEdge.v1 + 'A') + " -> " + (char) (minEdge.v2 + 'A'));
//                                System.out.println("Set connected with existing sets");
                                anyConnectedWithExistingSet = true;
                            }
                        }
                        if (!anyConnectedWithExistingSet) {
                            listSets.add(s);
                        }

                    }
                    //join members of listset if isSameSet
                }
                for (Set s1 : listSets) {
                    if (isSetConnected(MST, s1, minEdge)) {
                        Union(MST, s1);
//                        printSet(MST);
//                        printSet(s1);
                    }
                }
                if (isAllConnected()) {
                    isAllConnected = true;
                    break;
                }
            }
        }
        System.out.println("Algorithm finished");
        printMST();
    }

    private void printSet(Set s) {
        for (int v : s.vertices) {
            System.out.print((char) (v + 'A') + ",");
        }
        System.out.println("");
    }

    private boolean edgeAdded(Edge e) {

        for (Edge edge : MSTEdges) {
            if (edge.v1 == e.v1 && edge.v2 == e.v2
                    || edge.v2 == e.v1 && edge.v1 == e.v2) {
                return true;
            }
        }
        return false;
    }

    private void printSetMST() {
        for (int vertice : MST.vertices) {
            char v = (char) (vertice + 'A');
            System.out.println("Vertice : " + v);
        }
        System.out.println("MST vertices count = " + MST.vertices.size());
    }

    private void printMST() {
        System.out.println("MST contains vertices : ");
        for (int vertice : MST.vertices) {
            char v = (char) (vertice + 'A');
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

    private boolean isSameSet(Set a, Set b) {
        for (int vertice : a.vertices) {
            if (!b.vertices.contains(vertice)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSetConnected(Set s1, Set s2, Edge minEdge) {
        boolean isConnected = false;
        for (int v : s1.vertices) {
            for (int w : s2.vertices) {
                if ((v == minEdge.v1 && w == minEdge.v2) || v == minEdge.v2 && w == minEdge.v1) {
                    isConnected = true;
                    break;
                }
            }
        }
        return isConnected;
    }

    private void Union(Set s1, Set s2) {
        boolean notSameSet = true;
        for (int v : s1.vertices) {
            for (int w : s2.vertices) {
                if (v == w) {
                    notSameSet = false;

                }
            }
        }
        if (notSameSet) {
            for (int w : s2.vertices) {
                s1.vertices.add(w);
            }
        } else {
            for (int w : s2.vertices) {
                if (!s1.vertices.contains(w)) {
                    s1.vertices.add(w);
                }
            }
        }

    }

    private boolean isAllConnected() {
        int countNode = 0;
        return MST.vertices.size() == graph.length;
    }

    private class Set {

        public ArrayList<Integer> vertices;

        public Set() {
            vertices = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Boruvka boruvka = new Boruvka();
        boruvka.runAlgorithm();
    }
}
