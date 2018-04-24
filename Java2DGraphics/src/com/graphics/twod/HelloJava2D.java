/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphics.twod;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author CHAR0
 */
public class HelloJava2D extends JPanel implements KeyListener{
    private int x = 30;
    private int y = 30;
    
    public HelloJava2D(){
        addKeyListener(this);
        //requestFocus();
    }
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        Font f = new Font("serif", Font.PLAIN, 40);
        g2d.setFont(f);
        g2d.drawString("Hello World Java 2D", x, y);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       if (e.getKeyCode() == KeyEvent.VK_DOWN){
           //System.out.println("Key Down was Pressed");
           y++;
       }
       if (e.getKeyCode() == KeyEvent.VK_RIGHT){
           x++;
       }
       if( e.getKeyCode() == KeyEvent.VK_LEFT){
           x--;
       }
       if( e.getKeyCode() == KeyEvent.VK_UP){
           y--;
       }
       repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
}
