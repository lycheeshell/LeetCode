package edu.nju.se.ctrip;

import java.util.Arrays;
import java.util.Scanner;

public class Mainxc1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();

		int[] arr = new int[n];
		int[] dep = new int[n];
		for (int i = 0; i < n; i++) {
			String line = scanner.nextLine();
			String[] sa = line.split(",");
			arr[i] = Integer.parseInt(sa[0]);
			dep[i] = Integer.parseInt(sa[1]);
		}

		int result = find(arr, dep, n);

		System.out.println(result);
		scanner.close();
	}
	
	static int find(int arr[], int dep[], int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);

		int result = 0;
		int need = 1;

		int i = 1;
		int j = 0;

		while (i < arr.length && j < dep.length) {
			if(arr[i] < dep[j]) {
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
