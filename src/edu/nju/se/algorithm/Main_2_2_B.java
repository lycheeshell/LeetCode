package edu.nju.se.algorithm;

import java.util.*;

/*
 * runtime error
 * 循环代替递归
 */
class Main_2_2_B {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		for (int i = 0; i < t; i++) {

			int n = s.nextInt();
			s.nextLine();
			double[] arr = new double[n];
			for (int j = 0; j < n; j++) {
				arr[j] = s.nextDouble();
			}

			StringBuilder sb = new StringBuilder();
			for (int k = 0; k <= n - 2; k++) {
				sb.append(getNum(arr, arr[k], arr[k + 1], k)).append(" ");
			}
			sb.deleteCharAt(sb.length() - 1);

			System.out.println(sb.toString());

			if (s.hasNextLine()) {
				s.nextLine();
			}

		}
		s.close();
	}

	public static String getNum(double[] arr, double start, double end, int k) {

		double leftsum = 0;
		double rightsum = 0;
		
		double middle = (start + end) / 2.0;

		for (int i = 0; i <= k; i++) {
			leftsum += 1.0 / (middle - arr[i]);
		}
		for(int i = arr.length-1; i>=k+1; i--) {
			rightsum += 1.0 / (arr[i] - middle);
		}
		
		if(Math.abs(rightsum - leftsum) < 0.0000000000001) {
			return String.format("%.2f", middle);
		}
		if(leftsum < rightsum) {
			return getNum(arr, start, middle, k);
		} else {
			return getNum(arr, middle, end, k);
		}

	}
}
