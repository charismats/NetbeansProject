/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day09;

/**
 *
 * @author CHAR0
 */
public class RectangleTest {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(3,2);
        r1.setX(1);
        r1.setY(1);
        System.out.println(r1);
        double luas = r1.hitungLuas();
        System.out.println("Luas = "+luas);
    }
}
