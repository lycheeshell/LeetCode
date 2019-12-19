package edu.nju.se.algorithm.exercise;

import java.util.*;

class Main_exercise1_7 {

	static List<String> res = new ArrayList<>();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		for (int k = 0; k < t; k++) {

			String sline = s.nextLine();
			String[] sarr = sline.split(" ");
			int[] arr = new int[sarr.length];
			for (int j = 0; j < sarr.length; j++) {
				arr[j] = Integer.parseInt(sarr[j]);
			}

			for (int i = arr.length; i >= 0; i--) {
				combination(arr, 0, i, new ArrayList<>());
				if (res.size() != 0) {
					Collections.sort(res);
					for (String str : res) {
						System.out.println(str);
					}
					break;
				}
			}

			res = new ArrayList<String>();

		}
		s.close();
	}

	public static void combination(int[] arr, int begin, int left, List<Integer> list) {
		if (left == 0) {
			if (judge(list)) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < list.size(); i++) {
					sb.append(list.get(i) + " ");
				}
				sb.deleteCharAt(sb.length()-1);
				res.add(sb.toString());
			}
			return;
		}
		if ((arr.length - begin) > left) {
			List<Integer> copy = new ArrayList<>(list);
			combination(arr, begin + 1, left, list);
			copy.add(arr[begin]);
			combination(arr, begin + 1, left - 1, copy);
		} else if ((arr.length - begin) == left) {
			list.add(arr[begin]);
			combination(arr, begin + 1, left - 1, list);
		}
	}

	public static boolean judge(List<Integer> list) {
		int i = 0;
		while (i < list.size() - 1 && list.get(i + 1) >= list.get(i)) {
			i++;
		}
		while (i < list.size() - 1 && list.get(i + 1) <= list.get(i)) {
			i++;
		}
		return i == list.size() - 1;
	}

//	public static void getArray(List<ArrayList<Integer>> lists, int[] arr) {
//		
//		if(arr.length < maxLen) {
//			return;
//		}
//		
//		boolean right = true;
//		int first = -1;
//		int second = -1;
//		for(int i=0; i<arr.length-1; i++) {
//			if(first < 0 && arr[i] > arr[i+1]) {
//				first = i+1;
//			} else if(first >=0 && arr[i] < arr[i+1]) {
//				second = i+1;
//				right = false;
//				break;
//			}
//		}
//		
//		if(right) {
//			maxLen = arr.length;
//			ArrayList<Integer> lis = new ArrayList<Integer>();
//			for(int k : arr) {
//				lis.add(k);
//			}
//			lists.add(lis);
//		} else {
//			
//			int[] arr1 = new int[arr.length-1];
//			int index1 = 0;
//			for(int i=0; i<arr.length; i++) {
//				if(second != i) {
//					arr1[index1] = arr[i];
//					index1++;
//				}
//			}
//			getArray(lists, arr1);
//			
//			if((second >= 2 && arr[second] < arr[second-2]) || second == 1) {
//				int[] arr3 = new int[arr.length-1];
//				int index3 = 0;
//				for(int i=0; i<arr.length; i++) {
//					if(second-1 != i) {
//						arr3[index3] = arr[i];
//						index3++;
//					}
//				}
//				getArray(lists, arr3);
//			}
//			
//			
//			int[] arr2 = new int[arr.length-1];
//			int index2 = 0;
//			for(int i=0; i<arr.length; i++) {
//				if(first != i) {
//					arr2[index2] = arr[i];
//					index2++;
//				}
//			}
//			getArray(lists, arr2);
//			
//			if((first >= 2 && arr[first] > arr[first-2]) || first == 1) {
//				int[] arr4 = new int[arr.length-1];
//				int index4 = 0;
//				for(int i=0; i<arr.length; i++) {
//					if(first-1 != i) {
//						arr4[index4] = arr[i];
//						index4++;
//					}
//				}
//				getArray(lists, arr4);
//			}
//		}
//		
//	}

}
