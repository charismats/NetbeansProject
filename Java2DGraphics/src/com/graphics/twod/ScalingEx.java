/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphics.twod;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;

/**
 *
 * @author CHAR0
 */
public class ScalingEx extends JPanel{
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setPaint(Color.yellow);
        g2d.fillRect(20, 20, 80, 50);
        
        AffineTransform at1 = new AffineTransform();
        at1.translate(110, 20);
        at1.scale(0.5, 0.5);
        
        g2d.setTransform(at1);
        g2d.fillRect(0, 0, 80, 50);
        
        AffineTransform at2 = new AffineTransform();
        at2.translate(170, 20);
        at2.scale(1.5, 1.5);
        
        g2d.setTransform(at2);
        g2d.fillRect(0, 0, 80, 50);
    }
}
