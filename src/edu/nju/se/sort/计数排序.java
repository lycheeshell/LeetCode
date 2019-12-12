package edu.nju.se.sort;

import java.util.Scanner;

public class 计数排序 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			String ss = scanner.nextLine();
			
			if(ss == null || ss.length() == 0) {
				break;
			}

			String[] arrNormal = ss.split(" ");

			int[] arr = new int[arrNormal.length - 1];

			for (int j = 1; j < arrNormal.length; j++) {
				arr[j - 1] = Integer.parseInt(arrNormal[j]);
			}

			arr = countSort(arr);

			StringBuilder sb = new StringBuilder();
			for (int n : arr) {
				sb.append(n + " ");
			}
			sb.deleteCharAt(sb.length() - 1);

			System.out.println(sb.toString());
		}

		scanner.close();
	}

	public static int[] countSort(int[] arr) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int num : arr) {
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		int[] count = new int[max - min + 1];
		for (int num : arr) {
			count[num - min]++;
		}
		int[] result = new int[arr.length];
		int index = 0;
		for (int i = 0; i < count.length; i++) {
			while (count[i] > 0) {
				result[index++] = i + min;
				count[i]--;
			}
		}
		return result;
	}

}
