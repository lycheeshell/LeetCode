package edu.nju.se.algorithm;

import java.util.*;

/**
 * 时间分隔（最小站台）
 * 
 * @author zongk
 *
 */
class Main_5_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int p = 0; p < t; p++) {

			int n = scanner.nextInt();
			scanner.nextLine();

			int[] arr = new int[n];
			int[] dep = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scanner.nextInt();
			}
			scanner.nextLine();
			for (int i = 0; i < n; i++) {
				dep[i] = scanner.nextInt();
			}
			
			int result = findPlatform(arr, dep, n);
			
			System.out.println(result);

			if (scanner.hasNextLine()) {
				scanner.nextLine();
			}
		}
		scanner.close();
	}

	static int findPlatform(int arr[], int dep[], int n) {
		// Sort arrival and departure arrays
		Arrays.sort(arr);
		Arrays.sort(dep);

		// plat_needed indicates number of platforms
		// needed at a time
		int plat_needed = 1, result = 1;
		int i = 1, j = 0;

		// Similar to merge in merge sort to process
		// all events in sorted order
		while (i < n && j < n) {
			// If next event in sorted order is arrival,
			// increment count of platforms needed
			if (arr[i] <= dep[j]) {
				plat_needed++;
				i++;

				// Update result if needed
				if (plat_needed > result)
					result = plat_needed;
			}

			// Else decrement count of platforms needed
			else {
				plat_needed--;
				j++;
			}
		}

		return result;
	}

}
