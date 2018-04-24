/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadtree;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author CHAR0
 */
public class QuadTree {
    public Quad root;
    
    public QuadTree(){
        root = new Quad();
    }
    public void buildTree(Quad node, ArrayList<Point> points, Rectangle rect, int depth ){
        node.rect = rect;
        if( points.size() >= 2){
            ArrayList<Point> subPoints1 = new ArrayList<>();
            System.out.println("Sub Point 1: depth = "+depth);
            System.out.println("Rect q1= ("+rect.x + ","+rect.y+","+rect.width/2+","+rect.height/2+")");
            //build tree q1 region
            for(Point p : points){
                if( p.x >= rect.x && p.x <= rect.x + rect.width/2 && p.y >= rect.y && p.y <=  rect.y + rect.height /2){
                    subPoints1.add(p);
                    System.out.println(p.x + " " + p.y);
                }
            }
            node.q1 = new Quad();
            buildTree(node.q1, subPoints1, new Rectangle(rect.x, rect.y, rect.width/2, rect.height/2), depth + 1);
            ArrayList<Point> subPoints2 = new ArrayList<>();
            System.out.println("Sub Point 2: depth = "+depth);
            System.out.println("Rect q2= ("+rect.width/2 + ","+rect.y+","+rect.width/2+","+rect.height/2+")");
            //build tree q2 region
            for(Point p : points){
                if( p.x >= rect.x + rect.width/2 && p.x <= rect.x + rect.width && p.y >= rect.y && p.y <= rect.y + rect.height /2){
                    subPoints2.add(p);
                    System.out.println(p.x + " "+p.y);
                }
            }
            node.q2 = new Quad();
            buildTree(node.q2, subPoints2, new Rectangle(rect.x + rect.width/2, rect.y, rect.width/2, rect.height/2), depth + 1);
            ArrayList<Point> subPoints3 = new ArrayList<>();
            System.out.println("Sub Point 3: depth = "+depth);
            System.out.println("Rect q3= ("+rect.x + ","+rect.height/2+","+rect.width/2+","+rect.height/2+")");
            //build tree q3 region
            for(Point p : points){
                if( p.x >= rect.x && p.x <= rect.x + rect.width/2 && p.y >= rect.y + rect.height/2 && p.y <= rect.y + rect.height){
                    subPoints3.add(p);
                    System.out.println(p.x + " "+p.y);
                }
                    
            }
            node.q3 = new Quad();
            buildTree(node.q3, subPoints3, new Rectangle(rect.x, rect.y + rect.height/2, rect.width/2, rect.height/2), depth + 1);
            ArrayList<Point> subPoints4 = new ArrayList<>();
            System.out.println("Sub Point 4: depth = "+depth);
            System.out.println("Rect q4= ("+rect.width/2 + ","+rect.height/2+","+rect.width/2+","+rect.height/2+")");
            //build tree q4 region
            for(Point p : points){
                if( p.x >= rect.x + rect.width/2 && p.x <= rect.x + rect.width && p.y >= rect.y + rect.height/2 && p.y <= rect.y + rect.height){
                    subPoints4.add(p);
                    System.out.println(p.x +  " "+p.y);
                }
            }
            node.q4 = new Quad();
            buildTree(node.q4, subPoints4, new Rectangle(rect.x + rect.width/2, rect.y + rect.height/2, rect.width/2, rect.height/2), depth + 1);
            
        }else{
            for(Point p : points){
                //System.out.println(p.x + " "+p.y);
                node.points.add(p);
            }
        }
    }
}
