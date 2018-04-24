/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadtree;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author CHAR0
 */
public class QuadTreeFrame extends JFrame{
    public QuadTreeFrame(){
        setTitle("Quad Tree Demo");
        setPreferredSize(new Dimension(850,650));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new QuadPanel());
        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        QuadTreeFrame qtf = new QuadTreeFrame();
    }
}
