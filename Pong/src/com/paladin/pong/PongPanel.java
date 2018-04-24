/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paladin.pong;

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
 * @author CHAR0
 */
public class PongPanel extends JPanel implements ActionListener, KeyListener {

    private Player player;
    private AI ai;

    private Ball ball;
    private boolean gameOver = false;
    private boolean drawOnce = false;
    private int scrH;
    private int scrW;
    private Timer timer;

    public PongPanel() {
        player = new Player();
        ball = new Ball();
        ai = new AI();
        gameOver = false;
        addKeyListener(this);
        timer = new Timer(2, this);
        timer.start();

    }

    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        scrW = getWidth();
        scrH = getHeight();
        ai.setX(scrW - ai.getWidth());
        Graphics2D g2d = (Graphics2D) g;
        player.draw(g2d);
        if (!gameOver) {
            ball.draw(g2d);
        }
        ai.draw(g2d);
        if (gameOver) {
            g2d.drawString("Game Over. Press Enter to play again", 100, 100);
        }
        drawOnce = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            if (ball.getY() <= 0) {
                ball.setDy(1);
            } else if (ball.getY() + ball.getR() >= scrH) {
                ball.setDy(-1);
            }
            ball.update();
            if ((ball.getX() <= 0 || ball.getX() >= scrW) && drawOnce) {
                //ball = new Ball();
                System.out.println("Ball x = " + ball.getX());
                gameOver = true;
            }
            if (ball.getY() < ai.getY()) {
                ai.move(-20);
            } else if (ball.getY() > ai.getY() + ai.getHeight()) {
                ai.move(20);
            }

            checkCollision();
            if (ai.getY() <= 0) {
                ai.setY(0);
            } else if (ai.getY() + ai.getHeight() >= scrH) {
                ai.setY(scrH - ai.getHeight());
            }
        }

        repaint();
    }

    private void checkCollision() {
        if (ball.getX() <= player.getX() + player.getWidth()
                && ball.getY() >= player.getY() && ball.getY() <= player.getY() + player.getHeight()) {
            ball.setDx(1);
        }

        if (ball.getX() + ball.getR() >= ai.getX()
                && ball.getY() >= ai.getY() && ball.getY() <= ai.getY() + ai.getHeight()) {
            //System.out.println(ball.getX() + ball.getR()+ " hit "+ai.getX());
            ball.setDx(-1);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.move(-20);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.move(20);
        }
        if (player.getY() <= 0) {
            player.setY(0);
        } else if (player.getY() + player.getHeight() >= scrH) {
            player.setY(scrH - player.getHeight());
        }
        if( e.getKeyCode() == KeyEvent.VK_ENTER && gameOver){
            gameOver = false;
            ball = new Ball();
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
