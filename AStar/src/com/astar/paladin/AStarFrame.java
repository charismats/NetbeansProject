/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astar.paladin;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author CHAR0
 */
public class AStarFrame extends JFrame{
    public AStarFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new AStarPanel());
        this.setPreferredSize(new Dimension(800,800));
        this.pack();
        this.setTitle("AStar Demo");
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        AStarFrame frm = new AStarFrame();
    }
}
