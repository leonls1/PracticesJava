package Excercices.collections;

import java.util.*;

public class excercises {
    public static void main(String[] args) {
        
    }
    
    //9. Write a Java program to find numbers less than 7 in a tree set.
    private static void findLessThan(int n, TreeSet<Integer> set){
        for(int number: set){
            if(number <= n){
                System.out.println(number);
        }   
            else break;
        }
    }
    
}
