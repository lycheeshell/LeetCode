package edu.nju.se.dp;

import java.util.*;

public class 订单问题 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for(int p=0; p<t; p++) {
			int n = scanner.nextInt();
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			scanner.nextLine();
			
			int[] fee1 = new int[n];
			int[] fee2 = new int[n];
			for(int i=0; i<n; i++) {
				fee1[i] = scanner.nextInt();
			}
			scanner.nextLine();
			for(int i=0; i<n; i++) {
				fee2[i] = scanner.nextInt();
			}
			if(scanner.hasNextLine()) {
				scanner.nextLine();
			}
			
			int[][] dp = new int[x+1][y+1];
			for(int i=1; i<=y; i++) {
				dp[i][0] = dp[i-1][0] + fee1[i-1];
			}
			for(int j=1; j<=y; j++) {
				dp[0][j] = dp[0][j-1] + fee2[j-1];
			}
			for(int i=1; i<=x; i++) {
				for(int j=1; j<=y; j++) {
					if(i+j <= n) {
						int sum1 = dp[i-1][j] + fee1[i+j-1];
						int sum2 = dp[i][j-1] + fee2[i+j-1];
						dp[i][j] = Math.max(sum1, sum2);
					} else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
			
			System.out.println(dp[x][y]);
			
		}
		
		scanner.close();
	}

}
