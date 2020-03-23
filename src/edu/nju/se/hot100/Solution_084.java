package edu.nju.se.hot100;

public class Solution_084 {

	public int largestRectangleArea(int[] heights) {
		return maxArea(heights, 0, heights.length-1);
    }
	
	private int maxArea(int[] heights, int start, int end) {
		if(start > end) {
			return 0;
		}
		if(start == end) {
			return heights[start];
		}
		int minIndex = -1;
		int min = Integer.MAX_VALUE;
		for(int i=start; i<=end; i++) {
			if(heights[i] < min) {
				min = heights[i];
				minIndex = i;
			}
		}
		
		int area0 = min * (end - start + 1);
		int area1 = maxArea(heights, start, minIndex-1);
		int area2 = maxArea(heights, minIndex+1, end);
		return Math.max(area0, Math.max(area1, area2));
	}

}
