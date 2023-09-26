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
        int[] try1 = {1,2,3,4};
        int[] solution = Easy.twoSum(try1, 2);
        
        for(int x: solution){
            System.out.println(x);
        }
    }
    
    static public int[] twoSum(int[] nums, int target) {
        //getting the size of nums to not re-calculate it later
        int n = nums.length;
        
        for(int i = 0; i < n-1; i++ ){
            for(int j = i+1; j < n-1; j++){ //j is = i+1 because it need to be the next item on my vec
                //not the current one
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        System.out.println("No possible combination in the array for the target: " + target);
        return new int[]{};//an empty array if there isn't any possible combination
    }
    
}
