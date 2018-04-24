/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.pattern.strategy;

public class Dog extends Animal {

    public void digHole() {

        System.out.println("Dug a hole");

    }

    public Dog() {

        super();

        setSound("Bark");

        // We set the Flys interface polymorphically
        // This sets the behavior as a non-flying Animal
        flyingType = new CantFly();

    }

    /* BAD
	* You could override the fly method, but we are breaking
	* the rule that we need to abstract what is different to 
	* the subclasses
	* 
	public void fly(){
		
		System.out.println("I can't fly");
		
	}
     */
}
