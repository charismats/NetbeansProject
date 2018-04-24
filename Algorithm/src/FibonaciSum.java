/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author charisma
 */
public class FibonaciSum {
    public static void main(String[]args){
        int n = 10000;
        BigInteger div = new BigInteger("1");
        BigInteger fib = new BigInteger("1");
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");
        //long fib,a = 0,b=0;
       float sum = 0;
        for(int i= 0 ; i < n ; i++){
            div = div.multiply(new BigInteger("2"));
            if( i <= 1){
                fib = new BigInteger("1");
                if( i==0)
                    a = fib;
                else
                    b = fib;
            }
            else{
                BigInteger t = a.add(b);
                a = b;
                b = t;
                fib = b;
            }
            System.out.println("Fib = "+fib.toString() + "Div = "+div.toString());
           
            sum += fib.divide(div).floatValue();
        }
        
        System.out.println("Sum Fibonaci series ; "+sum);
    }
}
