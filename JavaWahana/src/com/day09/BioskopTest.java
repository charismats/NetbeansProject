/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day09;
import java.util.Scanner;

/**
 *
 * @author CHAR0
 */
public class BioskopTest {
    
    private Bioskop bioskop;
    private Scanner sc;
    
    public BioskopTest(){
        bioskop = new Bioskop();
    }
    public void printSeat(){
        bioskop.printSeatStatus();
    }
    public void pesanTiket(){
        bioskop.printSeatStatus();
        System.out.println("Pesan tiket seat berapa?");
        String seat = sc.nextLine();
        boolean success = bioskop.pesanTiket(seat);
        if( success){
            System.out.println("Bayar Rp.35000");
        }
        else{
            System.out.println("Seat sudah dibooking");
        }
    }
    public void showMenu(){
        boolean quit = false;
        sc = new Scanner(System.in);
        while(!quit){
            System.out.println("1. Liat seat status");
            System.out.println("2. Pesan tiket");
            System.out.println("3. Quit");
            System.out.println("Pilih menu 1/2/3: ");
            int menu = sc.nextInt();
            sc.nextLine();
            switch(menu){
                case 1:
                    printSeat();
                    break;
                case 2:
                    pesanTiket();
                    break;
                case 3:
                    quit = true;
                    break;
            }
        }
    }
    public static void main(String[] args) {
        BioskopTest bt = new BioskopTest();
        bt.showMenu();
    }
}
