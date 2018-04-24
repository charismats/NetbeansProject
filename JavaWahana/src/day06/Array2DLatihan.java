package day06;

import java.util.Random;

public class Array2DLatihan {

    public static void showMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] mat1 = new int[4][5];
        Random rnd =new Random();
        for(int i = 0; i < mat1.length;i++){
            for(int j = 0; j < mat1[i].length;j++){
                mat1[i][j] = rnd.nextInt(10) + 1;
            }
        }
        showMatrix(mat1);
        int[][] transpose = transposeMatrix(mat1);
        showMatrix(transpose);
        
//        int[][] matrix = new int[5][5];
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                matrix[i][j] = i * matrix.length + j;
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        int[][] matrix2 = new int[5][5];
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                matrix[i][j] = i + j * matrix.length;
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//
        int[][] m1 = {
            {1, 2, 10, 4},
            {3, 1, 3, 5},
            {2, 3, 4, 3}
        };
//
//        System.out.println("Matrix m1 : ");
//        showMatrix(m1);
//        int[][] m1transpose = new int[m1[0].length][m1.length];
//        for (int i = 0; i < m1transpose.length; i++) {
//            for (int j = 0; j < m1transpose[i].length; j++) {
//                m1transpose[i][j] = m1[j][i];
//            }
//        }
//        System.out.println("Matrix m1transpose: ");
//        showMatrix(m1transpose);
//
        int[][] m2 = {
            {3, 2, 0, 4},
            {4, 1, -2, 5},
            {3, 1, -4, 3}
        };
        int[][] m3 = sumMatrix(m1, m2);
        showMatrix(m1);
        showMatrix(m2);
        showMatrix(m3);
        
        
        int [][]m4 = { 
            {1,1,2,1},
            {1,1,2,0},
            {1,3,4,1} };
        int [][]m5= {
            {1,5},
            {2,6},
            {3,7},
            {4,8}
            };
        int[][] m6 = productMatrix(m4, m5);
        showMatrix(m6);
    }
    
    public static int[][] transposeMatrix(int[][] m1){
        int[][] m2 = new int[m1[0].length][m1.length];
        for(int i = 0; i < m2.length;i++){
            for(int j =0; j < m2[0].length; j++)
                m2[i][j] = m1[j][i];
        }
        return m2;
    }
    
    public static int[][] sumMatrix(int[][] m1, int[][]m2){
        if( m1.length != m2.length && m1[0].length != m2[0].length){
            System.out.println("Matrices invalid for summation");
            System.exit(0);
        }
        int[][] m3 = new int[m1.length][m1[0].length];
        for (int i = 0; i < m3.length; i++) {
            for (int j = 0; j < m3[0].length; j++) {
                m3[i][j] = m1[i][j] + m2[i][j];   
            }
        }
        return m3;
    }
    public static int[][] subtractMatrix(int[][] m1, int[][]m2){
        if( m1.length != m2.length && m1[0].length != m2[0].length){
            System.out.println("Matrices invalid for subtraction");
            System.exit(0);
        }
        int[][] m3 = new int[m1.length][m1[0].length];
        for (int i = 0; i < m3.length; i++) {
            for (int j = 0; j < m3[0].length; j++) {
                m3[i][j] = m1[i][j] - m2[i][j];   
            }
        }
        return m3;
    }
    
    public static int[][] productMatrix(int[][] m1, int[][]m2){
        if( m1[0].length != m2.length){
            System.out.println("Matrices invalid for multiplication");
            System.exit(0);
        }
        
        int[][] m3 = new int[m1.length][m2[0].length];
        for(int i = 0; i < m1.length; i++){
            for(int j = 0; j < m2[0].length;j++){
                int sum = 0;
                for(int k = 0; k < m2.length;k++ ){
                    sum += m1[i][k] * m2[k][j];
                }
                m3[i][j] = sum;
            }
        }
        return m3;
    }
}
