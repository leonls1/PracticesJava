/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firststeps.Tests.genercic_programming;
import java.util.*;
/**
 *
 * @author leon
 */
public class ArrayListExcercise {
     public static void main(String[] args) {
     List <human> arr = new ArrayList<human>();
    
     arr.add(new human(20, 2, 2));   
     arr.add(new human(30,2,2));   
     arr.add(new human(120, 2, 2));   
     arr.add(new human(220, 2, 2));   
     System.out.println(arr.size());
     arr.forEach((x)-> {
         System.out.println(x.getAge());
     });
    }
    
        
    
}

class human{
    
    public human(){}
    public human(int age, int legs, int arms){
        this.age = age;
        this.legs = legs;
        this.arms = arms;
    }
    private int age =10;
    private int legs = 2;
    private int arms = 2;

    public int getAge() {
        return age;
    }

    public int getLegs() {
        return legs;
    }

    public int getArms() {
        return arms;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public void setArms(int arms) {
        this.arms = arms;
    }

    
    
}
