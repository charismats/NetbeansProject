/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day10;
import java.util.LinkedList;
/**
 *
 * @author CHAR0
 * @param <E>
 */
public class MyQueue<E> extends LinkedList<E> {
   public void Enqueue(E o){
       this.addLast(o);
   } 
   public E Dequeue(){
       return this.removeFirst();
   }
}
