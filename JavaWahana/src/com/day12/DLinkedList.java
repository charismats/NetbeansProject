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
public class DLinkedList<E> {
    public ListNode<E> head;
    public ListNode<E> tail;
    public int numItems;
    
    public DLinkedList(){
        head = tail = null;
        numItems = 0;
    }
    
    public boolean isEmpty(){
        return numItems == 0;
    }
    
    public int size(){
        return numItems;
    }
    
    public void addFirst(E item){
        ListNode<E> newNode = new ListNode(item);
        if( isEmpty()){
            head = tail = newNode;
            numItems++;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
        numItems++;
        return;
    }
    
    public void addLast(E item){
        ListNode<E> newNode = new ListNode(item);
        if( isEmpty()){
            head = tail = newNode;
            numItems++;
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        numItems++;
        return;
    }
    
    public E removeFirst(){
        if( size() == 1){
            E item = head.item;
            head = tail = null;
            numItems--;
            return item;
        }
        
        E item = head.item;
        head = head.next;
        head.prev = null;
        numItems--;
        return item;
    }
    
    public E removeLast(){
        if( size() == 1){
            E item = head.item;
            head = tail = null;
            numItems--;
            return item;
        }
        
        E item = tail.item;
        tail = tail.prev;
        tail.next = null;
        return item;
    }
    
    public void printList(){
        if( isEmpty()){
            System.out.println("List is empty");
            return;
        }
        ListNode<E> curr = head;
        while( curr != null){
            System.out.println(curr.item);
            curr = curr.next;
        }
    }
    
    public void printListReverse(){
        if( isEmpty()){
            System.out.println("List is empty");
        }
        ListNode<E> curr = tail;
        while( curr != null){
            System.out.println(curr.item);
            curr = curr.prev;
        }
    }
}
