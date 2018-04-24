/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tilemap.editor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class TilePanel extends JPanel implements MouseListener{
    private String tileImgPath;
    public BufferedImage tileImg;
    private int tileCountW;
    private int tileCountH;
    public TilePanel(String tileImgPath){
        this.tileImgPath = tileImgPath;
        addMouseListener(this);
        try {
            tileImg = ImageIO.read(new File(tileImgPath));
            tileCountW = tileImg.getWidth() / GridPanel.TILE;
            tileCountH = tileImg.getHeight() / GridPanel.TILE;
            
        } catch (IOException ex) {
            Logger.getLogger(TilePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public TilePanel(BufferedImage tileImg){
        this.tileImg = tileImg;
        addMouseListener(this);
        tileCountW = tileImg.getWidth() / GridPanel.TILE;
        tileCountH = tileImg.getHeight() / GridPanel.TILE;
    }
    @Override
    public void addNotify() {
        super.addNotify(); //To change body of generated methods, choose Tools | Templates.
        requestFocus();
    }
    
    private void drawSourceTiles(Graphics2D g2d){
        //g2d.drawImage(tileImg, 0, 0, null);
        
        g2d.setPaint(Color.RED);
        for(int i = 0; i < tileCountH; i++){
            for(int j = 0 ; j < tileCountW; j++ ){
                int posX = j * GridPanel.TILE;
                int posY = i * GridPanel.TILE;
                BufferedImage subImage = tileImg.getSubimage(posX, posY, GridPanel.TILE, GridPanel.TILE);
                g2d.drawImage(subImage, posX, posY, null);
                g2d.drawRect(posX, posY, GridPanel.TILE, GridPanel.TILE);
                
            }
        }
        if( GridPanel.SelTileX != -1 && GridPanel.SelTileY != -1){
            int posX = GridPanel.SelTileX * GridPanel.TILE;
            int posY = GridPanel.SelTileY * GridPanel.TILE;
            g2d.setPaint(Color.BLACK);
            g2d.setStroke(new BasicStroke(2.0f));
            g2d.drawRect(posX, posY, GridPanel.TILE, GridPanel.TILE);
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D)g;
        drawSourceTiles(g2d);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       int mouseX = e.getX();
       int mouseY = e.getY();
       GridPanel.SelTileX = mouseX / GridPanel.TILE;
       GridPanel.SelTileY = mouseY / GridPanel.TILE;
       repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
