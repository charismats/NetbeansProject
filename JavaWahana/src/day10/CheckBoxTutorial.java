/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author charisma
 */
public class CheckBoxTutorial extends JPanel implements ItemListener{

    JCheckBox ch1, ch2, ch3, ch4;
    StringBuffer choices;
    public CheckBoxTutorial(){
        choices = new StringBuffer("----");
        ch1 = new JCheckBox("Check 1");
        ch1.setSelected(false);
        ch1.addItemListener(this);
        add(ch1);
        
        ch2 = new JCheckBox("Check 2");
        ch2.setSelected(false);
        ch2.addItemListener(this);
        add(ch2);
        
        ch3 = new JCheckBox("Check 3");
        ch3.setSelected(false);
        ch3.addItemListener(this);
        add(ch3);
        
        ch4 = new JCheckBox("Check 4");
        ch4.setSelected(false);
        ch4.addItemListener(this);
        add(ch4);
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        int idx = -1;
        char c='-';
        Object source = e.getItemSelectable();
        if(source == ch1){
            idx = 0;
            c = '1';
        }
        else if( source == ch2){
            idx = 1;
            c = '2';
        }
        else if( source == ch3 ){
            idx = 2;
            c = '3';
        }
        else if( source == ch4){
            idx = 3;
            c = '4';
        }
        
        if( e.getStateChange() == ItemEvent.DESELECTED){
            c = '-';
        }
        
        choices.setCharAt(idx, c);
        //JOptionPane.showMessageDialog(null, choices.toString());
    }
    
    public static void createGUIAndShow(){
        JFrame frame = new JFrame("CheckBox with JCheckBox");
        frame.setContentPane(new CheckBoxTutorial());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,200);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater( new Runnable(){

            @Override
            public void run() {
               createGUIAndShow();
            }
            
        });
    }
}
