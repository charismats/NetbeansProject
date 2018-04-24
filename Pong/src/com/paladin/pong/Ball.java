/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paladin.pong;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author CHAR0
 */
public class Ball {
    private int x;
    private int y;
    private int r = 10;
    private int dx = 1;
    private int dy = 1;
    private int step = 1;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
    public Ball(){
        x = 10;
        y = 10;
    }
    
    public void update(){
       
       x += dx * step;
       y += dy * step;
    }
    
    public void draw(Graphics2D g2d){
        g2d.setPaint(Color.RED);
        g2d.fillOval(x,y, r,r);
    }
}
