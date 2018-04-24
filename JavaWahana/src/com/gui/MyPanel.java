    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author CHAR0
 */
public class MyPanel extends JPanel{
    private JButton addButton;
    private int x = 20;
    private int y = 20;
    public MyPanel(){
        addButton = new JButton("Add more Button");
        addButton.setLocation(200,200);
        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               JButton btn1 = new JButton("Button");
               add(btn1);
               btn1.setBounds(x,y,100,20);
               x+=100;
               validate();
            }
            
        });
        setLayout(null);
        add(addButton);
        
        addButton.setBounds(0,0,100,20);
    }
}
