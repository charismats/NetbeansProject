/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day12;

/**
 *
 * @author CHAR0
 */
public class DLinkedListTest {
    public static void main(String[] args) {
        DLinkedList<Integer> list = new DLinkedList<>();
        for(int i = 0; i < 10; i++){
            list.addFirst(i);
        }
        
        System.out.println("List contentns: ");
        list.printList();
        System.out.println("List contents (reverse):");
        list.printListReverse();
        
    }
}
