/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day10;
import java.util.Stack;
/**
 *
 * @author CHAR0
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stackInt = new Stack<Integer>();
        stackInt.push(1);
        stackInt.push(2);
        stackInt.push(0);
        stackInt.push(5);
        
        while(!stackInt.isEmpty()){
            System.out.println(stackInt.pop());
        }
    }
}
