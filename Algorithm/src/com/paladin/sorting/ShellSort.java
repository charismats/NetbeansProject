/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paladin.sorting;

/**
 *
 * @author CHAR0
 */
import java.util.Arrays;

public class ShellSort {

    public void sort() {

        int n = theArray.length;
 
        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = theArray[i];
 
                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && theArray[j - gap] > temp; j -= gap)
                    theArray[j] = theArray[j - gap];
 
                // put temp (the original a[i]) in its correct
                // location
                theArray[j] = temp;
                System.out.println(Arrays.toString(theArray));
            }
        }
    }

	

    public static void main(String[] args) {

        ShellSort theSort = new ShellSort(10);

        System.out.println(Arrays.toString(theSort.theArray));

        theSort.sort();

        System.out.println(Arrays.toString(theSort.theArray));

    }

    private int[] theArray;

    private int arraySize;

    ShellSort(int arraySize) {

        this.arraySize = arraySize;

        theArray = new int[arraySize];

        generateRandomArray();

    }

    public void generateRandomArray() {

        for (int i = 0; i < arraySize; i++) {

            // Generate a random array with values between
            // 10 and 59
            theArray[i] = (int) (Math.random() * 50) + 10;

        }

    }

    public void printHorzArray(int i, int j, int h) {

        if (i == j) {
            i = i - h;
        }

        for (int n = 0; n < 51; n++) {
            System.out.print("-");
        }

        System.out.println();

        for (int n = 0; n < arraySize; n++) {

            System.out.print("| " + n + "  ");

        }

        System.out.println("|");

        for (int n = 0; n < 51; n++) {
            System.out.print("-");
        }

        System.out.println();

        for (int n = 0; n < arraySize; n++) {

            System.out.print("| " + theArray[n] + " ");

        }

        System.out.println("|");

        for (int n = 0; n < 51; n++) {
            System.out.print("-");
        }

        System.out.println();

        if (i != -1) {

            // Number of spaces to put before the F
            int spacesBeforeFront = 5 * i + 1;

            for (int k = 0; k < spacesBeforeFront; k++) {
                System.out.print(" ");
            }

            System.out.print("I");

            // Number of spaces to put before the R
            int spacesBeforeRear = (5 * j + 1 - 1) - spacesBeforeFront;

            for (int l = 0; l < spacesBeforeRear; l++) {
                System.out.print(" ");
            }

            System.out.print("O");

            System.out.println("\n");

        }

    }

}
