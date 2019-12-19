package edu.nju.se.algorithm.sort;

import java.util.*;

public class 冒泡排序 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String ss = scanner.nextLine();

		String[] arrNormal = ss.split(" ");

		int[] arr = new int[arrNormal.length - 1];

		for (int j = 1; j < arrNormal.length; j++) {
			arr[j - 1] = Integer.parseInt(arrNormal[j]);
		}

		bubbleSort(arr);

		StringBuilder sb = new StringBuilder();
		for (int n : arr) {
			sb.append(n + " ");
		}
		sb.deleteCharAt(sb.length() - 1);

		System.out.println(sb.toString());

		scanner.close();
	}

	public static void bubbleSort(int[] arr) {
		int temp = 0;
		boolean swap;
		for (int i = arr.length - 1; i > 0; i--) {
			swap = false;
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swap = true;
				}
			} // loop j
			if (swap == false) {
				break;
			}
		} // loop i
	}



}
