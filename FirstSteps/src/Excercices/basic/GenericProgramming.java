/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excercices.basic;
import java.util.*;

/**
 *
 * @author leon
 */
public class GenericProgramming {
    public static void main(String[] args) {       
    
    }
    
    
    //1. Write a Java program to create a generic method that takes two arrays of 
    //the same type and checks if they have the same elements in the same order.
    
    public static <T> boolean verify_arrs(T[] arr1, T[] arr2){
        
        if(arr1.length != arr2.length) return false;
        
        
        for (int i = 0; i < arr2.length; i++) {
            if(arr1[i] != arr2[i]) return false;            
        }
        return true;
    }
    
    //2) Write a Java program to create a generic method that takes a list of 
    //numbers and returns the sum of all the even and odd numbers
    
    public static <T extends Number> double[] sum_even_odd(List<T> arr){
        double[] response = new double[2];
        //response[0]: sum of even elemts response[1] por odd
        response[0] =0;
        response[1] =0;
        for(T n : arr){
            if(n.doubleValue() % 2 == 0)  response[0] +=  n.doubleValue();
            else response[1] += n.doubleValue();
        }
        return response;
        
        
    }
    
    //3. Write a Java program to create a generic method that takes a list of any type and a target element.
    //It returns the index of the first occurrence of the target element in the list. Return -1 if the target
    //element cannot be found.
    
    public static <T extends Comparable> int findTargert(List<T> list, T target){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).compareTo(target) == 0) {
                return i;
            }
        }
        
        return -1;
    }
    
    //4. Write a Java program to create a generic method that takes a list of any type and returns 
    //it as a new list with the elements in reverse order.
    
    public static <T> List<T> reverseList(List<T> list){
        T actual_val = list.get(0);
        
        for (int i = 0; i > list.size()/2; i--) {
            list.set(i, actual_val)
            ;
            
        }
        return list;
    }
}


