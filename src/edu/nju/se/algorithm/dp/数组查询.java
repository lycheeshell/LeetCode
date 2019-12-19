package edu.nju.se.algorithm.dp;

import java.util.*;

public class 数组查询 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for(int p=0; p<t; p++) {
			int n = scanner.nextInt();
			scanner.nextLine();
			
			int[] arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = scanner.nextInt();
			}
			
			System.out.println(maxSum(arr));
			
			if(scanner.hasNextLine()) {
				scanner.nextLine();
			}
		}
		
		scanner.close();
	}
	
	public static int maxSum(int[] arr) {
		int min = arr[0];
		for(int i : arr) {
			min = Math.min(i, min);
		}
		if(min >= 0) {
			int sum = 0;
			for(int i : arr) {
				sum += i;
			}
			return sum;
		}
		
		int result = min;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] < 0) {
				int[] a = new int[arr.length-1];
				int k = 0;
				for(int p=0; p<arr.length; p++) {
					if(p != i) {
						a[k++] = arr[p];
					}
				}
				
				int total = 0;
				
				for(int j=0; j<a.length; j++) {
					total += a[j];
					if(total > result) {
						result = total;
					}
					if(total < 0) {
						total = 0;
					}
				}
				
			}
		}
		
		return result;
		
	}


}
