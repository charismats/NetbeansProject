/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphics.twod;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author CHAR0
 */
public class RotationEx extends JPanel implements ActionListener{
    
    private Timer timer;
    private double rot;
    public RotationEx(){
        timer = new Timer(1000, this);
        timer.start();
        rot = 0;
    }
    
    
    @Override 
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setPaint(Color.RED);
        g2d.fillRect(20, 20, 80, 50);
        g2d.translate(150, 0);
        g2d.rotate(rot);
        g2d.fillRect(0, 0, 80, 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        rot += Math.PI/12;
        rot %= 2*Math.PI;
        repaint();
    }
}
