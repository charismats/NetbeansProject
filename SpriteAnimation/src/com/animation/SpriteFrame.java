/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.animation;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class SpriteFrame extends JFrame {
    public SpriteFrame(int w, int h){
        getContentPane().add(new SpritePanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(w,h));
        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        SpriteFrame frm = new SpriteFrame(800,600);
    }
}
