/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphics.twod;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
public class SunCloudShape extends JPanel implements ActionListener{
    private Image sun;
    private Image cloud;
    private final int DELAY = 600;
    private Timer timer;
    private float alpha = 1f;
    
    public SunCloudShape(){
        try {
            sun = ImageIO.read(new File("sun.png"));
            cloud = ImageIO.read(new File("clouds.png"));
            
            timer = new Timer(DELAY, this);
            timer.start();
            
        } catch (IOException ex) {
            Logger.getLogger(SunCloudShape.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D)g;
        BufferedImage buffImg = new BufferedImage(200,200,BufferedImage.TYPE_INT_ARGB);
        Graphics2D gbi = buffImg.createGraphics();
        
        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        gbi.drawImage(sun, 0, 0,null);
        gbi.setComposite(ac);
        gbi.drawImage(cloud, 0,0,null);
        
        g2d.drawImage(buffImg, 0,0, null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        alpha -= 0.1f;
        if( alpha < 0){
            alpha = 0f;
            timer.stop();
        }
        repaint();
    }
}
