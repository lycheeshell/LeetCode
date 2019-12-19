package edu.nju.se.algorithm.sort;

import java.util.*;

public class 非递归快排 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			String ss = scanner.nextLine();

			if (ss == null || ss.length() == 0) {
				break;
			}

			String[] arrNormal = ss.split(" ");

			int[] arr = new int[arrNormal.length - 1];

			for (int j = 1; j < arrNormal.length; j++) {
				arr[j - 1] = Integer.parseInt(arrNormal[j]);
			}

			quickSort(arr);

			StringBuilder sb = new StringBuilder();
			for (int n : arr) {
				sb.append(n + " ");
			}
			sb.deleteCharAt(sb.length() - 1);

			System.out.println(sb.toString());
		}

		scanner.close();
	}

	public static void quickSort(int[] a) {
		//创建类保存开始结束索引

		//创建list 模拟栈，先入后出
		LinkedList<int[]> stack = new LinkedList<>();
		//加入初始数据，第一次执行
		stack.addFirst(new int[] { 0, a.length - 1 });
		//循环执行栈内的数据，直至排序完成
		while (!stack.isEmpty()) {
			int[] tuple = stack.removeFirst();
			int start = tuple[0], end = tuple[1], i = tuple[0], j = tuple[1];

			while (j > i) {
				// 从右边开始找到一个小于第0 位数的数，也可能找不到
				while (j > i && a[j] > a[start]) {
					j--;
				}
				// 从左边查找第一个大于第 0 位的数，也可能找不到
				while (j > i && a[i] <= a[start]) {
					i++;
				}
				// i j 不是同一个数就交换，找不到的情况下 i j 是一样的，这是就不用交换了
				if (j > i) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
			if (start != i) {
				int temp = a[start];
				a[start] = a[i];
				a[i] = temp;
			}

			if (i - 1 > start) {
				stack.addFirst(new int[] { 0, i - 1 });
			}
			if (j + 1 < end) {
				stack.addFirst(new int[] { j + 1, end });
			}

		}

	}

}
