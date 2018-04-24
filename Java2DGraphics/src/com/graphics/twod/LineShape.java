/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphics.twod;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author CHAR0
 */
public class LineShape extends JPanel{
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2D = (Graphics2D) g;
        //draw Line
        g2D.setColor(Color.BLUE);
        g2D.drawLine(30, 30, 200, 30);
        g2D.drawLine(200, 30, 30, 200);
        g2D.drawLine(30, 200, 200, 200);
        g2D.drawLine(200, 200, 30, 30);
    }
}
