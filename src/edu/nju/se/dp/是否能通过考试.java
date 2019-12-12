package edu.nju.se.dp;

import java.util.*;

public class 是否能通过考试 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int p = 0; p < t; p++) {
			int n = scanner.nextInt();
			int time = scanner.nextInt();
			int score = scanner.nextInt();
			scanner.nextLine();
			
			int[][] arr = new int[n][2];
			for(int i=0; i<n; i++) {
				arr[i][0] = scanner.nextInt();
				arr[i][1] = scanner.nextInt();
				if(scanner.hasNextLine()) {
					scanner.nextLine();
				}
			}
			
			int[][] dp = new int[n+1][time+1];
			for(int i=0; i<time+1; i++) {
				dp[0][i] = 0;
			}
			for(int i=0; i<n+1; i++) {
				dp[i][0] = 0;
			}
			int minTime = Integer.MAX_VALUE;
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<time+1; j++) {
					if(arr[i-1][0] > j) {
						dp[i][j] = dp[i-1][j];
					} else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i-1][0]] + arr[i-1][1]);
					}
					if(dp[i][j] >= score) {
						minTime = Math.min(minTime, j);
					}
				}
			}
			if(dp[n][time] > score) {
				System.out.println("YES " + minTime);
			} else {
				System.out.println("NO");
			}
			
		}
		scanner.close();
	}

}
