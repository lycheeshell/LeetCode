package edu.nju.se.hot100;

/**
 * 盛最多水的容器
 * 
 * @author zongk
 *
 */
public class Solution_011 {

	public int maxArea(int[] height) {
		
		int max = Integer.MIN_VALUE;
		
		int left = 0;
		int right = height.length - 1;
		
		while(left < right) {
			
			int area = Math.min(height[right], height[left]) * (right - left);
			if(area > max) {
				max = area;
			}
			
			if(height[right] <= height[left]) {
				right--;
			} else {
				left++;
			}
			
		}
		
		return max;
	}

}
