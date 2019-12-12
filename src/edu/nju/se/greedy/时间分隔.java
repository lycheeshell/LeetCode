package edu.nju.se.greedy;

import java.util.*;

public class 时间分隔 {

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
		Arrays.sort(arr);
		Arrays.sort(dep);

		int result = 0;
		int need = 1;

		int i = 1;
		int j = 0;

		while (i < arr.length && j < dep.length) {
			if(arr[i] <= dep[j]) {
				need += 1;
				i++;
				if(need > result) {
					result = need;
				}
			} else {
				need -= 1;
				j++;
			}
		}

		return result;
	}

}
