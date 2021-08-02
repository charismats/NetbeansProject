/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soal8;

/**
 *
 * @author CHAR0
 */
public class PenjumlahanSubMatriks {
    public static void main(String[] args) {
        int[][] matrix = {
            {5,5,6,4,1},
            {6,5,6,1,2},
            {3,3,3,2,3},
            {1,5,2,3,1},
            {4,3,3,1,4}
        };
        int[][]sub = {
            {2,3,4,5},
            {1,1,2,2},
            {2,1,2,5}
        };
        
        for(int i = 0 ; i < sub.length;i++){
            int jumlah = 0;
            for(int row = sub[i][0]-1; row < sub[i][2]; row++ ){
                for(int col = sub[i][1]-1; col < sub[i][3]; col++ ){
                    jumlah += matrix[row][col];
                }
            }
            System.out.println(jumlah);
        }
    }
}
