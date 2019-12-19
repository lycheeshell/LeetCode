package edu.nju.se.algorithm.greedy;

import java.util.*;

class 硬币最小数量 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int p = 0; p < t; p++) {

			int n = scanner.nextInt();
			int amount = scanner.nextInt();
			scanner.nextLine();

			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scanner.nextInt();
			}

			Arrays.sort(arr);

			int result = minCoinDynamic(amount, arr);

			System.out.println(result);

			if (scanner.hasNextLine()) {
				scanner.nextLine();
			}
		}
		scanner.close();
	}
	
	public static int minCoinDynamic(int amount, int[] coins) {
		// this will store the optimal solution
		// for all the values -- from 0 to given amount.
		int[] coinReq = new int[amount + 1];

		coinReq[0] = 0; // 0 coins are required to make the change for 0
		// now solve for all the amounts
		for (int amt = 1; amt <= amount; amt++) {
			coinReq[amt] = Integer.MAX_VALUE;
			// Now try taking every coin one at a time and pick the minimum
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= amt && coinReq[amt - coins[j]] != -1) { // check if coin value is less than amount
					// select the coin and add 1 to solution of (amount-coin value)
					coinReq[amt] = Math.min(coinReq[amt - coins[j]] + 1, coinReq[amt]);
				}
			}
			if (coinReq[amt] == Integer.MAX_VALUE) {
				coinReq[amt] = -1;
			}
		}
		// return the optimal solution for amount
		return coinReq[amount];

	}

}
