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
public class Bird extends Animal{
    public Bird(String nama){
        super(nama);
        this.legs = 2;
        behaviourFly = new CanFly();
    }
    
    @Override
    public void eat(){
        System.out.println(this.nama+ " eats worms");
    }
}
