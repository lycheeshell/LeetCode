package edu.nju.se.greedy;

import java.util.*;

public class 路上的球 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		scanner.nextLine();
		for(int p=0; p<t; p++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			scanner.nextLine();
			int[] arr1 = new int[n];
			int[] arr2 = new int[m];
			for(int i=0; i<n; i++) {
				arr1[i] = scanner.nextInt();
			}
			scanner.nextLine();
			for(int i=0; i<m; i++) {
				arr2[i] = scanner.nextInt();
			}
			
			int i=0, j=0;
			int sum1=0, sum2=0;
			List<Integer> l1 = new ArrayList<Integer>();
			List<Integer> l2 = new ArrayList<Integer>();
			while(i<arr1.length && j<arr2.length) {
				if(arr1[i] == arr2[j]) {
					sum1 += arr1[i];
					sum2 += arr2[j];
					l1.add(sum1);
					l2.add(sum2);
					sum1 = sum2 = 0;
					i++;
					j++;
				} else if(arr1[i] < arr2[j]) {
					sum1 += arr1[i];
					i++;
				} else {
					sum2 += arr2[j];
					j++;
				}
			}
			while(i<arr1.length) {
				sum1 += arr1[i];
				i++;
			}
			l1.add(sum1);
			while(j<arr2.length) {
				sum2 += arr2[j];
				j++;
			}
			l2.add(sum2);
			
			int sum = 0;
			for(int k=0; k<l1.size(); k++) {
				sum += Math.max(l1.get(k), l2.get(k));
			}
			
			System.out.println(sum);
			
			if(scanner.hasNextLine()) {
				scanner.nextLine();
			}
		}
		scanner.close();
	}

}
