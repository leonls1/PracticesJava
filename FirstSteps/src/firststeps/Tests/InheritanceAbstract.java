/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firststeps.Tests;

/**
 *
 * @author leon
 */
public class InheritanceAbstract {
    abstract class Human{
    String name;

        public String getName() {
            return name;
        }
        public abstract void printSomething();
    }
    
    class Employee extends Human(){

        @Override
        public void printSomething() {
            System.out.println("I am an employee");
        }
        
        
    }
}
