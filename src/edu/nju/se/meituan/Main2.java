package edu.nju.se.meituan;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
	
	public static void main(String[] args) {
		new Main2().func();
	}

	private void func() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		sc.nextLine();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		System.out.println(getNum(arr,x));
	}

	private int getNum(int[] arr, int x) {
		int max = 0;
		
		int[][] na = new int[2][arr.length];
		na[0] = arr;
		for(int i=0; i<arr.length; i++) {
			na[1][i] = arr[i] | x;
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			if(!list.contains(Integer.valueOf(na[0][i]))) {
				list.add(Integer.valueOf(na[0][i]));
			}
			if(!list.contains(Integer.valueOf(na[1][i]))) {
				list.add(Integer.valueOf(na[1][i]));
			}
		}
		
		for(Integer tmp : list) {
			int num = 0;
			for(int i=0; i<arr.length; i++) {
				if(na[0][i] == tmp || na[1][i] == tmp) {
					num++;
				}
			}
			if(num > max) {
				max = num;
			}
		}
		
		return max;
	}

}
