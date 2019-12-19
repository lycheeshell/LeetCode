package edu.nju.se.algorithm.dp;

import java.util.*;

public class 无重复字符子集问题 {
	
	static int max;
	static int sum;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for(int p=0; p<t; p++) {
			int n = Integer.parseInt(scanner.nextLine());
			n = n+1; // useless
			String[] arr = scanner.nextLine().split(" ");
			
			max = Integer.MIN_VALUE;
			sum = 0;
			List<String> contains = new ArrayList<String>();
			
			getMax(arr, contains);
			
			System.out.println(max);
		}
		scanner.close();
	}
	
	public static void getMax(String[] arr, List<String> contains) {
		for(String a : arr) {
			boolean same = false;
			for(String s : contains) {
				if(containsSame(s, a)) {
					same = true;
					break;
				}
			}
			if(!same) {
				sum += Integer.parseInt(a);
				if(sum > max) {
					max = sum;
				}
				contains.add(a);
				String[] newarr = new String[arr.length-1];
				int index = 0;
				for(String temp : arr) {
					if(!temp.equals(a)) {
						newarr[index] = temp;
						index++;
					}
				}
				getMax(newarr, contains);
				contains.remove(a);
				sum -= Integer.parseInt(a);
			}
		}
	}
	
	public static boolean containsSame(String a, String b) {
		for(int i=0; i<=9; i++) {
			if(a.contains("" + (char)('0' + i)) && b.contains("" + (char)('0' + i))) {
				return true;
			}
		}
		return false;
	}

}
