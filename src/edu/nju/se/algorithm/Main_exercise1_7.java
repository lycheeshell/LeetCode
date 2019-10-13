package edu.nju.se.algorithm;

import java.util.*;

class Main_exercise1_7 {
	
	static int maxLen = -1;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		for(int i=0; i<t; i++) {
			
			String sline = s.nextLine();
			String[] sarr = sline.split(" ");
			int[] arr = new int[sarr.length];
			for(int j=0; j<sarr.length; j++) {
				arr[j] = Integer.parseInt(sarr[j]);
			}
			
			List<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
			
			getArray(lists, arr);
			
			List<String> res = new ArrayList<String>();
			for(ArrayList<Integer> l : lists) {
				if(l.size() == maxLen) {
					StringBuilder sb = new StringBuilder();
					for(Integer k : l) {
						sb.append(k + " ");
					}
					sb.deleteCharAt(sb.length() - 1);
					if(!res.contains(sb.toString())) {
						res.add(sb.toString());
					}
					
				}
			}
			
			String[] result = new String[res.size()];
			for(int k=0; k<res.size(); k++) {
				result[k] = res.get(k);
			}
			Arrays.sort(result);
			for(String str : result) {
				System.out.println(str);
			}
			
			maxLen = -1;
			
		}
        s.close();
	}
	
	public static void getArray(List<ArrayList<Integer>> lists, int[] arr) {
		
		if(arr.length < maxLen) {
			return;
		}
		
		boolean right = true;
		int first = -1;
		int second = -1;
		for(int i=0; i<arr.length-1; i++) {
			if(first < 0 && arr[i] >= arr[i+1]) {
				first = i+1;
			} else if(first >=0 && arr[i] <= arr[i+1]) {
				second = i+1;
				right = false;
				break;
			}
		}
		
		if(right) {
			maxLen = arr.length;
			ArrayList<Integer> lis = new ArrayList<Integer>();
			for(int k : arr) {
				lis.add(k);
			}
			lists.add(lis);
		} else {
			
			int[] arr1 = new int[arr.length-1];
			int index1 = 0;
			for(int i=0; i<arr.length; i++) {
				if(second != i) {
					arr1[index1] = arr[i];
					index1++;
				}
			}
			getArray(lists, arr1);
			
			if((second >= 2 && arr[second] < arr[second-2]) || second == 1) {
				int[] arr3 = new int[arr.length-1];
				int index3 = 0;
				for(int i=0; i<arr.length; i++) {
					if(second-1 != i) {
						arr3[index3] = arr[i];
						index3++;
					}
				}
				getArray(lists, arr3);
			}
			
			
			int[] arr2 = new int[arr.length-1];
			int index2 = 0;
			for(int i=0; i<arr.length; i++) {
				if(first != i) {
					arr2[index2] = arr[i];
					index2++;
				}
			}
			getArray(lists, arr2);
			
			if((first >= 2 && arr[first] > arr[first-2]) || first == 1) {
				int[] arr4 = new int[arr.length-1];
				int index4 = 0;
				for(int i=0; i<arr.length; i++) {
					if(first-1 != i) {
						arr4[index4] = arr[i];
						index4++;
					}
				}
				getArray(lists, arr4);
			}
		}
		
	}
	
}
