/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javax.swing.JFrame;

import javax.swing.JPanel;

public class Pong extends JFrame {

    final static int WINDOW_WIDTH = 600;

    final static int WINDOW_HEIGHT = 400;


    public Pong() {

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new GamePanel());

        setVisible(true);

    }

    public static void main(String[] args) {

        new Pong();

    }

}

