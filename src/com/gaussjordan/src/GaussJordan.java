/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gaussjordan.src;

import java.util.ArrayList;

/**
 *
 * @author Charisma
 */
public class GaussJordan {

//    static double[][] mat = {
//        {1, 1, -1, 7},
//        {1, -1, 2, 3},
//        {2, 1, 1, 9}
//    };
//    static double[][] mat = {
//        {1, 2, -1, 4},
//        {2, 1, 1, -2},
//        {1, 2, 1, 2}
//    };
//    static double[][] mat = {
//        {2, 1, 2, 10},
//        {1, 2, 1, 8},
//        {3, 1, -1, 2}
//    };
//    static double[][] mat = {
//        {1, 3, 7},
//        {3, 4,11},
//    };
//     static double[][] mat = {
//        {2, 5,21},
//        {1, 2,8},
//    };
//    static double[][] mat = {
//        {1, 3, -2, -5, -19},
//        {2, 1, 1, -1, 3},
//        {-1, -1, 4, 3, 21},
//        {1, 1, 1, 1, 10},};
    
//    static double[][] mat = {
//        {1, 0, 1, 2, 6},
//        {0, 1, -2, 0, -3},
//        {1, 2, -1, 0, -2},
//        {2, 1, 3, -2, 0},};
//    
//     static double[][] mat = {
//        {1, 2, -1, 1, 6},
//        {-1, 1, 2, -1, 3},
//        {2, -1, 2, 2, 14},
//        {1, 1, -1, 2, 8},};

    static double[][] mat = {
        {2, 1, 1, 1, 1,4},
        {1, 2, 1, 1, 1,5},
        {1, 1, 2, 1, 1,6},
        {1, 1, 1, 2, 1,7},
        {1, 1, 1, 1, 2,8}
    };
    
    static ArrayList<Integer> rowPivot = new ArrayList<>();
    static ArrayList<Integer> colPivot = new ArrayList<>();

    static void fillPivot() {
        for (int j = 0; j < mat[0].length - 1; j++) {
            for (int i = mat.length - 1; i > j; i--) {
                if (i != j) {
                    rowPivot.add(i);
                    colPivot.add(j);
                }

            }
        }
        
        for (int j = 0; j < mat[0].length - 1; j++) {
             for (int i = j; i >= 0; i--) {
                if (i != j) {
                    rowPivot.add(i);
                    colPivot.add(j);
                }
            }
        }
        for (int i = 0; i < rowPivot.size(); i++) {
            System.out.println("RowPivot : " + rowPivot.get(i) + " colPivot = " + colPivot.get(i));
        }
    }

    static boolean isFinished() {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length - 1; j++) {
                if (mat[i][i] != 1) {
                    return false;
                }
                if (i != j && mat[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static void doAlgorithm() {
        fillPivot();
        int indexPivot = 0;
        int row = -1;
        int col = -1;
        printMatrix();
        boolean evenPivot = false;
        if (rowPivot.size() / 2 % 2 == 0) {
            evenPivot = true;
        }
        int limit = rowPivot.size() / 2;
        row = rowPivot.get(indexPivot);
        col = colPivot.get(indexPivot);
        while (row > col) {
            System.out.println("Pivot bawah");

            int searchOne = -1;
            double multiplier = 1;
            boolean flag = false;
            System.out.println("rowPivot = " + row + " colPivot = " + col);
            if (mat[row][col] != 0) {

                //try to make (row,col) 0
                searchOne = searchRow(row, col);

                if (mat[row][col] > mat[searchOne][col]) {
                    multiplier = mat[row][col] / mat[searchOne][col];
                    flag = true;
                } else {
                    multiplier = mat[searchOne][col] / mat[row][col];
                    flag = false;
                }
                System.out.println("Multiplier : " + multiplier);
                System.out.println("SearchOne = " + searchOne);
                for (int j = 0; j < mat[row].length; j++) {
                    if (multiplier > 0) {
                        if (flag) {
                            mat[row][j] = mat[row][j] - multiplier * mat[searchOne][j];
                        } else {
                            mat[row][j] = mat[row][j] - mat[searchOne][j] / multiplier;
                        }
                    } else {
                        if (flag) {
                            mat[row][j] = mat[row][j] + (-1) * multiplier * mat[searchOne][j];
                        } else {
                            mat[row][j] = mat[row][j] + mat[searchOne][j] / ((-1) * multiplier);
                        }
                    }
                }
            }
            printMatrix();
            indexPivot++;
            row = rowPivot.get(indexPivot);
            col = colPivot.get(indexPivot);
        }

        while (indexPivot < rowPivot.size()) {
            System.out.println("Pivot atas");
            row = rowPivot.get(indexPivot);
            col = colPivot.get(indexPivot);
            System.out.println("rowPivot = " + row + " colPivot = " + col);
            int searchOne = -1;
            double multiplier = 1;
            boolean flag = false;
            if (mat[row][col] != 0) {
                searchOne = searchRow(row, col);
                System.out.println("Multiplier : " + multiplier);
                System.out.println("SearchOne = " + searchOne);
                if (mat[row][col] > mat[searchOne][col]) {
                    multiplier = mat[row][col] / mat[searchOne][col];
                    flag = true;
                } else {
                    multiplier = mat[searchOne][col] / mat[row][col];
                    flag = false;
                }
                for (int j = 0; j < mat[row].length; j++) {
                    if (multiplier > 0) {
                        if (!flag) {
                            mat[row][j] = mat[row][j] - mat[searchOne][j] / multiplier;
                        } else {
                            mat[row][j] = mat[row][j] - multiplier * mat[searchOne][j];
                        }

                    } else {
                        if (!flag) {
                            mat[row][j] = mat[row][j] + mat[searchOne][j] / multiplier * (-1);
                        } else {
                            mat[row][j] = mat[row][j] + (-1) * multiplier * mat[searchOne][j];
                        }
                    }
                }
            }
            printMatrix();
            indexPivot++;

        }

        //System.out.println("Multiplier : " + multiplier);
        //System.out.println("SearchOne = " + searchOne);
        finalStep();

        System.out.println(
                "Berhasil. Solution :");
        printMatrix();

        printSolution();
    }

    static void finalStep() {
        System.out.println("Current Linear Equations: ");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length - 1; j++) {
                if (i == j) {
                    mat[i][mat[i].length - 1] /= mat[i][j];
                    mat[i][j] /= mat[i][j];
                    mat[i][mat[i].length - 1] = Math.round(mat[i][mat[i].length-1]);
                }
            }
        }

    }

    static void printSolution() {
        for (int i = 0; i < mat.length; i++) {
            System.out.println("x" + (i + 1) + " = " + mat[i][mat[0].length - 1]);
        }
    }

    static void printMatrix() {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static void applyOperation(double mult, int row, int currentRow) {
        System.out.println("Apply Operation: ");
        for (int j = 0; j < mat[currentRow].length; j++) {
            if (mult > 0) {

                mat[currentRow][j] = mat[currentRow][j] - mult * mat[row][j];

            } else {
                mat[currentRow][j] = mat[currentRow][j] + (-1) * mult * mat[row][j];
            }
        }
    }

    static int searchRow(int r, int c) {
        int returnRow = r;
        if (r > c) {
            returnRow--;
            while (returnRow >= 0 && mat[returnRow][c] == 0) {
                returnRow--;
            }
            return returnRow < 0 ? returnRow + 1 : returnRow;
        } else {
            returnRow++;
            while (returnRow <= mat.length - 1 && mat[returnRow][c] == 0) {
                returnRow++;
            }
            return returnRow > mat.length - 1 ? returnRow - 1 : returnRow;
        }

    }

    public static void main(String[] args) {
        doAlgorithm();
    }

}
