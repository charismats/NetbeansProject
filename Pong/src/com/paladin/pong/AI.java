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
public class AI {

    private int x;
    private int y;
    private int width = 10;
    private int height = 200;

    public AI() {
        
    }

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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public void draw(Graphics2D g2d){
        g2d.setPaint(Color.BLACK);
        g2d.fillRect(x, y, width, height);
    }
    public void move(int dy){
        y += dy;
    }
}
