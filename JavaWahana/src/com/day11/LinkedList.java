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
public class LinkedList<E> {

    public ListNode<E> head;
    public ListNode<E> tail;
    public int size;

    public LinkedList() {
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(E item) {
        ListNode<E> newNode = new ListNode<E>(item);
        if (isEmpty()) {
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
        return;
    }

    public void addLast(E item) {
        ListNode<E> newNode = new ListNode<E>(item);
        if (isEmpty()) {
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
        return;
    }

    public E removeFirst() {
        if (size() == 1) {
            E item = head.item;
            head = tail = null;
            size--;
            return item;
        }
        E item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public E removeLast() {
        if (size() == 1) {
            E item = head.item;
            head = tail = null;
            size--;
            return item;
        }
        ListNode<E> curr = head;
        while (curr.next != tail) {
            curr = curr.next;
        }
        E item = tail.item;
        curr.next = null;
        tail = curr;
        size--;
        return item;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        ListNode<E> curr = head;
        System.out.println("List contents :");
        while (curr != null) {
            System.out.println(curr.item);
            curr = curr.next;
        }
    }

    public void insertAt(int at, E item) {
        if (at >= 0 && at <= size() - 1) {
            if (at == 0) {
                addFirst(item);
            } else if (at == size() - 1) {
                addLast(item);
            } else {
                ListNode<E> newNode = new ListNode<E>(item);
                ListNode<E> curr = head;
                int i = 1;
                while (i < at) {
                    i++;
                    curr = curr.next;
                }
                newNode.next = curr.next;
                curr.next = newNode;
                size++;
                return;
            }

        } else {
            System.out.println("Invalid insert point");
        }
    }
}
