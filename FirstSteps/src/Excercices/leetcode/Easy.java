/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excercices.leetcode;

/**
 *
 * @author leon
 */
public class Easy {

    public static void main(String[] args) {
        int[] try1 = {1, 2, 3, 4};
        int[] solution = Easy.twoSum(try1, 2);

        for (int x : solution) {
            System.out.println(x);
        }
    }

    static public int[] twoSum(int[] nums, int target) {
        //getting the size of nums to not re-calculate it later
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n - 1; j++) { //j is = i+1 because it need to be the next item on my vec
                //not the current one
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        System.out.println("No possible combination in the array for the target: " + target);
        return new int[]{};//an empty array if there isn't any possible combination
    }
    /*
    Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. 
    The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
    Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the 
    following things:
    Change the array nums such that the first k elements of nums contain the elements which are not equal to 
    val. The remaining elements of nums are not important as well as the size of nums.
    Return k.
     */
    public int removeElement(int[] nums, int val) {
        int total = 0;
        int[] arrResponse = new int[nums.length-1];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                total++;
                
            }            
        }
        return total;      
    }
    
     public int romanToInt(String s) {
        String storage = "";
        char [] arr = s.toCharArray();
        int sum = 0;
        char before = 'n';
        
        for(char str : arr){
            //if((str =='I' || str == 'X' || str == "C"){
            
        }
        }
    }

}
