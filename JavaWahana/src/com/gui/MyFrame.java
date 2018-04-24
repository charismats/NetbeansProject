/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author CHAR0
 */
public class MyFrame extends JFrame{
    MyPanel panel;
    public MyFrame(){
        panel = new MyPanel();
        setContentPane(panel);
        this.setPreferredSize(new Dimension(800,600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    public static void main(String []args){
        MyFrame frm = new MyFrame();
    }
}
