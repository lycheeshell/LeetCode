package edu.nju.se.hot100;

import java.util.Arrays;

/**
 * 下一个排列
 * 
 * @author zongk
 *
 */
public class Solution_031 {

	public void nextPermutation(int[] nums) {
		
		int index = -1;
		for(int i=nums.length-1; i>0; i--) {
			
			if(nums[i] > nums[i-1]) {
				index = i-1;
				break;
			}
			
		}
		
		if(index == -1) { 
			Arrays.sort(nums);
			return;
		}
		
		int minIndex = index+1;
		for(int i=nums.length-1; i>index+1; i--) {
			if(nums[i] > nums[index]) {
				minIndex = i;
				break;
			}
		}
		
		int temp = nums[index];
		nums[index] = nums[minIndex];
		nums[minIndex] = temp;
		
		int[] rev = new int[nums.length-index-1];
		
		for(int i=index+1; i<nums.length; i++) {
			rev[i-index-1] = nums[i];
		}
		
		for(int i=rev.length-1; i>=0; i--) {
			nums[++index] = rev[i];
		}
		
		
	}
}
