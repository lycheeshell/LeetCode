package edu.nju.se.algorithm.exam;

import java.util.*;

class Main_4_4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int p = 0; p < t; p++) {

			int n = scanner.nextInt();
			scanner.nextLine();

			int[][] arr = new int[n][3];

			for (int i = 0; i < n; i++) {
				String line = scanner.nextLine();
				String[] sarr = line.split(" ");
				for (int j = 0; j < 3; j++) {
					arr[i][j] = Integer.parseInt(sarr[j]);
				}
			}

			System.out.println(minCost(arr, n));

		}
		scanner.close();
	}

	public static int getMin(int arr[], int l, int h) {
		int res = Integer.MAX_VALUE;
		for (int i = l; i <= h; ++i)
			if (arr[i] < res)
				res = arr[i];
		return res;
	}

	public static int minCost(int arr[][], int n) {
		int dp[][] = new int[n][3];
		for (int i = 0; i < 3; ++i)
			dp[0][i] = arr[0][i];
		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < 3; ++j) {
				dp[i][j] = Math.min(getMin(dp[i - 1], 0, j - 1), getMin(dp[i - 1], j + 1, 2)) + arr[i][j];
			}
		}
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < 3; ++i)
			if (dp[n - 1][i] < res)
				res = dp[n - 1][i];
		return res;

	}

}
