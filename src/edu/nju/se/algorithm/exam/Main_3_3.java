package edu.nju.se.algorithm.exam;

import java.util.*;

class Main_3_3 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int p = 0; p < t; p++) {

			long n = scanner.nextLong();
			String s = "12345";
			
			if(n == 0) {
				System.out.println();
				if (scanner.hasNextLine()) {
					scanner.nextLine();
				}
				continue;
			}
			
			int i = getTimes(n);
			long sum = getAll(n);
			
			char c = getChar(s, sum, i, n);
			
			System.out.println(c);
			
			if (scanner.hasNextLine()) {
				scanner.nextLine();
			}

		}
		scanner.close();
	}

	public static int getTimes(long n) {
		
		int i = 1;

		long sum = 5;

		for (; sum < n; i++) {
			sum = sum + i + sum;
		}
//		System.out.println("i=" + (i-1));
		
		return i-1;

	}
	
	public static long getAll(long n) {
		
		int i = 1;

		long sum = 5;

		for (; sum < n; i++) {
			sum = sum + i + sum;
		}
//		System.out.println("sum=" + sum);
		return sum;

	}
	
	public static char getChar(String s, long sum, int i, long n) {
		
		while(true) {
			
			if(sum == 5) {
				return s.charAt((int)(n - 1));
			}
		
			sum = (sum - i) / 2;
			
			if(sum < n && n <= sum + i) {
				return '$';
			} else if(n > sum + i) {
				n = sum * 2 + i - n + 1;
				i--;
			} else {
				i--;
			}
			
		}
		
	}

}
