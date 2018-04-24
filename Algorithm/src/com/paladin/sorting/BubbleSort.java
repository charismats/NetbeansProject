/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paladin.sorting;

import java.util.Arrays;

/**
 *
 * @author charisma
 * @version 1.0
 * @since April 2014
 */
public class BubbleSort {

    private int[] num;
    private boolean ascending = true;

    public BubbleSort(int[] val) {
        num = Arrays.copyOf(val, val.length);
    }

    public void RunAlgorithm() {
        int n = num.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ascending) {
                    if (num[i] < num[j]) {
                        int temp = num[i];
                        num[i] = num[j];
                        num[j] = temp;
                        //System.out.print("(i,j) = (" + i + "," + j + ") ->");
                        //print();
                    }
                } else {
                    if (num[j] < num[i]) {
                        int temp = num[i];
                        num[i] = num[j];
                        num[j] = temp;
                        //print();
                    }
                }
            }
        }
    }

    public void print() {
        System.out.print("[");
        for (int v : num) {
            System.out.print(v + ",");
        }
        System.out.println("\b]");
    }

    public static void main(String[] args) {
        int[] arr = {20, 1, 3, 0, 30, 4, -5, -2, -1, 100, 20, 25};
        BubbleSort bs = new BubbleSort(arr);
        bs.print();
        bs.RunAlgorithm();
        bs.print();
    }
}
