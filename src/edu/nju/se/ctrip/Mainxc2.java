package edu.nju.se.ctrip;

import java.util.*;

public class Mainxc2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();

		int m = scanner.nextInt(); // life time
		scanner.nextLine();
		
		int p = scanner.nextInt();
		scanner.nextLine();
		
		int[] birth = new int[p];
		for(int i=0; i<p;i++) {
			birth[i] = scanner.nextInt();
			scanner.nextLine();
		}
		
		int x = scanner.nextInt();
		
		int[] ages = new int[m+1];
		ages[0] = 1;
		
		for(int k=0; k<x; k++) {
			for(int i=m; i>0; i--) {
				ages[i] = ages[i-1];
			}
			ages[0] = 0;
			for(int bir : birth) {
				ages[0] = ages[0] + ages[bir];
			}
		}
		
		int res = 0;
		for(int i=0; i<=m; i++) {
			res += ages[i];
		}
		res = res * n;

		System.out.println(res);
		scanner.close();
	}
	
}
