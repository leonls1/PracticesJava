/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excercices.basic;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author leon
 */
public class ArrayExc {    
    public static void main(String[] args) {
        ArrayExc methods = new ArrayExc();
        int [] arr = new int[5];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
        
        methods.print_arr(arr);
        
        methods.reverse_int(arr);
        methods.print_arr(arr);
        
        methods.print_arr(methods.find_2_largest_elements(arr));
        
        
     
        
    }
    
    //5) Write a Java program to test if an array contains a specific value.
    public boolean contains(int[] arr, int val){
        boolean response = false;
            for (int i = 0; i < arr.length; i++) {
                if(val == arr[i]){
                    response = true;
                    break;
                }
            }
            return response;   
    }
    
    public boolean contains_v2(int[] arr, int val){ //a shorter way
        for(int n : arr){
            if(n == val){
                return true;
            }
        }
        return false;
    }
    
    //6) Write a Java program to find the index of an array element.    
    public int get_index(int[] arr, int val){
        for (int i = 0; i < arr.length; i++) {
            if(val == arr[i]){
                return i;
            }
        }
        return -1;
    }
    
    //9) Write a Java program to insert an element (specific position) into an array
    public int [] instert_specific(int [] arr, int val, int position){// my solution it's a psuedo arraylist with variable size
        int[] response = new int[arr.length];
        response[position] = val;
        for (int i = 0; i < response.length; i++) {
            if(i != position){
              response[i] = arr[i];  
            }           
            
        }
        return response;
    }
    
    //10) Write a Java program to find the maximum and minimum value of an array.
    public int [] max_min(int [] arr){
        int min, max;
        min = max = 0;
        
        for(int n : arr){
            if (n < min)         min = n;
            else if( min > max)  max = n;
                        
        }
        return new int[]{min, max};
    }
    
    //11) Write a Java program to reverse an array of integer values
    public void reverse_int(int [] arr){ 
        int var, j;
        /*j = 0;
        for(int i = arr.length; i > 0; i--){//with this aproach the array will be exactly the same
            var = arr[j];
            arr[j] = arr[i];
            arr[i] = var;
            j++;
        }*/
        
        j = 0; // a correct way
        for(int i = arr.length - 1; i > arr.length/2; i--){
            var = arr[j];
            arr[j] = arr[i];
            arr[i] = var;
            j++;
        }
    }
    
    public void print_arr(int [] arr){
        String response = "";
        for(int n : arr){
            response += n + " ";
        }
        System.out.println(response);
    }
    
    
    //12) Write a Java program to find duplicate values in an array of integer values.    
    public int  findDuplicates(int [] arr){
        int len = arr.length;
        int val, position;
        for (int i = 0; i < len; i++) {
            val = arr[i];
            for (int j = 1; j < len; j++) {
                if(val == arr[j]){
                    return val;
                }               
            }           
        }
        return -1;
    }
    public int [] findDuplicates_v2(int [] arr){// an option to return an array of duplicated values
        int len = arr.length;
        int val, response_position;
        response_position = 0;
        int [] response = new int [len/2];  
        for (int i = 0; i < len; i++) {
            val = arr[i];
            for (int j = 1; j < len; j++) {
                if(val == arr[j]){
                    response[response_position] = val;
                    response_position++;
                }                
            }           
        }
        return response;
    }
    
    //17) Write a Java program to find the second largest element in an array
    public int[] find_2_largest_elements(int [] arr){
        int max, submax;
        max = arr[0];
        submax = arr[1];
        for (int i = 1; i < arr.length; i++) {
            if( arr[i] > submax){
                if( arr[i] > max){
                    max = arr[i];
                }
                submax = arr[i];
            }            
        }
        return new int[]{max, submax};
    }
    
    //20) Write a Java program to convert an array to an ArrayList
    public ArrayList arr_to_arrList(String []arr){
        
        ArrayList<String> arrList = new ArrayList<String>(Arrays.asList(arr));
        return arrList;
    }
    
    //21)Write a Java program to convert an ArrayList to an array    
    public String[] arrList_to_arr(ArrayList<String> arrList){
        String [] arr = new String[arrList.size()]; //first i need to set the initial capacity
        arrList.toArray(arr);        
        return arr;
    }
    
    //22)Write a Java program to find all pairs of elements in an array whose sum is equal to a specified number.
   /* public int [] pairs_equal_sum(int [] arr, int target){
        int len = arr.length;
        ArrayList<Integer> pair_index = new ArrayList<>();
        
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if(arr[i] + arr[j] == target ){
                    
                }
                    
            }
            
        }
    }*/
}
