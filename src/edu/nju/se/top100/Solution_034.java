package edu.nju.se.top100;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 
 * @author zongk
 *
 */
public class Solution_034 {

	public int[] searchRange(int[] nums, int target) {
		
		int[] result = new int[2];
		
		int left = 0;
		int right = nums.length - 1;
		
		while(left < right) {
			
			int mid = (left + right) / 2;
			
			if(nums[mid] >= target) {
				right = mid;
			} else {
				left = mid + 1;
			}
			
		}
		
		if(left == right && nums[left] == target) {
			result[0] = left;
		} else {
			result[0] = -1;
			result[1] = -1;
			return result;
		}
		
		right = nums.length - 1;
		
		while(left < right) {
			
			int mid = (left + right) / 2;
			
			if(nums[mid] <= target) {
				left = mid + 1;
			} else {
				right = mid;
			}
			
		}
		
		result[1] = nums[left] == target ? left : left-1;
		
		return result;
		
	}

}
