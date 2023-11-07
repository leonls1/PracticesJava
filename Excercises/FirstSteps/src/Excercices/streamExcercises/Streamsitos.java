/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excercices.streamExcercises;

import java.util.*;
import java.util.stream.Collectors;

public class Streamsitos {
    
    public static void main(String[] args) {
        
    }
    //1)Write a Java program to calculate the average of a list of integers using streams.

    static double avgList(List<Integer> listita) { //remember that collection don't accept primitive types
        return listita.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    //2) Write a Java program to convert a list of strings to uppercase or lowercase using streams.
    static List<String> toUpperOrDoble(int option, ArrayList<String> list) {
        switch (option) {
            case 1: //option one trasnform to upper
                return list.stream().map(String::toUpperCase).collect(Collectors.toList());            
            case 2: //option two transform to lower
                list.stream().map(String::toLowerCase).collect(Collectors.toList());
            default:
                System.out.println("Invalid option");
                return null;
        }
    }

    //3) Write a Java program to calculate the sum of all even, odd numbers in a list using streams.
    static ArrayList<Integer> EvenOddSum(List<Integer> list) {
       // List<Integer> oddNumbers = list.stream().filter(number -> number % 2 == 1).collect(Collectors.toList());
       // List<Integer> eventNumbers  = list.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
        //
        ArrayList<Integer> result = new ArrayList<>();
        result.add(list.stream()
                .filter(number -> number % 2 == 1)
                .mapToInt(Integer::intValue)
                .sum()); //oddNumber
        
        result.add(list.stream()
                .filter(number -> number % 2 == 0 )
                .mapToInt(Integer::intValue)
                .sum());
        System.out.println("Sum of all odd valuse: " + result.get(0) + 
                "\n" + "Sum of all even values:" + result.get(1));
        return result;
        
    }
    
    // 4) Write a Java program to remove all duplicate elements from a list using streams.
    static List<?> removingDuplicates(List<?> list){
        return list.stream().distinct().collect(Collectors.toList());
    } 
        
    //5)  Write a Java program to count the number of strings in a list that start with a specific letter using streams.
    static int countStringsStartingIn(List<String> list, String character){
        return list.stream().filter(string -> string.startsWith(character)).collect(Collectors.toList()).size();
    }
    
    //6) Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.
    static void sortingAlphabeting(List<String> list){
        System.out.println( "ascending order " + 
        list.stream().sorted().collect(Collectors.toList()));
        
        System.out.println("Descending order " +
                list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    }
    
    //7) Write a Java program to find the maximum and minimum values in a list of integers using streams.
    static void MaxAndMinium(List<Integer> list ){
        System.out.println("Max value: " + 
                list.stream()
                        .mapToInt(Integer:: intValue)
                        .max());
        System.out.println("Min value: "
                + list.stream()
                        .mapToInt(Integer:: intValue)
                        .min());
    }
    
    //8  Write a Java program to find the second smallest and largest elements in a list of integers using streams.
    static void SecondSmallestAndLargest(List<Integer> list){
        int smallest = list.stream()
                        .mapToInt(Integer:: intValue)
                        .min().
                        orElse(0);
        int largerst =    list.stream()
                        .mapToInt(Integer:: intValue)
                        .max()
                        .orElse(0);    
        
        System.out.println("Second Smallest: " +
            list.stream()
                    .filter(number -> number > smallest)
                    .mapToInt(Integer::intValue)
                    .min());
        
        System.out.println("Second largest: " +
            list.stream()
                    .filter(number -> number > smallest)
                    .mapToInt(Integer::intValue)
                    .max());
    }
    
    
    
    
    
}
