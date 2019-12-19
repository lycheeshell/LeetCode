package edu.nju.se.algorithm.exercise;

import java.util.*;

class Main_exercise1_1 {

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
			
			int num = s.nextInt();
			
			HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
			
			int outcome = getNum(map, arr, num, 0, arr.length-1);
			
			System.out.println(outcome);
			
			if(s.hasNextLine()) {
				s.nextLine();
			}
		}
        s.close();
	}
	
	public static int getNum(HashMap<Integer, ArrayList<Integer>> map, int[] arr, int num, int left, int right) {
		
		if(map.containsKey(left)) {
			if(map.get(left).contains(right)) {
				return 0;
			} else {
				map.get(left).add(right);
			}
		} else {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(right);
			map.put(left, list);
		}
		
		if(arr.length == 0) {
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i=left; i<=right; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		if(max - min > num) {
			return 1 + getNum(map, arr, num, left + 1, right) + getNum(map, arr, num, left, right - 1);
		} else {
			return 0;
		}
		
	}

}
