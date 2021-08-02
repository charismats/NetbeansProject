/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.paladin.graph;
import java.util.Collections;
import java.util.PriorityQueue;
/**
 *
 * @author charisma
 * @version 1.0
 * @since April, 2014
 */
public class Dijkstra {
    //Graph 1 : 5 cities
    private int[][] graph = {
        { 0, 1, 3, -1, -1},
        { 1, 0, 1,  2,  3},
        { 3, 1, 0, -1,  4},
        {-1, 2,-1,  0,  2},
        {-1, 3, 4,  2,  0},
    };
    /*//Graph 2 : 4 cities
    private int[][] graph = {
        { 0, 2, 4,  1},
        { 2, 0, 1,  1},
        { 4, 1, 0,  2},
        { 1, 1, 2,  0},
    };*/
    private City[] cities;
    private PriorityQueue<City> pq;
    private int startCity;
    public Dijkstra(){
        //create the array of cities
        cities = new City[graph.length];
        pq = new PriorityQueue<City>();
    }
    public void RunAlgorithm(int st){
       //invalid start city...must start at city 0 - (citylength-1)
        if( st < 0 || st > cities.length-1){
            System.out.println("Invalid start city. Start city must be within range of the graph.");
            return;
        }
        startCity = st;
        //initialize all cities and set its distance from start to big values
        for(int i = 0; i < cities.length;i++){
            cities[i] = new City(i, 1000, -1);
        }
        
        //add start city to pq
        cities[startCity].dist = 0; //make the start city shortest to 0
        pq.add(cities[startCity]);
        while(!pq.isEmpty()){ //keep processing the shortest priority queue
            City current = pq.remove();
            int id_curr = current.id;
            //explore neighbour
            for(int j = 0; j < graph.length; j++){
                if( id_curr != j && graph[id_curr][j] != -1){
                    //update the shortest distance of neighbour if smaller than current
                    //neighbour distance
                    if( current.dist + graph[id_curr][j] < cities[j].dist){
                        //update neighbour and add them into pq
                        cities[j].dist = current.dist + graph[id_curr][j];
                        cities[j].parent = id_curr;
                        pq.add(cities[j]);
                    }
                }
            }
        }
    }
    
    public void printShortestDistance(){
        System.out.println("The shortest distance of all cities from city " + getCityName(startCity));
        for(City c: cities){
            if( c != null){
                System.out.println("City = "+ getCityName(c.id)+" dist = "+c.dist+" parent = "+getCityName(c.parent));
                System.out.print("The path from "+getCityName(startCity)+ " to "+ getCityName(c.id)+ " : ");
                printPath(startCity,c.id);
            }
        }
    }
    public String getCityName(int i){
        if( i < 0)
            return "None";
        return (char)('A' + i)+"";
    }
    public void printPath(int from, int to){
        int c = to;
        String path = ""+getCityName(c);
        while( c != from){
            c = cities[c].parent;
            path = getCityName(c) + "=>" + path;
        }
        System.out.println(path);
    }
    public static void main(String args[]){
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.RunAlgorithm(0); //argument is the start city from where the dijkstra search begins
        dijkstra.printShortestDistance();
    }
}
class City implements Comparable<City>{
    public double dist; //shortest distance to source
    public int parent; //the path of parent city
    public int id; //the id of the city
    
    public City(){
        
    }
    public City(int i, int dist, int parent){
        this.id = i;
        this.dist = dist;
        this.parent = parent;
    }
    @Override
    public int compareTo(City o) {
       if( this.dist < o.dist)
           return -1;
       if( this.dist > o.dist)
           return 1;
       return 0;
       
    }
    
}

