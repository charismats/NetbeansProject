/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soal6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author CHAR0
 */
public class Giveaway {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {2, 2, 2, 2, 2};
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(2);
        a.add(2);
        a.add(2);
        a.add(2);
        
        Collections.sort(a, Collections.reverseOrder());
        int N = 20;
        int numway = giveaway(N, a, 0);
        System.out.println("numway : " + numway);
        
    }

    static int giveaway(int N, ArrayList<Integer> a, int idx) {
        if (idx > a.size()) {
            return -1;
        }
        if (N >= 0 && idx == a.size()) {
            //System.out.println("found cara");
            return 1;
        }
        if (N < 0) {
            return -1;
        }

        int numWays = 0;
        for (int i = a.get(idx); i <= N; i++) {
            if (idx > 0) {
                numWays += giveaway(N - i, a, idx + 1);
            } else {
                numWays = Math.max(numWays, giveaway(N - i, a, idx + 1));
            }
        }
        //System.out.println("N = " + N + " idx = " + idx + "numways = " + numWays);
        return numWays;
    }

}
