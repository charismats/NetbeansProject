/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day02;
import java.util.Scanner;
/**
 *
 * @author charisma
 */
public class IfAndElse {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukan tahun kelahiran : " );
        int year = sc.nextInt();
        if( year % 400 == 0 || ( year % 4 == 0 && year % 100 != 0)){
            System.out.println("Tahun kelahiran anda adalah kabisat");
        }else{
            System.out.println("Tahun kelahiran anda bukan kabisat");
        }
    }
}
