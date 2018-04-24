/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day11;

/**
 *
 * @author CHAR0
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> listInt = new LinkedList<>();
        for(int i = 0; i < 10; i++){
            listInt.addLast(i);
        }
        listInt.insertAt(listInt.size()-1, 100);
        listInt.printList();
        System.out.println("");
        System.out.println("Remove First : " + listInt.removeLast());
    }
}
