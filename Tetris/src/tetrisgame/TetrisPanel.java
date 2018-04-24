/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author charisma
 */
public class TetrisPanel extends JPanel implements KeyListener, ActionListener {

    static final int ROW = 20;
    static final int COL = 10;
    int[][] board = new int[ROW][COL];
    static final int TILE_S = 20;
    Kotak kotak;
    Timer t;
    Shape currShape;

    int tallestRow;
    int rowEmpty = 0;

    enum MOVE {

        DOWN,
        LEFT,
        RIGHT
    }

    static final int KOTAK = 0;
    static final int I = 1;
    static final int S1 = 2;
    static final int S2 = 3;
    static final int L1 = 4;
            
    public boolean init = false;

    public TetrisPanel() {
        setBackground(Color.WHITE);
        kotak = new Kotak(this);
        t = new Timer(500, this);
        t.start();
        addKeyListener(this);
        addItemToBoard();
    }

    public void getTallestRow() {
        rowEmpty = -1;
        tallestRow = -1;
        for (int i = board.length - 1; i >= 0; i--) {
            boolean rowKosong = true;
            int counterKosong = 0;
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 0) {
                    rowKosong = false;
                } else{
                    counterKosong++;
                }
            }
            if (counterKosong == board[0].length && rowEmpty < i) {
                rowEmpty = i;
            } else if (!rowKosong) {
                //System.out.println("Masuk sini untuk update row kosong");
                tallestRow = i;
            }
        }
    }

    public void addIToBoard() {
        Random r = new Random();
        int type = r.nextInt(2);
        I iShape = new I(this);
        iShape.type = type;
        if (type == 0) {
            iShape.posRow = 0;
            iShape.posCol = 0;
            for (int j = 0; j < iShape.length; j++) {
                board[iShape.posRow][j] = iShape.shape[type][iShape.height - 1][j];
            }

        } else {
            iShape.posRow = iShape.height - 1;
            iShape.posCol = 0;
            for (int i = 0; i < iShape.height; i++) {
                board[i][iShape.posCol] = iShape.shape[type][i][iShape.posCol];
            }
        }

        currShape = iShape;
    }

    public void addS1ToBoard() {
        Random r = new Random();
        //int type = r.nextInt(2);
        int type = 0;
        S1 s1 = new S1(this);
        s1.type = type;
        //copy from S1 to board
        for (int i = 0; i < s1.height[type]; i++) {
            for (int j = 0; j < s1.length[type]; j++) {
                board[i][j] = s1.shape[type][i + (4 - s1.height[type])][j];
            }
        }
        if (type == 0) {
            s1.posRow = s1.height[type] - 1;
            s1.posCol = 0;

        } else {
            s1.posRow = s1.height[type] - 1;
            s1.posCol = 0;
        }

        currShape = s1;
    }

    public void addS2ToBoard() {
        Random r = new Random();
        //int type = r.nextInt(2);
        int type = 0;
        S2 s2 = new S2(this);
        s2.type = type;
        //copy from S1 to board
        for (int i = 0; i < s2.height[type]; i++) {
            for (int j = 0; j < s2.length[type]; j++) {
                board[i][j] = s2.shape[type][i + (4 - s2.height[type])][j];
            }
        }
        if (type == 0) {
            s2.posRow = s2.height[type] - 1;
            s2.posCol = 0;

        } else {
            s2.posRow = s2.height[type] - 1;
            s2.posCol = 0;
        }

        currShape = s2;
    }

    public void addL1ToBoard() {
        Random r = new Random();
//        int type = r.nextInt(4);
        int type = 1;
        L1 l1 = new L1(this);
        l1.type = type;
        l1.posCol = 0;
        int x;
        if (type == 0 || type == 2) {
            l1.posRow = 2;
            x = 1;
        } else {
            l1.posRow = 1;
            x = 2;
        }
        //copy from L1 shape to board
        for (int i = 0; i < l1.height[type]; i++, x++) {
            for (int j = 0; j < l1.length[type]; j++) {
                board[i][j] = l1.shape[type][ x][j];
            }
        }
        
        currShape = l1;
    }

    public void addL2ToBoard() {
        Random r = new Random();
//        int type = r.nextInt(4);
        int type = 1;
        L2 l2 = new L2(this);
        l2.type = type;
        l2.posCol = 0;
        int x;
        if (type == 0 || type == 2) {
            l2.posRow = 2;
            x = 1;
        } else {
            l2.posRow = 1;
            x = 2;
        }
        //copy from L1 shape to board
        for (int i = 0; i < l2.height[type]; i++, x++) {
            for (int j = 0; j < l2.length[type]; j++) {
                board[i][j] = l2.shape[type][ x][j];
            }
        }
        
        currShape = l2;
    }
    public void addKotakToBoard() {
        //copy content of kotak to board at position 0
        int i = 0;
        for (int j = 0; j < kotak.shape[0].length; j++) {
            for (int k = 0; k < kotak.shape[0][j].length; k++) {
                if (j >= kotak.posJ) {
                    board[i][k] = kotak.shape[0][j][k];
                }
            }
            if (j >= kotak.posJ) {
                i++;
            }
        }
        kotak.posRow = kotak.size - 1;
        kotak.posCol = 0;
        //printBoard();

        currShape = kotak;
    }

    public void printBoard() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("\n\n");
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //draw board
        int boardX = 5;
        int boardY = 5;
        int widthBoard = TILE_S * (board[0].length);
        int heightBoard = TILE_S * (board.length);
        g2.setColor(Color.WHITE);
        g2.fill(new Rectangle2D.Double(boardX, boardY, widthBoard, heightBoard));

        drawShape(currShape, g2);

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3.0f));
        g2.draw(new Line2D.Double(boardX, boardY, boardX, boardY + heightBoard));
        g2.draw(new Line2D.Double(boardX + widthBoard, boardY, boardX + widthBoard, boardY + heightBoard));
        g2.draw(new Line2D.Double(boardX, boardY + heightBoard, boardX + widthBoard, boardY + heightBoard));

    }

    public void updateShape(Shape s, int move) {
        if (s instanceof Kotak) {
            Kotak k = (Kotak) s;
            k.moveKotak(move);
        } else if (s instanceof I) {
            I ishape = (I) s;
            ishape.moveI(move);
        } else if (s instanceof S1) {
            S1 s1 = (S1) s;
            s1.moveS1(move);
        } else if (s instanceof S2) {
            S2 s2 = (S2) s;
            s2.moveS2(move);
        } 
        else if (s instanceof L1) {
            L1 l1 = (L1) s;
            l1.moveL1(move);
        }else if( s instanceof L2){
            L2 l2 = (L2) s;
            l2.moveL2(move);
        }

        getTallestRow();
        boolean gameOver = checkGameOver();
        if (gameOver) {
            JOptionPane.showMessageDialog(null, "Game Over");
            System.exit(0);
        }

    }

    public void changeOccupied(Shape s) {
        if (s instanceof Kotak) {
            Kotak k = (Kotak) s;
            for (int i = k.posRow - kotak.size + 1; i < k.posRow + k.size - 1; i++) {
                for (int j = k.posCol; j < k.posCol + k.size; j++) {
                    if (board[i][j] == 1) {
                        board[i][j] = 2;
                    }
                }
            }
        } else if (s instanceof I) {
            I ishape = (I) s;
            if (ishape.type == 0) {
                for (int j = ishape.posCol; j < ishape.posCol + ishape.length; j++) {
                    if (board[ishape.posRow][j] == 1) {
                        board[ishape.posRow][j] = 2;
                    }
                }
            } else {
                for (int i = ishape.posRow; i > ishape.posRow - ishape.height; i--) {
                    if (board[i][ishape.posCol] == 1) {
                        board[i][ishape.posCol] = 2;
                    }
                }
            }
        } else if (s instanceof S1) {
            S1 s1 = (S1) s;
            for (int i = s1.posRow; i > s1.posRow - s1.height[s1.type]; i--) {
                for (int j = s1.posCol; j < s1.posCol + s1.length[s1.type]; j++) {
                    if (board[i][j] == 1) {
                        board[i][j] = 2;
                    }
                }
            }
        } else if (s instanceof S2) {
            S2 s2 = (S2) s;
            for (int i = s2.posRow; i > s2.posRow - s2.height[s2.type]; i--) {
                for (int j = s2.posCol; j < s2.posCol + s2.length[s2.type]; j++) {
                    if (board[i][j] == 1) {
                        board[i][j] = 2;
                    }
                }
            }
        } else if ( s instanceof L1){
            L1 l1 = (L1)s;
            for (int i = l1.posRow; i > l1.posRow - l1.height[l1.type]; i--) {
                for (int j = l1.posCol; j < l1.posCol + l1.length[l1.type]; j++) {
                    if (board[i][j] == 1) {
                        board[i][j] = 2;
                    }
                }
            }
        } else if ( s instanceof L2){
            L2 l2 = (L2)s;
            for (int i = l2.posRow; i > l2.posRow - l2.height[l2.type]; i--) {
                for (int j = l2.posCol; j < l2.posCol + l2.length[l2.type]; j++) {
                    if (board[i][j] == 1) {
                        board[i][j] = 2;
                    }
                }
            }
        }
    }

    public boolean checkGameOver() {
        boolean over = false;
        if (tallestRow == 0 && rowEmpty < 0 && !init) {
            System.out.println("Row empty = " + rowEmpty + "tallestRow = " + tallestRow);
            over = true;
        }
        return over;
    }

    public void drawShape(Shape s, Graphics2D g2) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > 0) {
                    if (board[i][j] == 1) {
                        g2.setColor(Color.GREEN);
                    } else {
                        g2.setColor(Color.RED);
                    }
                    int y = i * TILE_S + 5;
                    int x = j * TILE_S + 5;

                    g2.fill(new Rectangle2D.Double(x, y, TILE_S, TILE_S));
                    g2.setColor(Color.BLACK);
                    g2.draw(new Rectangle2D.Double(x, y, TILE_S, TILE_S));

                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    public void cycle(Shape currShape) {
        if (currShape instanceof I) {
            I ishape = (I) currShape;
            ishape.cycle();
        } else if (currShape instanceof S1) {
            S1 s1 = (S1) currShape;
            s1.cycle();
        } else if (currShape instanceof S2) {
            S2 s2 = (S2) currShape;
            s2.cycle();
        } 
        else if (currShape instanceof L1) {
            L1 l1 = (L1) currShape;
            l1.cycle();
        }else if( currShape instanceof L2){
            L2 l2 = (L2) currShape;
            l2.cycle();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (KeyEvent.VK_LEFT == e.getKeyCode()) {
            //System.out.println("Left is pressed");
            updateShape(currShape, MOVE.LEFT.ordinal());
        }
        if (KeyEvent.VK_RIGHT == e.getKeyCode()) {
            //System.out.println("Right is pressed");
            updateShape(currShape, MOVE.RIGHT.ordinal());
        }
        if (KeyEvent.VK_DOWN == e.getKeyCode()) {
            updateShape(currShape, MOVE.DOWN.ordinal());
        }
        if (KeyEvent.VK_SPACE == e.getKeyCode()) {
            cycle(currShape);
        }
    }

    public void destroyRowFull() {
        boolean[] rowDestroyed = new boolean[ROW];
        int rowDestCtr = 0;
        if (tallestRow >= 0) {
            for (int i = tallestRow; i < board.length; i++) {
                int rCtr = 0;
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 2) {
                        rCtr++;
                    }
                }
                //this row is destroyed
                if (rCtr == board[0].length) {
                    //mark rows destroyed
                    rowDestroyed[i] = true;
                    rowDestCtr++;
                }
            }

            for (int i = tallestRow; i < board.length; i++) {
                if (rowDestroyed[i]) {
                    for (int j = 0; j < board[0].length; j++) {
                        board[i][j] = 0;
                    }
                    for (int k = i; k > tallestRow; k--) {
                        for (int j = 0; j < board[0].length; j++) {
                            board[k][j] = board[k - 1][j];
                        }

                    }
                    for (int j = 0; j < board[0].length; j++) {
                        board[tallestRow][j] = 0;
                    }
                    tallestRow++; //tallestRow turun

                }
            }
            getTallestRow();
        }

    }

    public void addItemToBoard() {
        //choose randomly later
        Random r = new Random();
        int shape = r.nextInt(3);
//        int shape = 5;
        if (shape == 0) {
            addKotakToBoard();
        } else if (shape == 1) {
            addIToBoard();
        } else if (shape == 2) {
            addS1ToBoard();
        } else if (shape == 3) {
            addS2ToBoard();
        } else if (shape == 4) {
            addL1ToBoard();
        }else if ( shape == 5){
            addL2ToBoard();
        }
        init = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (currShape != null) {

            updateShape(currShape, MOVE.DOWN.ordinal());
            destroyRowFull();
            init = false;
        }
        repaint();
    }

}
