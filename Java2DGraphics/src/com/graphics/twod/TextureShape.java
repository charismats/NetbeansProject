/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphics.twod;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author CHAR0
 */
public class TextureShape extends JPanel{
    private BufferedImage brick;
    private BufferedImage crate;
    private BufferedImage grass;
    
    private TexturePaint brickTp;
    private TexturePaint crateTp;
    private TexturePaint grassTp;
    
    public TextureShape(){
        try {
            brick = ImageIO.read(new File("brick.jpg"));
            crate = ImageIO.read(new File("crate.jpg"));
            grass = ImageIO.read(new File("grass.jpg"));
            
        } catch (IOException ex) {
            Logger.getLogger(TextureShape.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        
        brickTp = new TexturePaint(brick, new Rectangle(0,0,64,64));
        crateTp = new TexturePaint(crate, new Rectangle(0,0,64,64));
        grassTp = new TexturePaint(grass, new Rectangle(0,0,64,64));
        
        g2d.setPaint(brickTp);
        g2d.fillRect(10, 15, 100, 100);
        
        g2d.setPaint(crateTp);
        g2d.fillRect(130, 15, 100, 100);
            
        g2d.setPaint(grassTp);
        g2d.fillRect(250, 15, 100, 100);
    }
}
