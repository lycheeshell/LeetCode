package edu.nju.se.algorithm;

import java.util.*;

class Main_3_1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int p = 0; p < t; p++) {

			String s = scanner.nextLine();

			char c[] = s.toCharArray();
			int max = 0;
			for (int i = 0; i < s.length() - 1; i++) {
				int half = i;
				int sumh = c[i];
				int sumf = c[i] + c[i + 1];
				for (int j = i + 1; j < s.length(); j = j + 2) {
					if (sumh == sumf - sumh) {
						max = Math.max(max, (j - i + 1));
					}
					if (j + 2 < s.length()) {
						half++;
						sumh += c[half];
						sumf = sumf + c[j + 1] + c[j + 2];
					}

				}
			}
			System.out.println(max);
		}
		scanner.close();
	}

}
