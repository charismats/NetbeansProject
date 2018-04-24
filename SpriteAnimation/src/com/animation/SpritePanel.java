/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.animation;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class SpritePanel extends JPanel implements ActionListener, KeyListener {

    Sprite angel;
    Timer timer;

    public SpritePanel() {
        angel = new Sprite("angel_sprite.png");

        timer = new Timer(100, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2d = (Graphics2D) g;
        angel.draw(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angel.advance();
        //System.out.println("FrmX Angel : " + angel.frmX);

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("KeyPressed");
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            angel.current = Sprite.Move.LEFT;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            angel.current = Sprite.Move.RIGHT;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            angel.current = Sprite.Move.DOWN;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            angel.current = Sprite.Move.UP;
        }
        if (angel.current == Sprite.Move.DOWN) {
            angel.posy += 10;
        }
        if (angel.current == Sprite.Move.UP) {
            angel.posy -= 10;
        }
        if (angel.current == Sprite.Move.LEFT) {
            angel.posx -= 10;
        }
        if (angel.current == Sprite.Move.RIGHT) {
            angel.posx += 10;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
