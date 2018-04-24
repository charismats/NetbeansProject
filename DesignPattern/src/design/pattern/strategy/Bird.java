/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.pattern.strategy;

public class Bird extends Animal {

    // The constructor initializes all objects
    public Bird() {

        super();

        setSound("Tweet");

        // We set the Flys interface polymorphically
        // This sets the behavior as a non-flying Animal
        flyingType = new ItFlys();

    }

}
