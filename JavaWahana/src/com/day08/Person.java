    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.day08;

/**
 *
 * @author CHAR0
 */
public class Person {
    private String name;
    private String job;
    private int age;
    //constructor
    public Person(){
        this.name = "";
        this.age = 0;
    }
    public Person(String n, int a){
        this.name = n;
        this.age = a;
    }
    public void info(){
        System.out.println("Name : " + name);
        System.out.println("Job : "+job);
        System.out.println("Age : "+age);
    }
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "Charisma";
        p.age = 29;
        p.job = "Teacher";
        p.info();
    }
}
