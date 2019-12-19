package edu.nju.se.algorithm.sort;

import java.util.Scanner;

public class 插入排序 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < t; i++) {

			String ss = scanner.nextLine();

			String[] arrNormal = ss.split(" ");

			int[] arr = new int[arrNormal.length - 1];

			for (int j = 1; j < arrNormal.length; j++) {
				arr[j - 1] = Integer.parseInt(arrNormal[j]);
			}
			
			insertionSort(arr);
			
			StringBuilder sb = new StringBuilder();
			for(int n : arr) {
				sb.append(n + " ");
			}
			sb.deleteCharAt(sb.length()-1);
			
			System.out.println(sb.toString());

		}
		scanner.close();
	}

	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; ++i) {
			int value = arr[i];
			int position = i;
			while (position > 0 && arr[position - 1] > value) {
				arr[position] = arr[position - 1];
				position--;
			}
			arr[position] = value;
		}
	}

}
