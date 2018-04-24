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
public class ListNode<E> {
    public E item;
    public ListNode<E> next;
    
    public ListNode(E item){
        next = null;
        this.item = item;
    }
}
