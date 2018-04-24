/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day10;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author charisma
 */
public class ButtonTutorial extends JPanel implements ActionListener{
    JButton b1;
    
    public ButtonTutorial(){
        ImageIcon img = getImageIcon("image/middle.gif");
        b1 = new JButton("Click Me", img);
        b1.setVerticalTextPosition(AbstractButton.BOTTOM);
        b1.setHorizontalTextPosition(AbstractButton.CENTER);
        b1.setActionCommand("Click");
        
        b1.addActionListener(this);
        add(b1);
    }

    public ImageIcon getImageIcon(String url){
        java.net.URL imageURL = ButtonTutorial.class.getResource(url);
        if( imageURL != null){
            return new ImageIcon(imageURL);
        }
        
        System.err.println("Couldn't find file: " + url);
        return null;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getActionCommand().equals("Click")){
            JOptionPane.showMessageDialog(null, "You have clicked me");
        }
    }
    
    public static void createGUIAndShow(){
        JFrame frame = new JFrame("Button with JButton");
        frame.setContentPane(new ButtonTutorial());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,200);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[]args){
       javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               createGUIAndShow();
            }
        });
    }
}
