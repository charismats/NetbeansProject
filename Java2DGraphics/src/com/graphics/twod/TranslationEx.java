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
public class TranslationEx extends JPanel{
    @Override 
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setPaint(Color.RED);
        g2d.fillRect(20, 20, 80, 50);
        g2d.translate(100, 0);
        g2d.fillRect(20, 20, 80, 50);
    }
}
