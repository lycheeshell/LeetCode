package edu.nju.se.sort;

import java.util.*;

public class 最小交换次数 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int tc = scanner.nextInt();
		scanner.nextLine();
		for (int t = 0; t < tc; t++) {
			int n = scanner.nextInt();
			scanner.nextLine();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scanner.nextInt();
			}

			System.out.println(minimumSwaps(arr));

			if (scanner.hasNextLine()) {
				scanner.nextLine();
			}
		}

		scanner.close();
	}

	public static int minimumSwaps(int[] arr) {
		int[] sorted = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			sorted[i] = arr[i];
		}
		Arrays.sort(sorted);
		
		int num = 0;
		
		for(int i=0; i<sorted.length; i++) {
			if(sorted[i] != arr[i]) {
				for(int j=i+1; j<arr.length; j++) {
					if(arr[j] == sorted[i]) {
						arr[j] = arr[i];
						arr[i] = sorted[i];
						num += 1;
						break;
					}
				}
			}
		}
		return num;
	}
}
