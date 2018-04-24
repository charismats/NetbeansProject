/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day01;

import javax.swing.JOptionPane;

/**
 *
 * @author charisma
 */
public class HelloGUI {
    public static void main(String[]args){
        JOptionPane.showMessageDialog(null,"Namaku Charisma", "Message", JOptionPane.INFORMATION_MESSAGE);
        String nama = JOptionPane.showInputDialog("Masukkan nama");
        JOptionPane.showMessageDialog(null, "Nama yang baru dimasukkan"+ nama, "Nama", JOptionPane.INFORMATION_MESSAGE);
    }
}
