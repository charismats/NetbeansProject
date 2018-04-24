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
public class ObserverTester {
    public static void main(String[] args) {
        MatkulGrabber matkulGrabber = new MatkulGrabber();
        
        Observer obs1 = new MatkulObserver(matkulGrabber);
        Observer obs2 = new MatkulObserver(matkulGrabber);
        Observer obs3 = new MatkulObserver(matkulGrabber);
        
        matkulGrabber.setNilaiOOAD(80);
        matkulGrabber.setNilaiALPRO(90);
        matkulGrabber.setNilaiRPL(70);
    }
}
