package edu.nju.se.hot100;

import java.util.*;

/**
 * 全排列
 * 
 * @author zongk
 *
 */

public class Solution_046 {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		doFunc(nums, new ArrayList<Integer>(), result);
		return result;
	}
	
	public void doFunc(int[] nums, List<Integer> now, List<List<Integer>> result) {
		if(nums == null || nums.length == 0) {
			result.add(now);
			return;
		}
		for(int i=0; i<nums.length; i++) {
			List<Integer> newList = new ArrayList<Integer>();
			newList.addAll(now);
			newList.add(nums[i]);
			int[] newNums = new int[nums.length-1];
			int index = 0;
			for(int j=0; j<nums.length; j++) {
				if(j != i) {
					newNums[index++] = nums[j];
				}
			}
			doFunc(newNums, newList, result);
		}
	}

}
