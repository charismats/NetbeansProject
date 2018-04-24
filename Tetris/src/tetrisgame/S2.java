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
public class S2 implements Shape {

    int[][][] shape
            = {
                {
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {1, 1, 0, 0},
                    {0, 1, 1, 0}
                },
                {
                    {0, 0, 0, 0},
                    {0, 1, 0, 0},
                    {1, 1, 0, 0},
                    {1, 0, 0, 0}
                }
            };

    public int[] length = {3, 2};
    public int[] height = {2, 3};
    public TetrisPanel gamePanel;
    public int posRow;
    public int posCol;
    public int type;

    public S2(TetrisPanel pnl) {
        gamePanel = pnl;
    }

    public void cycle() {
        int i = 0;
        int[][] board = gamePanel.board;
        //clear out first
        i = posRow - height[type]+1;
        if( i < 0)
            i = 0;
        for(int x = 1; i <= posRow; i++){
            for(int j = posCol; j < posCol + length[type];j++){
                board[i][j] = 0;
            }
        }
        //cycle type
        type++;
        type %= 2;
        
        int x = 0;
        int limitRow = 0;
        if( type == 0){
            x = 2;
            posRow--;
            limitRow = posRow;
        }else{
            x = 1;
            posRow++;
            limitRow = posRow;
        }
        
        i = posRow - height[type]+1;
        if( i < 0)
            i = 0;
        
        int limitJ = posCol + length[type];
        if( limitJ > board[0].length-1){
            posCol = board[0].length - 1-length[type];
        }
        
        //copy new shape
        for(; i <= limitRow ; i++, x++){
            for(int j = posCol, y = 0; j < posCol + length[type];j++, y++){
                board[i][j] = shape[type][x][y];
            }
        }
    }

    public boolean checkCollisionDown() {
        int[][] board = gamePanel.board;
        if (posRow > board.length - 1) {
            posRow--;
            gamePanel.changeOccupied(this);
            return true;
        } else if (posRow <= board.length - 1) {
            boolean flagDownExist = false;
            if (type == 0) { //tidur S1
                for (int j = posCol; j < posCol + length[type]; j++) {
                    if ( j >= posCol + length[type]/2 && board[posRow][j] == 2) {
                        flagDownExist = true;
                        break;
                    }else if( board[posRow-1][j] == 2){
                        flagDownExist = true;
                    }
                }
            } else { //tegak S1
                if (board[posRow][posCol] == 2) {
                    flagDownExist = true;
                }
                if(board[posRow-1][posCol+1] == 2)
                    flagDownExist = true;
            }
            if (flagDownExist) {
                posRow--;
                gamePanel.changeOccupied(this);
                return true;
            }
        }
        return false;
    }

    public void moveS2(int move) {
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
            for (int i = posRow; i > posRow - height[type]; i--) {
                for (int j = posCol; j < posCol + length[type]; j++) {
                    if (board[i][j] != 2 && board[i - 1][j] != 2) {
                        board[i][j] = board[i - 1][j];
                    }
                }
            }
            //erase
            for (int j = posCol; j < posCol + length[type]; j++) {
                if (posRow >= 1 && board[posRow - height[type]][j] == 1) {
                    board[posRow - height[type]][j] = 0;
                } else if (posRow == 0) {
                    board[0][j] = 0;
                }
            }
        } else if (move == 1) { //left
            posCol--;
            if (posCol < 0) {
                posCol = 0;
                return;
            }
            boolean flagLeft = false;
            if (type == 0) {
                if (posCol >= 0) {
                    if (board[posRow-1][posCol] == 2) {
                        flagLeft = true;
                    }
                    if (board[posRow ][posCol + length[type]/2] == 2) {
                        flagLeft = true;
                    }
                }

            } else {
                if ( posCol-1 >= 0 && board[posRow - height[type] + 1][posCol-1] == 2) {
                    flagLeft = true;
                }
                if (board[posRow - 1][posCol] == 2) {
                    flagLeft = true;
                }
                if (board[posRow][posCol] == 2) {
                    flagLeft = true;
                }
            }
            if (flagLeft) {
                posCol++;
                return;
            }
            //copy left
            for (int i = posRow; i > posRow - height[type]; i--) {
                for (int j = posCol; j < posCol + length[type]; j++) {
                    if (board[i][j] != 2 && board[i][j + 1] != 2) {
                        board[i][j] = board[i][j + 1];
                    }
                }

                //erase
                if (board[i][posCol + length[type]] != 2) {
                    board[i][posCol + length[type]] = 0;
                }
            }

        } else if (move == 2) { //right
            posCol++;
            if (posCol + length[type] > board[0].length) {
                posCol = board[0].length - length[type];
                return;
            }
            boolean flagRight = false;
            if (type == 0) {
                if (board[posRow][posCol + length[type]-1] == 2) {
                    flagRight = true;
                }
                if (board[posRow - 1][posCol + length[type]/2] == 2) {
                    flagRight = true;
                }
            } else {
                if (board[posRow - height[type] + 1][posCol] == 2) {
                    flagRight = true;
                }
                if (board[posRow - 1][posCol] == 2) {
                    flagRight = true;
                }
                if (board[posRow][posCol+length[type]/2] == 2) {
                    flagRight = true;
                }
            }

            if (flagRight) {
                //System.out.println("Possibly here");
                posCol--;
                return;
            }

            
            //copy right
            for (int i = posRow; i > posRow - height[type]; i--) {
                if (posCol + length[type] <= board[0].length) {
                    for (int j = posCol + length[type] - 1; j >= posCol; j--) {
                        if (board[i][j] != 2 && board[i][j - 1] != 2) {
                            board[i][j] = board[i][j - 1];
                        }
                    }
                    //erase
                    if (board[i][posCol - 1] != 2) {
                        board[i][posCol - 1] = 0;
                    }
                }
            }

        }
    }
}

