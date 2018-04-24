/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tilemap.editor;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author CHAR0
 */
public class TileFrame extends JFrame{
    public TilePanel tilePanel;
    private String tileImgPath;
    public static final int WIDTH  = 1024;
    public static final int HEIGHT = 600;
    
    public TileFrame(String tileImgPath){
        this.tileImgPath = tileImgPath;
        tilePanel = new TilePanel(tileImgPath);
        init();
        add(tilePanel);
        pack();
        setVisible(true);
    }
    
    public TileFrame(BufferedImage tileImg){
        tilePanel = new TilePanel(tileImg);
        init();
        add(tilePanel);
        pack();
        setVisible(true);
    }
    private void init(){
        setTitle("Tileset Image");
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
