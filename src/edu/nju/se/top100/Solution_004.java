package edu.nju.se.top100;

import java.util.Arrays;

/**
 * 寻找两个有序数组的中位数
 * 
 * @author zongk
 *
 */
public class Solution_004 {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
		int[] mix = new int[nums1.length + nums2.length];
		
		for(int i=0; i<nums1.length; i++) {
			mix[i] = nums1[i];
		}
		for(int i=0; i<nums2.length; i++) {
			mix[nums1.length + i] = nums2[i];
		}
		
		Arrays.sort(mix);
	
		int length = mix.length;
		
		return length % 2 == 0 ? (mix[length/2] + mix[length/2-1])/2.0 : mix[length/2];
    }

}
