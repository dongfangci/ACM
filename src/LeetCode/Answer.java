package LeetCode;
public class Answer {}

/*
  136. Single Number
  Given an array of integers, every element appears twice except for one. 
  Find that single one.

  Note:
  Your algorithm should have a linear runtime complexity. 
  Could you implement it without using extra memory?
 */
	class Solution {
	    public int singleNumber(int[] nums) {
	        int result = 0;
	        for(int i = 0;i<nums.length;i++){
	        result = result ^ nums[i];
	        }
	        return result;
	}
	}
/*I'm sure for a lot of people this may be confusing as to why this works. 
 * The idea hinges on 3 properties of xor. 
 * (1) that its a commutative operation (i.e. a xor b = b xor a).
 * (2) that something xor itself is 0. So a xor a = 0. 
 * (3) 0 xor a = a. These three properties mean that 

	a xor b xor a = a xor a xor b = 0 xor b = b. 

 * */
