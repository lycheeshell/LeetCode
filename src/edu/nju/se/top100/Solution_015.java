package edu.nju.se.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 三数之和
 * 
 * @author zongk
 *
 */
public class Solution_015 {
	
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

	public List<List<Integer>> threeSum(int[] nums) {
		
		Arrays.sort(nums);
		
		getNum(nums, 0, nums.length-1);
		
		return result;
	}
	
	public void getNum(int[] nums, int left, int right) {
		
		if(right - left <= 1) {
			return;
		}
		if(nums[left] > 0 && nums[right] > 0) {
			return;
		}
		if(nums[left] < 0 && nums[right] < 0) {
			return;
		}
		
		int a = nums[left];
		int b = nums[right];
		
		int c = Integer.MAX_VALUE;
		for(int i=left+1; i<right; i++) {
			if(nums[i] + a + b == 0) {
				c = nums[i];
				break;
			}
		}
		if(c != Integer.MAX_VALUE && ((!map.containsKey(a)) || (map.containsKey(a) && !map.get(a).contains(b)) ) ) {
			List<Integer> one = new ArrayList<Integer>();
			one.add(a);
			one.add(c);
			one.add(b);
			result.add(one);
			if(map.containsKey(a)) {
				map.get(a).add(b);
			} else {
				List<Integer> oneList = new ArrayList<Integer>();
				oneList.add(b);
				map.put(a, oneList);
			}
			
		}
		
		int tempLeft = left;
		while(nums[tempLeft] == a && tempLeft < right) {
			tempLeft++;
		}
		getNum(nums, tempLeft, right);
		
		int tempRight = right;
		while(nums[tempRight] == b && tempRight > left) {
			tempRight--;
		}
		getNum(nums, left, tempRight);
		
		
	}
	
	public static void main(String[] args) {
		
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res = new Solution_015().threeSum(nums);
		
		for(List<Integer> list : res) {
			System.out.print("[");
			for(Integer i : list) {
				System.out.print(i + ",");
			}
			System.out.println("]");
		}
		
	}

}
