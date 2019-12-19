package edu.nju.se.algorithm.exam;

import java.util.*;

class Main_2_3 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		for(int i=0; i<t; i++) {
			
			int k = s.nextInt();
			int n = s.nextInt();
			s.nextLine();
			int[] arr = new int[n];
			for(int j=0; j<n; j++) {
				arr[j] = s.nextInt();
			}
			
			System.out.println(findMax(arr, n, k));
			
			if(s.hasNextLine()) {
				s.nextLine();
			}
		}
        s.close();
	}
	
	// function to calculate sum between two indices 
	// in array 
	static int sum(int arr[], int from, int to) 
	{ 
	    int total = 0; 
	    for (int i = from; i <= to; i++) 
	        total += arr[i]; 
	    return total; 
	} 
	   
	// bottom up tabular dp 
	static int findMax(int arr[], int n, int k) 
	{ 
	    // initialize table 
	    int dp[][] = new int[k+1][n+1]; 
	   
	    // base cases 
	    // k=1 
	    for (int i = 1; i <= n; i++) 
	        dp[1][i] = sum(arr, 0, i - 1); 
	   
	    // n=1 
	    for (int i = 1; i <= k; i++) 
	        dp[i][1] = arr[0]; 
	   
	    // 2 to k partitions 
	    for (int i = 2; i <= k; i++) { // 2 to n boards 
	        for (int j = 2; j <= n; j++) { 
	   
	            // track minimum 
	            int best = Integer.MAX_VALUE; 
	   
	            // i-1 th separator before position arr[p=1..j] 
	            for (int p = 1; p <= j; p++)  
	                best = Math.min(best, Math.max(dp[i - 1][p], 
	                              sum(arr, p, j - 1)));        
	   
	            dp[i][j] = best; 
	        } 
	    } 
	   
	    // required 
	    return dp[k][n]; 
	} 
	
//	public static int paint(int[] arr, int start,int end, int k) {
//		
//		if(k == 1) {
//			int sum = 0;
//			for(int i=start; i<=end; i++) {
//				sum += arr[i];
//			}
//			return sum;
//		}
//		
//		if((end - start + 1) <= k) {
//			int max = Integer.MIN_VALUE;
//			for(int i=start; i<=end; i++) {
//				if(arr[i] > max) {
//					max = arr[i];
//				}
//			}
//			return max;
//		}
//		
//		int min = Integer.MAX_VALUE;
//        for(int i = start; i <= end  + 1 - k; i++){
//            int sum = 0;
//            for(int j = start; j <= i; j++){
//                sum += arr[j];
//            }
//            int larger = sum > paint(arr,i + 1, end,k - 1) ? sum : paint(arr,i + 1, end,k - 1);
//            if(larger < min){
//                min = larger;
// 
//            }
//        }
//        return min;
//	}

}
