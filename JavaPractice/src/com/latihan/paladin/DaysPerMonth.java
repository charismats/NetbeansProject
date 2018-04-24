/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.latihan.paladin;

/**
 *
 * @author CHAR0
 */
public class DaysPerMonth {
    int[] daysMonth = {31,29,31,30,31,30,31,31,30,31,30,31};
    
    public int getDaysMonth(int year, int month){
        if( month == 1){ //if february
            if( year % 400 == 0 || ( year % 4 == 0 && year % 100 != 0)){
                return 29;
            }else{
                return 28;
            }
        }
        return daysMonth[month];
    }
    public static void main(String[] args) {
        DaysPerMonth dpm = new DaysPerMonth();
        int year = 2012;
        int month = 2; 
        System.out.println("Jumlah hari = "+dpm.getDaysMonth(year, month));
    }
}
