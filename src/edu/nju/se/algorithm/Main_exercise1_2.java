package edu.nju.se.algorithm;

import java.util.*;

class Main_exercise1_2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		for(int i=0; i<t; i++) {
			
			int n = s.nextInt();
			int m = s.nextInt();
			s.nextLine();
			
			int[][] arr = new int[n][m];
			
			for(int p=0; p<n; p++) {
				for(int q=0; q<m; q++) {
					arr[p][q] = s.nextInt();
				}
				if(s.hasNextLine()) {
					s.nextLine();
				}
			}
			
			int num = getNum(arr, 0, 0, n-1, m-1);
			
			System.out.println(num);
			
		}
        s.close();
	}
	
	public static int getNum(int[][] arr, int x1, int y1, int x2, int y2) {
		
		boolean allOne = true;
		for(int i=x1; i<=x2; i++) {
			for(int j=y1; j<=y2; j++) {
				if(arr[i][j] != 1) {
					allOne = false;
					j = y2 + 1;
					i = x2 + 1;
				}
			}
		}
		
		if(allOne) {
			return (x2 - x1 + 1) * (y2 - y1 + 1);
		} else {
			int[] subNums = {getNum(arr, x1+1, y1, x2, y2),
			                 getNum(arr, x1, y1+1, x2, y2),
			                 getNum(arr, x1, y1, x2-1, y2),
			                 getNum(arr, x1, y1, x2, y2-1)};
			Arrays.sort(subNums);
	        return subNums[subNums.length-1];
		}
		
	}
	
}
