package edu.nju.se.algorithm.dp;

import java.util.*;

public class 按照要求保留数组元素使得和最大 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for(int p=0; p<t; p++) {
			int n = scanner.nextInt();
			scanner.nextLine();
			
			int[] arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = scanner.nextInt();
			}
			
			System.out.println(getSum(arr));
			
			if(scanner.hasNextLine()) {
				scanner.nextLine();
			}
		}
		
		scanner.close();
	}
	
	public static int getSum(int[] arr) {
		Arrays.sort(arr);
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i : arr) {
			list.add(i);
		}
		
		int sum = 0;
		
		while(list.size() > 0) {
			int max = list.get(list.size()-1);
			sum += max;
			list.remove(Integer.valueOf(max));
			if(list.contains(Integer.valueOf(max-1))) {
				list.remove(Integer.valueOf(max-1));
			}
		}
		
		return sum;
		
	}

}
