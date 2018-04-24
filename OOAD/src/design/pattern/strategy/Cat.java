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
public class Cat extends Animal{
    public Cat(String nama)
    {
        super(nama);
        this.legs = 4;
        behaviourFly = new CantFly();
    }
    
    @Override
    public void eat(){
        System.out.println(this.nama + " eats fish");
    }
}
