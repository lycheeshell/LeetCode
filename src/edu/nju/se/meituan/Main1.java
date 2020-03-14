package edu.nju.se.meituan;

import java.util.Scanner;

public class Main1 {
	
	public static void main(String[] args) {
		new Main1().func();
	}

	private void func() {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		char[][] arr = new char[2][n];
		arr[0] = sc.nextLine().toCharArray();
		arr[1] = sc.nextLine().toCharArray();
		
		sc.close();
		
		System.out.println(getNum(arr));
	}

	private long getNum(char[][] arr) {
		if(arr[1].length <= 1) {
			return -1;
		}
		if(arr[0][0] == 'X') {
			return -1;
		}
		if(arr[1][arr[1].length-1] == 'X') {
			return -1;
		}
		long num = 1L;
		for(int i=1; i<arr[1].length-1; i++) {
			int pointNum = 2;
			if(arr[0][i] == 'X') {
				pointNum -= 1;
			}
			if(arr[1][i] == 'X') {
				pointNum -= 1;
			}
			
			if(pointNum == 0) {
				return -1;
			} else {
				num = num * pointNum;
			}
		}
		return num;
	}

}
