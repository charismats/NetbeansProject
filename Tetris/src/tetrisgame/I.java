/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

/**
 *
 * @author charisma
 */
public class I implements Shape {

    int[][][] shape
            = {
                {
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {1, 1, 1, 1}
                },
                {
                    {1, 0, 0, 0},
                    {1, 0, 0, 0},
                    {1, 0, 0, 0},
                    {1, 0, 0, 0}
                }
            };
    int length = 4;
    int height = 4;
    public TetrisPanel gamePanel;

    public I(TetrisPanel pnl) {
        gamePanel = pnl;
    }
    int type; //0 for horizontal, 1 for vertical
    int posRow = 0;
    int posCol = 0;

    public synchronized void cycle() {
        int before = type;
        type++;
        type %= 2;
        //clear out board first
        int[][] board = gamePanel.board;
        int i = posRow - height + 1;
        if (i < 0) {
            i = 0;
        }
        int limitJ = posCol + length;
        if( limitJ > board[0].length-1){
            posCol = board[0].length - 1-length;
        }
        posRow = i + height-1;
        for (int x = 0; i <= posRow; i++,x++) {
            for (int j = posCol, y = 0; j < posCol + length; j++, y++) {
                board[i][j] = shape[type][x][y];
            }
        }
        //gamePanel.printBoard();
    }

    public boolean checkCollisionDown() {
        int[][] board = gamePanel.board;
        if (posRow > board.length - 1) {
            posRow--;

            gamePanel.changeOccupied(this);
            return true;
        } else if (posRow <= board.length - 1) {
            boolean flagDownExist = false;
            if (type == 0) { //horizontal I
                for (int j = posCol; j < posCol + length; j++) {
                    if (board[posRow][j] == 2) {
                        flagDownExist = true;
                        break;
                    }
                }
            } else {
                if (board[posRow][posCol] == 2) {
                    flagDownExist = true;
                }
            }
            if (flagDownExist) {
                posRow--;
                gamePanel.changeOccupied(this);
                return true;
            }
        }
        return false;
    }

    public synchronized void moveI(int move) {
        int[][] board = gamePanel.board;
        if (move == 0) { //down
            posRow++;
            boolean collideDown = checkCollisionDown();
            if (collideDown) {
                if (gamePanel.rowEmpty >= 0) {
                    gamePanel.addItemToBoard();
                }
                return;
            }
            if (type == 0) { //horizontal I
                for (int j = posCol; j < posCol + length; j++) {
                    if (board[posRow - 1][j] == 1) {
                        board[posRow][j] = board[posRow - 1][j];
                    }
                    if (board[posRow - 1][j] != 2) {
                        board[posRow - 1][j] = 0;
                    }
                }

            } else { //vertical I
                for (int i = posRow; i > posRow - height; i--) {
                    //if (board[i - 1][posCol] == 1) {
                        board[i][posCol] = board[i - 1][posCol];
                    //}

                }
                if (board[posRow - height][posCol] == 1) {
                    board[posRow - height][posCol] = 0;
                }
            }

        } else if (move == 1) { //left
            posCol--;
            if (posCol < 0) {
                posCol = 0;
                return;
            }
            
            if (type == 0) { //horizontal I
                if (posCol >= 0 && board[posRow][posCol] == 2) {
                    posCol++;
                    return;
                }
                //copy mendatar saja
                for (int j = posCol; j < posCol + length; j++) {
                    if (board[posRow][j + 1] != 2) {
                        board[posRow][j] = board[posRow][j + 1];
                    }

                }
                if (board[posRow][posCol + length] == 1) {
                    board[posRow][posCol + length] = 0;
                }
            } else { //vertical I
                boolean flagLeft = false;
                for(int i = posRow - height + 1; i <= posRow; i++){
                    if( board[i][posCol] == 2)
                    {
                        flagLeft = true;
                        break;
                    }
                }
                if( flagLeft){
                    posCol++;
                    return;
                }
                //copy vertical saja
                for (int i = posRow; i > posRow - height; i--) {
                    if (board[i][posCol + 1] != 2) {
                        board[i][posCol] = board[i][posCol + 1];
                        board[i][posCol + 1] = 0;
                    }
                }

            }
        } else if (move == 2) { //right
            posCol++;
            if (type == 0) {
                if (posCol + length >= board[0].length) {
                    posCol = board[0].length - length;

                } else if (posCol + length <= board[0].length - 1 && board[posRow][posCol + length-1] == 2) {
                    posCol--;
                    return;
                }
                //copy mendatar saja
                for (int j = posCol + length - 1; j > posCol; j--) {
                    if (board[posRow][j - 1] != 2) {
                        board[posRow][j] = board[posRow][j - 1];
                    }

                }
                if (board[posRow][posCol - 1] == 1) {
                    board[posRow][posCol - 1] = 0;
                }
            } else {
                if (posCol >= board[0].length) {
                    posCol = board[0].length -1;
                    return;

                } else if (posCol <= board[0].length - 1 && board[posRow][posCol] == 2) {
                    posCol--;
                    return;
                }
                //copy vertical saja
                for (int i = posRow; i > posRow - height; i--) {
                    if (board[i][posCol - 1] != 2) {
                        board[i][posCol] = board[i][posCol - 1];
                        board[i][posCol - 1] = 0;
                    }
                }
            }
        }
    }
}

