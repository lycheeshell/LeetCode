package edu.nju.se.hot100;

/**
 * 二分查找
 * 
 * @author zongk
 *
 */
public class Solution_704 {

	public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while(left <= right && left < nums.length && right >= 0) {
            int mid = (left + right) / 2;

            if(mid == left && mid == right) {
                return nums[mid] == target ? mid : -1;
            }

            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;

    }

}
