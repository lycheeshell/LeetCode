package edu.nju.se.algorithm.exam;

import java.util.*;

class Main_3_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int p = 0; p < t; p++) {

			int n = scanner.nextInt();
			int m = scanner.nextInt();
			scanner.nextLine();
			
			int[] arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = scanner.nextInt();
			}
			scanner.nextLine();
			int[] did = new int[m];
			for(int i=0; i<m; i++) {
				did[i] = scanner.nextInt();
			}
			
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<m; i++) {
				
				int count = 0;
				for(int j=0; j<n; j++) {
					if(arr[j] % did[i] == 0) {
						count++;
					}
				}
				
				sb.append(count + " ");
				
			}
			
			sb.deleteCharAt(sb.length()-1);
			
			System.out.println(sb.toString());
			
			
			if(scanner.hasNextLine()) {
				scanner.nextLine();
			}
			
		}
		scanner.close();
	}

}
