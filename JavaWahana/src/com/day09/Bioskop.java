/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day09;

/**
 *
 * @author CHAR0
 */
public class Bioskop {
    public Seat[] seats;
    
    public Bioskop(){
        seats = new Seat[150];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 15; j++){
                Seat s = new Seat();
                s.available = true;
                s.id = (char)('A'+i)+"-"+(j+1);
                seats[i*15 + j] = s;
            }
            
        }
//        for(Seat s: seats){
//            System.out.println(s.id);
//        }
    }
    
    public void printSeatStatus(){
        for(Seat s: seats){
            System.out.print(s.id + " ");
            if( s.available)
                System.out.println("kosong");
            else
                System.out.println("sudah dipesan");
        }
    }
    
    public boolean pesanTiket(String seatID){
        boolean ret = false;
        for(int i = 0; i < seats.length; i++){
            if( seats[i].id.equals(seatID) && seats[i].available){
                seats[i].available = false;
                ret = true;
               // System.out.println("Masuk sini");
            }
            else if(seats[i].equals(seatID) && !seats[i].available){
                ret = false;
            }
        }
        return ret;
    }
}
