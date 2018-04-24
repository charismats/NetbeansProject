/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadtree;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author CHAR0
 */
public class Quad {

    public Rectangle rect;
    public ArrayList<Point> points;
    public Quad q1;
    public Quad q2;
    public Quad q3;
    public Quad q4;
    public int depth = 0;
    public Quad() {
        
        points = new ArrayList<>();
        
    }

    public void drawQuad(Graphics2D g2d) {
        //draw rect
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(1.0f));
        if( rect != null)
            g2d.drawRect(rect.x, rect.y, rect.width, rect.height);
        g2d.setColor(Color.RED);

        g2d.setStroke(new BasicStroke(5.0f));
        for (Point p : points) {
            g2d.drawLine(p.x, p.y, p.x, p.y);
        }
        if(q1 != null)
            q1.drawQuad(g2d);
        if(q2 != null)
            q2.drawQuad(g2d);
        if(q3 != null)
            q3.drawQuad(g2d);
        if(q4 != null)
            q4.drawQuad(g2d);
    }

    public boolean hasPoints() {
        return this.points.size() > 0;
    }
}
