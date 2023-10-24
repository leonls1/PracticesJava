/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excercices.lambdaExpresions;
import java.util.*;

//excercises https://www.w3resource.com/java-exercises/lambda/java-lambda-exercise-1.php


//always you need to define an interface for your lambda methods, making an implementation
//that class can define the anonymous method

public class LambdaMethods {
    
    public static void main(String[] args){
       SumCalculator sumCalculator = (x,y) -> x + y;
       VerifyEmptyString verifyEmptyString = (x) ->
               !(x.toCharArray().length>0);
       
        System.out.println(verifyEmptyString.verify(""));
        System.out.println(verifyEmptyString.verify("aso"));
        
       // String[] stringList= new List{"Red", "Green", "Blue", "PINK");
        //3.a
        
        


    }
}
/*1)Write a Java program to implement a lambda expression to find the sum of two integers.*/
interface SumCalculator{
    int sum(int a, int b);   
}
//2)Write a Java program to implement a lambda expression to check if a given string is empty
interface  VerifyEmptyString{
    boolean verify(String s);
}
/* 3)Write a Java program to implement a lambda expression to convert a list of strings to uppercase and lowercase
    in this example i can define anonymous methods without creating an interface for them */
@FunctionalInterface
interface toUppercase{
    String upper(String str);
}

@FunctionalInterface
interface toLowecase{
    String lowe(String str);
}