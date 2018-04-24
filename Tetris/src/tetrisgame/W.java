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
public class W {
    
    int[][][] shape
            = {
                {
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 1, 0, 0},
                    {1, 1, 1, 0}
                },
                {
                    {0, 0, 0, 0},
                    {1, 0, 0, 0},
                    {1, 1, 0, 0},
                    {1, 0, 0, 0}
                },
                {
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {1, 1, 1, 0},
                    {0, 1, 0, 0}
                },
                {
                    {0, 0, 0, 0},
                    {0, 1, 0, 0},
                    {1, 1, 0, 0},
                    {0, 1, 0, 0}
                }
            };

    
    public int length[];
    public int height[];
    public int posRow;
    public int posCol;
    protected TetrisPanel gamePanel;
    protected int type;
    
    public void cycle(){
        
    }
    public boolean checkCollisionDown(){
        return false;
    }
    
    public void move(int move){
        if( move == 0){ //down
            
        }else if ( move == 1){ //left
            
        }else if ( move == 2){ //right
            
        }
    }
}
