package edu.nju.se.hot100;

/**
 * 搜索旋转排序数组
 * 
 * @author zongk
 *
 */
public class Solution_033 {

	public int search(int[] nums, int target) {
		
		if(nums == null || nums.length == 0) {
			return -1;
		}
		
		int left = 0;
		int right = nums.length - 1;
		
		
		while(left < right) {
			
			int mid = (left + right) / 2;
			
			if ((nums[left] <= target && target <= nums[mid]) ||
					(nums[left] > nums[mid] && target >= nums[left]) ||
					(nums[left] > nums[mid] && target <= nums[mid]))
				right = mid;
            else
				left = mid + 1;
			
		}
		
		
		return  left == right && nums[left] == target ? left : -1;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,3};
		System.out.println(new Solution_033().search(nums, 2));
	}

}
