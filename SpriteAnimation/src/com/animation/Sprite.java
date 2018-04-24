/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.animation;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author User
 */
public class Sprite {
    BufferedImage image;
    public int posx;
    public int posy;
    public int frmX;
    public int frmY;
    public int numFrameX;
    public int numFrameY;
    public int frmWidth;
    public int frmHeight;
    public enum Move{
        UP,
        DOWN,
        LEFT,
        RIGHT
    };
    Move current;
    Move prev;
    public Sprite(String imgPath){
        try {
            image = ImageIO.read(new File(imgPath));
            posx = posy = 0;
            frmX = frmY = 0;
            numFrameX = numFrameY = 4;
            frmWidth = image.getWidth()/numFrameX;
            frmHeight = image.getHeight() / numFrameY;
            prev = current = Move.DOWN;
        } catch (IOException ex) {
            Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void advance(){
        if (prev != current && current == Move.DOWN){
            frmX = 0;
            frmY = 0;
        }
        else if ( prev != current && current == Move.LEFT){
            frmX = 0;
            frmY = 1;
        }
        else if ( prev != current && current == Move.RIGHT){
            frmX = 0;
            frmY = 2;
        }else if ( prev != current && current == Move.UP){
            frmX = 0;
            frmY = 3;
        }
        if( prev == current){
            frmX = frmX+1;
            frmX %= numFrameX;
           
        }
        prev = current;
        
    }
    
    public void draw(Graphics2D g2d){
        
       BufferedImage sprite = image.getSubimage(frmX * frmWidth,frmY * frmHeight,frmWidth, frmHeight);
       g2d.drawImage(sprite, posx, posy, null);
    }
}
