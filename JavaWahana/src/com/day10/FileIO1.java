/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day10;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author CHAR0
 */
public class FileIO1 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream("input.txt");
            fos = new FileOutputStream("input2.txt");
            int c;
            while( (c = fis.read()) != -1){
                System.out.print((char)c);
                fos.write(c);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
