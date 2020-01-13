package edu.nju.se.hot100;

import java.util.*;

/**
 * 组合总和
 * 
 * @author zongk
 *
 */
public class Solution_039 {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		Arrays.sort(candidates);
		
		if(candidates.length == 0 || candidates[0] > target) {
			return result;
		}
		
		int index = -1;
		for(int i=candidates.length-1; i>=0; i--) {
			if(candidates[i] <= target) {
				index = i;
				break;
			}
		}
		
		List<Integer> li = new ArrayList<Integer>();
		addNext(result, li, candidates, index, 0, target);
		
		
		
		
		return result;
	}
	
	public void addNext(List<List<Integer>> result, List<Integer> list, int[] candidates, int maxIndex, int sum, int target) {
		if(sum == target) {
			result.add(list);
			return;
		}
		if(sum > target) {
			return;
		}
		
		for(int i=maxIndex; i>=0; i--) {
			List<Integer> newList = new ArrayList<Integer>();
			newList.addAll(list);
			newList.add(candidates[i]);
			addNext(result, newList, candidates, i, sum+candidates[i], target);
		}
		
	}
	
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		List<List<Integer>> result = new Solution_039().combinationSum(candidates, target);
		for(List<Integer> list : result) {
			for(Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
