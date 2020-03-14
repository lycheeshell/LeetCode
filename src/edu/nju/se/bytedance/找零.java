package edu.nju.se.bytedance;

import java.util.Scanner;

public class 找零 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		sc.close();
		
		num = 1024 - num;
		
		int res = 0;
		int[] arr = {64,16,4,1};
		
		for(int i=0; i<arr.length; i++) {
			int coin = arr[i];
			res += num / coin;
			num = num % coin;
		}
		System.out.println(res);
	}

}
