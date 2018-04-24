/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphics.twod;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author CHAR0
 */
public class MyFrame extends JFrame{
    public MyFrame(){
        setTitle("Java 2D Graphics");
        setPreferredSize( new Dimension(600,600));
        //setLocationRelativeTo(null);
        //add(new MyPanel());
        //add(new HelloJava2D());
        //add(new LineShape());
        //add(new BasicStrokeShape());
        //add(new CapsShape());
        //add(new JoinsShape());
        add(new MyImagePanel());
        //add(new BasicShape());
        //add(new StarShape());
        //add(new AreaShape());
        //add(new ColourShape());
        //add(new GradientPaintShape());
        //add(new TextureShape());
        //add(new TransparentRectShape());
        //add(new CompositionShape());
        //add(new SunCloudShape());
        //add(new ClippingShape());
        //add(new ClippingShape2());
        //add(new TranslationEx());
        //add(new RotationEx());
        //add(new ScalingEx());
       // add(new BubbleShape());
       // add(new StarEffect());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
    public static void main(String[] args) {
        MyFrame frm = new MyFrame();
        frm.setVisible(true);
    }
}
