package edu.nju.se.algorithm.str;

import java.util.*;

public class 对称子字符串 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		scanner.nextLine();
		for(int tc=0; tc<t; tc++) {
			String str = scanner.nextLine();
			int[] nums = new int[str.length()];
			for(int i=0; i<str.length(); i++) {
				nums[i] = Integer.parseInt(str.substring(i, i+1));
			}
			System.out.println(getMaxSubstring(nums));
		}
		scanner.close();
	}
	
	public static int getMaxSubstring(int[] nums) {
		int len = nums.length / 2 * 2;
		while(len > 0) {
			for(int i=0; i+len <= nums.length; i++) {
				
				int sum1 = 0;
				int sum2 = 0;
				
				for(int j=i; j<i+len/2; j++) {
					sum1 += nums[j];
				}
				for(int j=i+len/2; j<i+len; j++) {
					sum2 += nums[j];
				}
				
				if(sum1 == sum2) {
					return len;
				}
				
			}
			
			len -= 2;
		}
		return 0;
	}

}
