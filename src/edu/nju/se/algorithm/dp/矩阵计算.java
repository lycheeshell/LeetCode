package edu.nju.se.algorithm.dp;

import java.util.*;

public class 矩阵计算 {

	//loop: 0 0 1 1 1 0 1
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = Integer.parseInt(scanner.nextLine());
		int[] arr = {0,0,1,1,1,0,1};
		for(int p=0; p<t; p++) {
			int n = Integer.parseInt(scanner.nextLine());
			
			int count = 0;
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(arr[(int) (Math.pow((i%7) * (j%7), 3) % 7)] == 1) {
						count++;
					}
				}
			}
			System.out.println(count);
		}
		
		scanner.close();
	}

}
