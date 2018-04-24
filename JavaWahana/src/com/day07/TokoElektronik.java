/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day07;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author CHAR0
 */
public class TokoElektronik {

    static String[] barang = {"HP Lenovo", "HP Samsung", "HP ASUS"};
    static double[] harga = {3000000, 4000000, 5000000};
    static LinkedList<Integer> cart = new LinkedList<Integer>();
    static void bayarMenu(){
        System.out.println("List barang yang dibeli: ");
        double totalHarga =0;
        for(int i= 0; i < cart.size(); i++){
            System.out.println((i+1) + ". "+ barang[cart.get(i)]+ " Rp. " + harga[cart.get(i)] );
            totalHarga += harga[cart.get(i)];
        }
        System.out.println("Total Pembayaran : Rp. "+ totalHarga);
        
    }
    static void beliMenu() {
        
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < barang.length; i++) {
            System.out.println((i + 1) + ". " + barang[i]+ " Rp. "+harga[i]);
        }
        System.out.println("Beli barang no : ");
        int idxBeli = sc.nextInt();
        cart.add(idxBeli - 1);
    }
    
    static void showMenu(){
        boolean quit = false;
        Scanner sc = new Scanner(System.in);
        
        while(!quit){
            System.out.println("1. Beli barang");
            System.out.println("2. Bayar barang");
            System.out.println("3. Quit App");
            System.out.println("Pilih menu 1/2/3: ");
            int menu = sc.nextInt();
            
            switch(menu){
                case 1:
                    beliMenu();
                    break;
                case 2:
                    bayarMenu();
                    break;
                case 3:
                    quit = true;
                    break;
            }
        }
        
        
        
    }
    public static void main(String[] args) {
        System.out.println("Please enter your username: ");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine().trim();
        System.out.println("Please enter your password: ");
        String password = sc.nextLine().trim();
        
        if( username.equals("admin") && password.equals("admin"))
            showMenu();
        else{
            System.out.println("Login failed");
        }
    }
}
