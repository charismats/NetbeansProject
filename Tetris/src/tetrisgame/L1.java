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
public class L1 implements Shape {

    int[][][] shape
            = {
                {
                    {0, 0, 0, 0},
                    {1, 0, 0, 0},
                    {1, 0, 0, 0},
                    {1, 1, 0, 0}
                },
                {
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {1, 1, 1, 0},
                    {1, 0, 0, 0}
                },
                {
                    {0, 0, 0, 0},
                    {1, 1, 0, 0},
                    {0, 1, 0, 0},
                    {0, 1, 0, 0}
                },
                {
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 1, 0},
                    {1, 1, 1, 0}
                }
            };

    protected int length[] = {2, 3, 2, 3};
    protected int height[] = {3, 2, 3, 2};
    protected int posRow;
    protected int posCol;
    protected TetrisPanel gamePanel;
    protected int type;

    public L1(TetrisPanel pnl) {
        gamePanel = pnl;
    }

    public void cycle() {
        int i = 0;
        int[][] board = gamePanel.board;
        //clear out first
        i = posRow - height[type] + 1;
        if (i < 0) {
            i = 0;
        }
        for (; i <= posRow; i++) {
            for (int j = posCol; j < posCol + length[type]; j++) {
                board[i][j] = 0;
            }
        }
        //cycle type
        type++;
        type %= 4;

        int x = 0;
        int limitRow = 0;
        if (type == 1 || type == 3) {
            x = 2;
            posRow--;

        } else {
            x = 1;
            posRow++;
        }
        limitRow = posRow;
        i = posRow - height[type] + 1;
        if (i < 0) {
            i = 0;
        }

        int limitJ = posCol + length[type];
        if (limitJ > board[0].length - 1) {
            posCol = board[0].length - 1 - length[type];
        }

        //copy new shape
        for (; i <= limitRow; i++, x++) {
            for (int j = posCol, y = 0; j < posCol + length[type]; j++, y++) {
                board[i][j] = shape[type][x][y];
            }
        }
    }

    public boolean checkCollisionDown() {
        int[][] board = gamePanel.board;
        if (type == 0) {
            boolean nabrak = false;
            for (int j = posCol; j < posCol + length[type]; j++) {
                //check nabrak tembok bawah
                if (posRow > board.length - 1) {
                    nabrak = true;
                    break;
                } //check nabrak balok lain
                else if (j <= board[0].length - 1 && board[posRow][j] == 2) {
                    nabrak = true;
                    break;
                }
            }
            if (nabrak) {
                posRow--;
                return true;
            }

        } else if (type == 1) {
            boolean nabrak = false;
            //check nabrak tembok
            if (posRow > board.length - 1) {
                nabrak = true;
            }else{
                if( board[posRow][posCol] == 2){
                    nabrak = true;
                }else{
                    for(int j = posCol + 1; j < posCol + length[type]; j++){
                        if( board[posRow-1][j] == 2){
                            nabrak = true;
                            break;
                        }
                    }
                }
            }

            if (nabrak) {
                posRow--;
                return true;
            }
        } else if (type == 2) {
            boolean nabrak = false;
            if (board[posRow - height[type] + 1][posCol] == 2) {
                nabrak = true;
            }
            if (posRow > board.length - 1) {
                nabrak = true;
            } else if (board[posRow][posCol + 1] == 2) {
                nabrak = true;
            }

            if (nabrak) {
                posRow--;
                return true;
            }

        } else if (type == 3) {
            boolean nabrak = false;
            //check nabrak tembok
            if (posRow > board.length - 1) {
                nabrak = true;

            } else {
                for (int j = posCol; j < posCol + length[type]; j++) {
                    if (board[posRow][j] == 2) {
                        nabrak = true;
                        break;
                    }
                }
            }
            if (nabrak) {
                posRow--;
                return true;
            }
            //check nabrak balok lain
            for (int j = posCol; j < posCol + length[type]; j++) {
                if (board[posRow][posCol] == 2) {
                    nabrak = true;
                    break;
                }
            }
            if (nabrak) {
                posRow--;
                return true;
            }
        }

        return false;
    }

    public synchronized void moveL1(int move) {
        int[][] board = gamePanel.board;
        if (move == 0) { //down
            posRow++;
            boolean collideDown = checkCollisionDown();
            if (collideDown) {
                if (gamePanel.rowEmpty >= 0) {
                    //System.out.println("nabrak");
                    gamePanel.changeOccupied(this);
                    gamePanel.addItemToBoard();
                }
                return;
            }

            //bring down / copy down shape
            for (int i = posRow; i >= posRow - height[type] + 1; i--) {
                for (int j = posCol; j < posCol + length[type]; j++) {
                    if (board[i][j] != 2) {
                        board[i][j] = board[i - 1][j];
                    }
                }
            }
            //erase
            for (int j = posCol; j < posCol + length[type]; j++) {
                board[posRow - height[type]][j] = 0;
            }
        } else if (move == 1) { //left
            posCol--;
            boolean nabrak = false;
            if (type == 0 || type == 1) {
                for (int i = posRow - height[type] + 1; i <= posRow; i++) {
                    if (posCol < 0) { //nabrak tempbok
                        nabrak = true;
                        break;
                    } else {
                        if (board[i][posCol] == 2) { //nabrak balok lain
                            nabrak = true;
                            break;
                        }
                    }
                }
            } else if (type == 2) {
                if (posCol < 0) {
                    nabrak = true;
                }
                for (int i = posRow - 1; i <= posRow; i++) {
                    if (board[i][posCol + 1] == 2) {
                        nabrak = true;
                        break;
                    }
                }
            } else if (type == 3) {
                if (posCol < 0) {
                    nabrak = true;
                } else if (board[posRow][posCol] == 2) {
                    nabrak = true;
                }
            }

            if (nabrak) {
                posCol++;
                return;
            }

            //copy to left side
            for (int i = posRow - height[type] + 1; i <= posRow; i++) {
                for (int j = posCol; j < posCol + length[type]; j++) {
                    if (board[i][j] != 2 && board[i][j + 1] != 2) {
                        board[i][j] = board[i][j + 1];
                    }
                }
            }
            //erase right
            for (int i = posRow - height[type] + 1; i <= posRow; i++) {
                if (board[i][posCol + length[type]] != 2) {
                    board[i][posCol + length[type]] = 0;
                }
            }

        } else if (move == 2) { //right
            posCol++;
            boolean nabrak = false;
            boolean tembok = false;
            if (type == 0) {
                int pojokKanan = posCol + length[type] - 1;
                if (pojokKanan > board[0].length - 1) {
                    nabrak = true;
                    tembok = true;
                } //check nabrak balok lain
                else {
                    if (posCol + 1 <= board[0].length - 1 && board[posRow][posCol + 1] == 2) {
                        nabrak = true;
                    }
                    for (int i = posRow - height[type] + 1; i < posRow; i++) {
                        if (board[i][posCol] == 2) {
                            nabrak = true;
                            break;
                        }
                    }
                }

            } else if (type == 1) {
                int pojokKanan = posCol + length[type] - 1;
                if (pojokKanan > board[0].length - 1) {
                    nabrak = true;
                    tembok = true;
                } else if (board[posRow - 1][pojokKanan] == 2) {
                    nabrak = true;
                }
                if (board[posRow][posCol] == 2) {
                    nabrak = true;
                }
            } else if (type == 2) {
                int pojokKanan = posCol + 1;
                if (pojokKanan > board[0].length - 1) {
                    nabrak = true;
                    tembok = true;
                } else {
                    for (int i = posRow - height[type] + 1; i <= posRow; i++) {
                        if (board[i][pojokKanan] == 2) {
                            nabrak = true;
                            break;
                        }
                    }
                }
            } else if (type == 3) {
                int pojokKanan = posCol + length[type] - 1;

                if (pojokKanan > board[0].length - 1) {
                    nabrak = true;
                    tembok = true;
                } else if (board[posRow - 1][pojokKanan] == 2 || board[posRow][pojokKanan] == 2) {
                    nabrak = true;
                }
            }

            if (nabrak) {
                posCol--;
                if (tembok) {
                    posCol = board[0].length - length[type];
                }
                return;
            }
            int pojokKanan = posCol + length[type] - 1;
            //copy to right side
            for (int i = posRow - height[type] + 1; i <= posRow; i++) {
                for (int j = pojokKanan; j >= posCol; j--) {
                    if (board[i][j] != 2 && board[i][j - 1] != 2) {
                        board[i][j] = board[i][j - 1];
                    }
                }
                //erase left
                board[i][posCol - 1] = 0;
            }
        }
    }
}
