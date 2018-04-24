/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tilemap.editor;


import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author CHAR0
 */
public class TileMapFrame extends JFrame {

    public static final int WIDTH = 1360;
    public static final int HEIGHT = 768;
    private GridPanel panel;
    private TileFrame tFrame;
    public TileMapFrame() {
        init();
        panel = new GridPanel();
        add(panel);
        pack();
        setVisible(true);
    }

    public void init() {
        setTitle("Tile Map Editor");
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem loadImgMenu = new JMenuItem("Load Tileset Image");
        loadImgMenu.setMnemonic(KeyEvent.VK_L);
        loadImgMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame f = null;
                FileDialog fd;
                fd = new FileDialog(f, "Choose a tileset image", FileDialog.LOAD);
                fd.setVisible(true);
                String filePath = fd.getFile();
                System.out.println(filePath);
                if (filePath != null) {
                    panel.tileImgPath = filePath;
                    panel.LoadBufferedTileSet();
                    panel.currentImageIndex++;
                    tFrame = new TileFrame(filePath);
                    tFrame.setVisible(true);
                }

                System.out.println(filePath);

            }

        });
        JMenuItem saveTilesMenu = new JMenuItem("Save Tileset");
        saveTilesMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame f = null;
                FileDialog fd;
                fd = new FileDialog(f, "Save to a File", FileDialog.SAVE);
                //fd.setFilenameFilter(filter);
                fd.setVisible(true);
                String filePath = fd.getFile();
                if( filePath != null)
                    SaveTileSet(filePath);
            }

        });
        JMenuItem loadMapMenu = new JMenuItem("Load File Map");
        loadMapMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame f = null;
                FileDialog fd;
                fd = new FileDialog(f, "Save to a File", FileDialog.LOAD);
                fd.setVisible(true);
                String filePath = fd.getFile();
                if( filePath != null)
                    ReadTileSet(filePath);
            }

        });
        JMenuItem exitMenu = new JMenuItem("Exit");
        exitMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });

        fileMenu.add(loadImgMenu);
        fileMenu.add(saveTilesMenu);
        fileMenu.add(loadMapMenu);
        fileMenu.addSeparator();
        fileMenu.add(exitMenu);
        menuBar.add(fileMenu);

        setJMenuBar(menuBar);
    }

    private void SaveTileSet(String filePath) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(panel.tileImgPath+"\n");
            bw.write(panel.tile_grid.length + "\n");
            bw.write(panel.tile_grid[0].length + "\n");
            for (int i = 0; i < panel.tile_grid.length; i++) {
                for (int j = 0; j < panel.tile_grid[i].length; j++) {
                    bw.write(panel.tile_grid[i][j] + " ");
                }
                bw.write("\n");
            }
            bw.close();

            JOptionPane.showMessageDialog(null, "File Saved", "Information", JOptionPane.DEFAULT_OPTION);

        } catch (IOException ex) {
            Logger.getLogger(TileMapFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void ReadTileSet(String filePath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String imgPath = br.readLine();
            panel.tileImgPath = imgPath;
            panel.LoadBufferedTileSet();
            panel.currentImageIndex++;
            
            tFrame = new TileFrame(imgPath);
            tFrame.setVisible(true);
            
            int rows = Integer.parseInt(br.readLine());
            int cols = Integer.parseInt(br.readLine());
            panel.tile_grid = new int[rows][cols];
            for (int row = 0; row < rows; row++) {
                String line = br.readLine();
                String[] tokens = line.split(" ");
                for (int col = 0; col < cols; col++) {
                    panel.tile_grid[row][col] = Integer.parseInt(tokens[col]);
                }
            }
            br.close();
            panel.repaint();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TileMapFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TileMapFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new TileMapFrame();
    }
}
