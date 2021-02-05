




/*

34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109




*/


public class Solution34 {
     
    public int[] searchRange(int[] nums, int target) {

        return new int[] {};
        
    }


    public static void main(String[] arcs){
        long startTime = System.nanoTime();
        Solution34 solution = new Solution34();
       
        System.out.println(solution.searchRange(new int[] {5,7,7,8,8,10}, 8));  // [3,4] 
        System.out.println(solution.searchRange(new int[] {5,7,7,8,8,10}, 6));  // [-1, -1]
        System.out.println(solution.searchRange(new int[] {}, 0));  // [-1, -1]
            
        long stopTime = System.nanoTime();
        System.out.println("Time used: " + (stopTime - startTime));
    }
}
