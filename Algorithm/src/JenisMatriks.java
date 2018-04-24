/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CHAR0
 */
public class JenisMatriks {
    private int[][] matriks1 = {
        {1,1,1},
        {0,1,2},
        {0,0,3}
    };
    public boolean checkSegitigaAtas(){
        for(int i = 1; i < matriks1.length;i++){
            for(int j = 0; j < i; j++){
                if( matriks1[i][j] != 0)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[]args){
        JenisMatriks jm = new JenisMatriks();
        System.out.println(jm.checkSegitigaAtas());
    }
}
