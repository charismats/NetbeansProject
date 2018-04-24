/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tilemap.editor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author CHAR0
 */
public class GridPanel extends JPanel implements MouseListener, MouseMotionListener{

    private static int GRID_WIDTH = 1280;
    private static int GRID_HEIGHT = 640;
    public static int TILE = 32;
    public static int SelTileX;
    public static int SelTileY;

    public int[][] tile_grid;
    public ArrayList<BufferedImage> tileImgs;
    public int currentImageIndex = -1;
    public String tileImgPath;

    private int GridStartX;
    private int GridStartY;

    public GridPanel() {
        tile_grid = new int[GRID_HEIGHT / TILE][GRID_WIDTH / TILE];
        for (int i = 0; i < tile_grid.length; i++) {
            for (int j = 0; j < tile_grid[i].length; j++) {
                tile_grid[i][j] = -1;
            }
        }
        SelTileX = -1;
        SelTileY = -1;
        tileImgs = new ArrayList<BufferedImage>();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void addNotify() {
        super.addNotify(); //To change body of generated methods, choose Tools | Templates.
        requestFocus();
    }

    private void drawGrid(Graphics2D g2d) {
        g2d.setPaint(Color.GRAY);
        //draw image grid
        for (int i = 0; i < tile_grid.length; i++) {
            for (int j = 0; j < tile_grid[i].length; j++) {
                int destX = j * TILE;
                int destY = i * TILE;
                if (tile_grid[i][j] != -1) {
                    //draw buffer sub image
                    int selectTileX = tile_grid[i][j] % TILE;
                    int selectTileY = tile_grid[i][j] / TILE;
                    int srcX = selectTileX * TILE;
                    int srcY = selectTileY * TILE;
                    BufferedImage tileImg = tileImgs.get(currentImageIndex);
                    if( tileImg != null){
                        BufferedImage subimage = tileImg.getSubimage(srcX, srcY, TILE, TILE);
                        g2d.drawImage(subimage, destX, destY, null);
                    }
                } else {
                    g2d.fillRect(destX, destY, TILE, TILE);
                }
            }
        }
        g2d.setPaint(Color.BLUE);
        //draw grid
        for (int i = 0; i < GRID_WIDTH / TILE; i++) {
            g2d.drawLine(i * TILE, 0, i * TILE, GRID_HEIGHT);
        }

        for (int i = 0; i < GRID_HEIGHT / TILE; i++) {
            g2d.drawLine(0, i * TILE, GRID_WIDTH, i * TILE);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        drawGrid(g2d);
    }
    
    public void LoadBufferedTileSet(){
         try {
            BufferedImage tileImg = ImageIO.read(new File(tileImgPath));
            tileImgs.add(tileImg);
            
        } catch (IOException ex) {
            Logger.getLogger(GridPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if( SelTileX != -1 && SelTileY != -1){
            int mouseX = e.getX();
            int mouseY = e.getY();
            int gridX = mouseX / TILE;
            int gridY = mouseY / TILE;
            tile_grid[gridY][gridX] = SelTileY * TILE + SelTileX;
            repaint();
        }
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

    @Override
    public void mouseDragged(MouseEvent e) {
        if( SelTileX != -1 && SelTileY != -1){
            int mouseX = e.getX();
            int mouseY = e.getY();
            int gridX = mouseX / TILE;
            int gridY = mouseY / TILE;
            tile_grid[gridY][gridX] = SelTileY * TILE + SelTileX;
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
}
