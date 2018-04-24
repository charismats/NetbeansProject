/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.pattern.observer;

/**
 *
 * @author User
 */
public class MatkulObserver implements Observer {

    private int RPL;
    private int OOAD;
    private int ALPRO;
    private static int observerNumber;
    private int observerID;
    private Matkul matkulGrabber;
    public MatkulObserver(Matkul grabber){
        observerID = ++observerNumber;
        matkulGrabber = grabber;
        matkulGrabber.registerObserver(this);
    }
    @Override
    public void update(int RPL, int OOAD, int ALPRO) {
        this.RPL = RPL;
        this.OOAD = OOAD;
        this.ALPRO = ALPRO;
        
        printNilai();
    }
    
    private void printNilai(){
        System.out.println("Observer ID : "+this.observerID + "\nRPL : " + RPL + 
                "\nOOAD : " + OOAD + "\nALPRO: "+ALPRO);
        
    }
}
