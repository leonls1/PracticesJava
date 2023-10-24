/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firststeps.Tests.genercic_programming;

/**
 *
 * @author leon
 */
public class GenericMethods {

    public static void main(String[] args) {
        String[] arrString = {"sasha", "leon", "alexis"};
        
        Integer[] integers = {1,4,12,55,0,-3,11,-55};
        System.out.println(MyMatrix.getSize(arrString));
        System.out.println(MyMatrix.getSmallest(arrString));
        System.out.println(MyMatrix.getSmallest(integers));

    }

    static class MyMatrix {

        //with this method i can send any tipe of array and get the length of it
        public static <T> int getSize(T[] arr) {
            return arr.length;
        }
            
        public static <T extends Comparable> T getSmallest(T[] arr) {
            //with <T extends Comparable> makes that avery type of element implements my Comparable interface
            //so i can use later the compareTo method
            if (arr.length == 0 || arr == null) {
                return null;
            }            
            //setting a first min elemn
            T smallestElement = arr[0];
            for (int i = 0; i < arr.length; i++) {
                //to implement the comparation we will use the intertace compareTo
                // possible results --> negative(smaller), 0(equal), positive(bigger)                
                if (smallestElement.compareTo(arr[i]) > 0) {
                    //if in the comparation my current smallest is > 0 than my actual comparation that
                    //means the current is the smallest
                    smallestElement = arr[i];
                }
            }
            return smallestElement;
        }
    }
}
