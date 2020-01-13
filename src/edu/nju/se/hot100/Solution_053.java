package edu.nju.se.hot100;

/**
 * 最大子序和
 * 
 * @author zongk
 *
 */

public class Solution_053 {

	public int maxSubArray(int[] nums) {
		int max = nums[0];
		int sum = 0;
		for(int i=0; i<nums.length; i++) {
			sum = sum + nums[i];
			max = Math.max(max, sum);
			if(sum < 0) {
				sum = 0;
			}
		}
		return max;
	}
}
