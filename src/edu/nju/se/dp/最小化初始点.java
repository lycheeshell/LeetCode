package edu.nju.se.dp;

import java.util.*;

public class 最小化初始点 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = Integer.parseInt(scanner.nextLine());
		for(int p=0; p<t; p++) {
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			scanner.nextLine();
			int[][] arr = new int[row][col];
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					arr[i][j] = scanner.nextInt();
				}
			}
			if(scanner.hasNextLine()) {
				scanner.nextLine();
			}
			int[][] dp = new int[row][col];
			dp[row-1][col-1] = arr[row-1][col-1] > 0 ? 1 : 1 - arr[row-1][col-1];
			for(int i=row-2; i>=0; i--) {
				dp[i][col-1] = dp[i+1][col-1] - arr[i][col-1] > 0 ? dp[i+1][col-1] - arr[i][col-1] : 1;
			}
			for(int i=col-2; i>=0; i--) {
				dp[row-1][i] = dp[row-1][i+1] - arr[row-1][i] > 0 ? dp[row-1][i+1] - arr[row-1][i] : 1;
			}
			for(int i=row-2; i>=0; i--) {
				for(int j=col-2; j>=0; j--) {
					int num = Math.min(dp[i+1][j], dp[i][j+1]);
					dp[i][j] = Math.max(num - arr[i][j], 1);
				}
			}
			
			System.out.println(dp[0][0]);
			
		}
		scanner.close();
	}

}
