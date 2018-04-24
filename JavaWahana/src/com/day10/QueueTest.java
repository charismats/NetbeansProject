/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day10;

/**
 *
 * @author CHAR0
 */
public class QueueTest {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);
        while( !queue.isEmpty()){
            System.out.println(queue.Dequeue());
        }
    }
}
