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
public interface Flys {
    public String fly();
}

class CanFly implements Flys{

    @Override
    public String fly() {
        return "Can fly";
        
    }
}

class CantFly implements Flys{
    @Override 
    public String fly(){
        return "Can't fly";
    }
}