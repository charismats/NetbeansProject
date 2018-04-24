package com.day11;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScannerFileIO {

    public static void main(String[] args) {
        try {
            File f = new File("input.txt");
            Scanner sc = new Scanner(f);
            BufferedWriter bw = new BufferedWriter(new FileWriter("input_copy.txt"));
            while (sc.hasNext()) {
                String line = sc.nextLine();    
                System.out.println(line);
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            System.out.println("Copy file finished");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
