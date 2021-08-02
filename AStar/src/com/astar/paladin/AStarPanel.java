/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astar.paladin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author CHAR0
 */
public class AStarPanel extends JPanel implements MouseListener, KeyListener {

    private AStar astar;
    private int GRIDW = 30;
    private Node start;
    private Node end;

    public AStarPanel() {
        astar = new AStar();
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        requestFocus();
        generateRandomMap();
    }

    @Override
    public void disable() {
        super.disable(); //To change body of generated methods, choose Tools | Templates.
    }

    public void generateRandomMap() {
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            int y = rnd.nextInt(AStar.GRIDSIZE);
            int x = rnd.nextInt(AStar.GRIDSIZE);
            astar.graph[y][x] = 2;
        }
    }

    public void runAlgorithm() {
        System.out.println("Start: " + start);
        System.out.println("End : " + end);
        astar.searchPath(start, end);
        if (astar.foundDestination) {
            ArrayList<Node> path = astar.path;
            Node curr = path.get(path.size() - 1);
            while (curr != null) {
                //System.out.println(curr);
                if (curr.id != start.id && curr.id != end.id) {
                    astar.graph[curr.y][curr.x] = 4;
                }
                curr = curr.parent;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Cannot Find Solution Path");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        for (int y = 0; y <= AStar.GRIDSIZE; y++) {
            g2d.drawLine(10, 10 + y * GRIDW, 10 + AStar.GRIDSIZE * GRIDW, 10 + y * GRIDW);
        }
        for (int x = 0; x <= AStar.GRIDSIZE; x++) {
            g2d.drawLine(10 + x * GRIDW, 10, 10 + x * GRIDW, 10 + AStar.GRIDSIZE * GRIDW);
        }

        //draw shades of the graph
        for (int y = 0; y < astar.graph.length; y++) {
            for (int x = 0; x < astar.graph[0].length; x++) {
                if (astar.graph[y][x] == 1) {
                    g2d.setColor(Color.GREEN);
                    g2d.fillRect(x * GRIDW + 10, y * GRIDW + 10, GRIDW, GRIDW);
                } else if (astar.graph[y][x] == 2) {
                    g2d.setColor(Color.BLUE);
                    g2d.fillRect(x * GRIDW + 10, y * GRIDW + 10, GRIDW, GRIDW);
                } else if (astar.graph[y][x] == 3) {
                    g2d.setColor(Color.RED);
                    g2d.fillRect(x * GRIDW + 10, y * GRIDW + 10, GRIDW, GRIDW);
                } else if (astar.graph[y][x] == 4) {
                    g2d.setColor(Color.YELLOW);
                    g2d.fillRect(x * GRIDW + 10, y * GRIDW + 10, GRIDW, GRIDW);
                }
            }
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX() / GRIDW;
        int y = e.getY() / GRIDW;
        if (x >= 0 && x < AStar.GRIDSIZE && y >= 0 && y < AStar.GRIDSIZE) {
//        System.out.println("Clicked at : (" + y + ","+x+")");
            astar.graph[y][x]++;
            if (astar.graph[y][x] > 3) {
                astar.graph[y][x] = 0;
            }
        }
        for (int i = 0; i < AStar.GRIDSIZE; i++) {
            for (int j = 0; j < AStar.GRIDSIZE; j++) {
                if (astar.graph[i][j] == 1) {
                    start = new Node(i * AStar.GRIDSIZE + j, i, j);
                } else if (astar.graph[i][j] == 3) {
                    end = new Node(i * AStar.GRIDSIZE + j, i, j);
                }
            }
        }

        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            runAlgorithm();
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            astar = new AStar();
            generateRandomMap();
        }
        repaint();
    }
}
