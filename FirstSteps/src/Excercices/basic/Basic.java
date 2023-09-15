/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excercices.basic;
//excercises -> https://www.w3resource.com/java-exercises/basic/index.php

public class Basic {
    
    public static void main(String[] args){
        divisibleBy_3_5_35(100);
    }
    
    //Write a Java program and compute the sum of an integer's digits.
    public static int sumOfDigits(int number){
        int sum =0;
        while(number!=0){
            sum +=number%10;
            number/=10;
        }
        
        return sum;        
    }
    
    //Write a Java program to reverse a string.    
    public static void reverseString(String s){
        char[] letters= s.toCharArray();
        String response="";
        for(int i= letters.length-1;i>=0;i-- ){/*with this I will start "i" in the final character*/
            response += letters[i];
        }
        System.out.println(response);
    }
    
    //44)Write a Java program that accepts an integer (n) and computes the value of n+nn+nnn.
    public static int n_nn_nnn(int number){
        
        int response =0;
        for(int j=2; j>=0; j--){
            for(int i= j;i>=0 ;i--){
                response+= number*(int)Math.pow(10, i);
            }
           /* return (number + 
                    (number*10+number) + 
                    (number*100+number*10+number));*/

            }
        return response;
    }
    
    /*44_B)self implementation of a variation with paramater that say how many 
           times repeat and sum the value*/
    public static int n_nn_nnn_V2(int number, int times){
        int response=0;
        for(int i=times; i>=0; i--){
            for(int j=i; j>=0;j--){
                response+=number*(int)Math.pow(10,j);
            }
        }
        return response;
    }
    
    /*50)Write a Java program to print numbers between 1 and 100 divisible by 
    3, 5 and both.*/
    public static void divisibleBy_3_5_35(int finishNumber){
        String three, five, threeAndFive;
        three = five = threeAndFive = "";
        
        for(int i=1; i<=finishNumber;i++){
            if(i%3==0 && i%5==0 )
                threeAndFive+= " " + i ;
            if(i%3==0)
                three+= " "+i;
            else if(i%5==0)
                five+=" " + i;
        }
        System.out.println(three +"\n" +five+ "\n"+ threeAndFive);
        
    }
    
}

