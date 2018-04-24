/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

import java.awt.Color;

/**
 *
 * @author charisma
 */
public class Kotak implements Shape {

    int[][][] shape
            = {
                {
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {1, 1, 0, 0},
                    {1, 1, 0, 0}
                }
            };
    int posRow = 0;
    int posCol = 0;
    public int posJ = 2;
    public int size = 0;
    TetrisPanel gamePanel;

    public Kotak(TetrisPanel pnl) {
        size = 2;
        gamePanel = pnl;
    }

    public boolean checkCollisionDown() {
        Kotak kotak = this;
        int[][] board = gamePanel.board;
        if (kotak.posRow < board.length) {
            boolean flagDownExist = false;
            for (int j = kotak.posCol; j < kotak.posCol + kotak.size; j++) {
                if (board[kotak.posRow][j] == 2) {
                    flagDownExist = true;
                    break;
                }
            }
            if (flagDownExist) {
                kotak.posRow--;
                gamePanel.changeOccupied(kotak);
                return true;
            }

        } else if (kotak.posRow > board.length - 1) {
            kotak.posRow = board.length - 1;
            gamePanel.changeOccupied(kotak);
            return true;
        }

        return false;
    }

    public synchronized void moveKotak(int move) {
        Kotak kotak = this;
        int[][] board = gamePanel.board;
        //System.out.println("Enter update shape kotak");
        if (move == 0) {
            kotak.posRow++;
            boolean collideDown = checkCollisionDown();
            if (collideDown) {
                if (gamePanel.rowEmpty >= 0) {
                    gamePanel.addItemToBoard();
                }
                return;
            }

            for (int i = kotak.posRow; i > kotak.posRow - kotak.size; i--) {
                for (int j = kotak.posCol; j < kotak.posCol + kotak.size; j++) {
                    if (board[i - 1][j] != 2) {
                        board[i][j] = board[i - 1][j];
                    }
                }
            }
            for (int j = kotak.posCol; j < kotak.posCol + kotak.size; j++) {
                if (board[kotak.posRow - kotak.size][j] == 1) {
                    board[kotak.posRow - kotak.size][j] = 0;
                }
            }
        } else if (move == 2) {
            kotak.posCol++;
            if (kotak.posCol + kotak.size >= board[0].length) {
                kotak.posCol = board[0].length - kotak.size;
                
            } else if (kotak.posCol+kotak.size <= board[0].length - 1) {
                boolean flagRight = false;
                for(int i = kotak.posRow-kotak.size+1; i < kotak.posRow+1;i++)
                    if (board[i][kotak.posCol + kotak.size] == 2) {
                        flagRight = true;
                        break;
                    }
                if( flagRight){
                    kotak.posCol--;
                    return;
                }
            }
            for (int i = kotak.posRow - kotak.size + 1; i < kotak.posRow + 1; i++) {
                for (int j = kotak.posCol + kotak.size - 1; j > kotak.posCol; j--) {
//                    System.out.println("Kotak.java : i = "+i+"j = "+j);
                    if (board[i][j - 1] != 2) {
                        board[i][j] = board[i][j - 1];
                    }
                }
                if (board[i][kotak.posCol - 1] != 2) {
                    board[i][kotak.posCol - 1] = 0;
                }
            }

        } else if (move == 1) {
            kotak.posCol--;
            //boolean collideDown = checkCollisionDown(k);
            if (kotak.posCol < 0) {
                kotak.posCol = 0;
                return;
            } else{
                boolean flagLeft  = false;
                for(int i = kotak.posRow-kotak.size+1; i < kotak.posRow+1;i++)
                    if( board[i][kotak.posCol] == 2){
                         flagLeft = true;
                         break;
                    }
                if(flagLeft){
                    kotak.posCol++;
                    return;
                }
            }
            for (int i = kotak.posRow - kotak.size + 1; i < kotak.posRow + 1; i++) {
                for (int j = kotak.posCol; j < kotak.posCol + kotak.size; j++) {
                    if (board[i][j + 1] != 2) {
                        board[i][j] = board[i][j + 1];
                    }
                }
                if (board[i][kotak.posCol + kotak.size] != 2) {
                    board[i][kotak.posCol + kotak.size] = 0;
                }
            }
        }
    }
}
