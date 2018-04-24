/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day06;

/**
 *
 * @author CHAR0
 */
public class Array2D {
    
    public static int[][] addMat(int[][] a, int[][] b){
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }
    public static int[][] subMat(int[][] a, int[][] b){
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }
    
    public static int[][] multMat(int[][] a, int [][] b){
        int [][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for(int j = 0; j < b[0].length;j++){
                int res = 0;
                for(int k = 0; k < a[0].length; k++){
                    res += a[i][k] * b[k][j];
                }
                result[i][j] = res;
            }
            
        }
        return result;
    }
    public static void printMat(int[][]mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j]+ " ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        int [][] mat = { {1,2}, {2,2}};
        printMat(mat);
        int [][] A = {{1,1}, {2,1}};
        int [][] B = {{1,2}, {2,2}};
        int [][] C = addMat(A, B);
        printMat(C);
        int[][] result = new int[A.length][A[0].length];
        int[][] D = multMat(A, B);
        printMat(D);
    }
}
