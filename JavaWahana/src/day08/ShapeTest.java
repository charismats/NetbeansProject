/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day08;

/**
 *
 * @author charisma
 */
public class ShapeTest {
    
    public static void main(String[]args){
        Triangle tri1 = new Triangle(20, 2);
        tri1.setCx(20);
        tri1.setCy(10);
        tri1.setSisi1(10);
        tri1.setSisi2(2);
        tri1.setSisi3(3);
        System.out.println("Luas segitiga = " + tri1.getArea());
        System.out.println("Keliling segitiga = "+tri1.getKeliling());
        System.out.println(tri1.toString());
        
        Rectangle rect1 = new Rectangle(10,2);
        System.out.println(rect1);
        System.out.println("Luas rect1 = "+rect1.getArea());
        
        Circle circle1 = new Circle(10);
        System.out.println(circle1);
        System.out.println("Luas Circle = "+circle1.getArea());
        System.out.println("Keliling circle = "+circle1.getKeliling());
        
        TwoDShape shape1 = tri1;
        
        TwoDShape shape2 = rect1;
        if( shape1 instanceof Triangle){
            Triangle tr = (Triangle) shape1;
            
            System.out.println(shape1.toString());
            System.out.println(tr.toString());
            System.out.println("It's an instance of Triangle");
        }
        else if( shape1 instanceof Rectangle){
            System.out.println("It's an instance of Rectangle");
        }
        else if( shape1 instanceof  Circle){
            System.out.println("It's an instance of Circle");
        }
    }
}
