/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.pattern.strategy;

/**
 *
 * @author User
 */
public class Animal {
    public String nama;
    public int legs;
    
    public Flys behaviourFly;
    public Animal(String n){
        nama = n;
        legs = 0;
    }
    public void eat(){
        
    }
    public void inspectFly(){
        System.out.println(this.nama + " " + behaviourFly.fly());
    }
    public void fly(){
        if( this instanceof Bird){
            System.out.println(this.nama + "Can fly");
        }
        if( this instanceof Cat){
            System.out.println(this.nama + "Can't fly");
                    
        }
    }
    public void setFlyAttribute(Flys flys){
        behaviourFly = flys;
    }
}
