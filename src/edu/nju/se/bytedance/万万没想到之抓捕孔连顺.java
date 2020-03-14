package edu.nju.se.bytedance;

import java.util.Scanner;

public class 万万没想到之抓捕孔连顺 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int d = scanner.nextInt();
		scanner.nextLine();
		
		int[] arr = new int[n];
		for(int r=0; r<n; r++) {
			arr[r] = scanner.nextInt();
		}
		
		long num = 0;
		
		int left = 0, right = 2;
        while (right < n) {
            if (arr[right] - arr[left] > d) left++;
            else if (right - left < 2) right++;
            else {
                num += calC(right - left);
                right++;
            }
        }
		
		System.out.println(num % 99997867);
		scanner.close();
	}

	private static long calC(long num) {
        return num * (num - 1) / 2;
    }
}
