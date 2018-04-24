/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day09;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

/**
 *
 * @author charisma
 */
public class FileIO {

    public static void writeToFile(FileOutputStream fos, String text){
        try{
            for(int i = 0; i < text.length(); i++){
                int ch = (int) text.charAt(i);
                fos.write(ch);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        FileInputStream fis  = null;
        FileOutputStream fos = null;
        
        FileReader fr = null;
        FileWriter fw = null;
        try{
            fis = new FileInputStream("input.txt");
            int ch;
            while( (ch = fis.read()) != -1){
                System.out.print((char)ch   );
            }
            
            fos = new FileOutputStream("output.txt");
           
            String textToWrite = "Charisma Tubagus Setyobudhi";
            writeToFile( fos, textToWrite);
            
            fr = new FileReader("input.txt");
            fw =  new FileWriter("input_copy.txt");
            
            while( (ch = fr.read()) != -1){
                fw.write(ch);
            }
            fr.close();
            fw.close();
            System.out.println("Copying file completed");
        }catch(IOException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
