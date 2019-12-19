package edu.nju.se.algorithm.sort;

import java.util.*;

public class 实现Shell排序 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < t; i++) {

			String line = scanner.nextLine();
			String[] nums = line.split(" ");
			int[] arr = new int[nums.length];
			for (int j = 0; j < nums.length; j++) {
				arr[j] = Integer.parseInt(nums[j]);
			}
			line = scanner.nextLine();
			String[] gapstr = line.split(" ");
			int[] gaps = new int[gapstr.length];
			for (int j = 0; j < gapstr.length; j++) {
				gaps[j] = Integer.parseInt(gapstr[j]);
			}
			
			shellSort(arr, gaps);
			
			StringBuffer sb = new StringBuffer();
			for(int k : arr) {
				sb.append(k + " ");
			}
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb.toString());

		}
		scanner.close();
	}
	
	public static void shellSort(int[] arr, int[] gaps){
	    int temp;
	    for (int delta : gaps){
	        for (int i=delta; i<arr.length; i++){              
	            for (int j=i; j>=delta && arr[j]<arr[j-delta]; j-=delta){
	                temp = arr[j-delta];
	                arr[j-delta] = arr[j];
	                arr[j] = temp;
	            }
	        }
	    }
	}

}
