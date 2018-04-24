/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day09;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author charisma
 */
public class CarFileIO {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Siapa nama pemilik mobil ? ");
        String name = sc.nextLine();
        System.out.println("Apa merk mobil ? ");
        String merk = sc.nextLine();
        System.out.println("Apa plat no mobil ?");
        String plat = sc.nextLine();
        System.out.println("Apa warna mobil ? ");
        String warna = sc.nextLine();
        
        Mobil mb1 = new Mobil();
        mb1.setNama_pemilik(name);
        mb1.setMerk(merk);
        mb1.setPlat_no(plat);
        mb1.setWarna(warna);
        
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("car.txt"));
            bw.write(mb1.getNama_pemilik());bw.newLine();
            bw.write(mb1.getMerk());bw.newLine();
            bw.write(mb1.getPlat_no());bw.newLine();
            bw.write(mb1.getWarna());bw.newLine();
            bw.close();
            System.out.println("File writing completed");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
