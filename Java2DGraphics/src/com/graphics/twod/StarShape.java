/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphics.twod;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import javax.swing.JPanel;

/**
 *
 * @author CHAR0
 */
public class StarShape extends JPanel{
    private final double points[][] = { 
        { 0, 85 }, { 75, 75 }, { 100, 10 }, { 125, 75 }, 
        { 200, 85 }, { 150, 125 }, { 160, 190 }, { 100, 150 }, 
        { 40, 190 }, { 50, 125 }, { 0, 85 } 
    };
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                             RenderingHints.VALUE_RENDER_QUALITY);
        
        g2d.setPaint(Color.GRAY);
        //g2d.translate(25, 5);
        
        GeneralPath star = new GeneralPath();
        star.moveTo(points[0][0], points[0][1]);
        g2d.drawString("("+points[0][0]+","+points[0][1]+")", (int)points[0][0], (int)points[0][1]);
        for(int i = 1; i < points.length; i++){
            star.lineTo(points[i][0], points[i][1]);
            g2d.drawString("("+points[i][0]+","+points[i][1]+")", (int)points[i][0], (int)points[i][1]);
        }
        star.closePath();
        g2d.draw(star);
             
    }
}
