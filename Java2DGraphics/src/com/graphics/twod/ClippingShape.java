/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphics.twod;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author CHAR0
 */
public class ClippingShape extends JPanel implements ActionListener{

    private int pos_x = 8;
    private int pos_y = 8;
    private final int RADIUS = 200;
    private final int DELAY = 35;
    
    private Timer timer;
    private Image image;
    
    private final double[] delta = {3,3};
    
    public ClippingShape(){
        try {
            image = ImageIO.read(new File("sun.png"));
            int h = image.getHeight(this);
            int w = image.getWidth(this);
            System.out.println("w = "+w+" h = "+h);
            setPreferredSize(new Dimension(w,h));
            
            timer = new Timer(DELAY, this);
            timer.start();
        } catch (IOException ex) {
            Logger.getLogger(ClippingShape.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.clip(new Ellipse2D.Double(pos_x, pos_y, RADIUS, RADIUS));
        g2d.drawImage(image, 0, 0, null); 
        
    }
    
    private void moveCircle(){
        int w = getWidth();
        int h = getHeight();

        if (pos_x < 0) {
            
            delta[0] = Math.random() % 4 + 5;
        } else if (pos_x > w - RADIUS) {
            
            delta[0] = -(Math.random() % 4 + 5);
        }

        if (pos_y < 0 ) {
            
            delta[1] = Math.random() % 4 + 5;
        } else if (pos_y > h - RADIUS) {
            
            delta[1] = -(Math.random() % 4 + 5);
        }

        pos_x += delta[0];
        pos_y += delta[1];
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //moveCircle();
        repaint();
    }
    
}
