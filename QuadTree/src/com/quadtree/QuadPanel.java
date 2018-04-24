/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadtree;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author CHAR0
 */
public class QuadPanel extends JPanel{
    
    public QuadTree qt;
    public ArrayList<Point> points;
    public QuadPanel(){
        qt = new QuadTree();
        Random r = new Random();
        points = new ArrayList<>();
        for(int i = 0;  i < 200; i++){
            Point p = new Point(r.nextInt(800), r.nextInt(600));
            points.add(p);
        }
        qt.buildTree(qt.root, points, new Rectangle(800,600), 0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        Graphics2D g2d = (Graphics2D)g;
        qt.root.drawQuad(g2d);
    }
    
    
}
