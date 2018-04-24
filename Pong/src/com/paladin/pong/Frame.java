/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paladin.pong;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author CHAR0
 */
public class Frame extends JFrame{
    public Frame(){
        setTitle("2D Pong");
        setPreferredSize(new Dimension(800,600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new PongPanel());
        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        Frame frm = new Frame();
    }
}
