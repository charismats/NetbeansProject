/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author charisma
 */
public class TetrisGame  extends JFrame{
    TetrisPanel tetris;
    public TetrisGame(String title){
        super(title);
        tetris = new TetrisPanel();
        this.getContentPane().add(tetris);
        setPreferredSize(new Dimension(600,800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[]args){
        JFrame frame = new TetrisGame("Tetris Game");
        frame.pack();
        frame.setVisible(true);
    }
}
