package edu.nju.se.dp;

import java.util.*;

public class 如何花最少的钱购买蔬菜 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int p = 0; p < t; p++) {

			int n = scanner.nextInt();
			scanner.nextLine();
			int[][] arr = new int[n][3];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 3; j++) {
					arr[i][j] = scanner.nextInt();
				}
				if (scanner.hasNextLine()) {
					scanner.nextLine();
				}
			}

			if (n <= 0) {
				System.out.println(0);
				continue;
			}

			int[][] dp = new int[n][3];
			for (int i = 0; i < 3; i++) {
				dp[0][i] = arr[0][i];
			}
			for (int i = 1; i < n; i++) {
				dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
				dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
				dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + arr[i][2];
			}

			int res = Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
			System.out.println(res);

		}

		scanner.close();

	}

}
