/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.pattern.observer;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class MatkulGrabber implements Matkul{
    public ArrayList<Observer> observers;
    public int RPL;
    public int OOAD;
    public int ALPRO;

    public MatkulGrabber(){
        observers = new ArrayList<>();
    }
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregisterObserver(Observer o) {
        int index = observers.indexOf(0);
        observers.remove(index);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(RPL, OOAD, ALPRO);
        }
    }
    
    public void setNilaiRPL(int rpl){
        this.RPL = rpl;
        notifyObserver();
    }
    
    public void setNilaiOOAD(int ooad){
        this.OOAD = ooad;
        notifyObserver();
    }
    
    public void setNilaiALPRO(int alpro){
        this.ALPRO = alpro;
        notifyObserver();
    }
}
