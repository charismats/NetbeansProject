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
public class StrategyTester {
    public static void main(String[] args) {
        Animal cat = new Cat("Pussy");
        Animal bird = new Bird("Tori");
        cat.eat();
        bird.eat();
        cat.inspectFly();
        bird.inspectFly();
        cat.fly();
        bird.fly();
    }
}
