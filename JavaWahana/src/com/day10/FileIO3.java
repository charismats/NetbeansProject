/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day10;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CHAR0
 */
public class FileIO3 {
    public static void main(String[] args) {
        Scanner sc;
        FileWriter writer;
        
        try {
            sc = new Scanner(new File("input.txt"));
            writer = new FileWriter(new File("output.txt"));
            
            while(sc.hasNext()){
                String line = sc.nextLine();
                System.out.println(line);
                writer.write(line + "\n");
                
                
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIO3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIO3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
