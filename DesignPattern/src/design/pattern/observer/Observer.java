/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.pattern.observer;

// The Observers update method is called when the Subject changes
public interface Observer {

    public void update(double ibmPrice, double aaplPrice, double googPrice);

}
