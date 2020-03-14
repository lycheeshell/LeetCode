package edu.nju.se.bytedance;

import java.util.Scanner;

public class 机器人跳跃问题 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		double res = 0;
		for(int i=0; i<n; i++) {
			res += arr[i] / Math.pow(2, i+1);
		}
		int val = (int) Math.ceil(res);
		
		System.out.println(val);
	}

}
