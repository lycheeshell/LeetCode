package edu.nju.se.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1_2 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		for(int i=0; i<t; i++) {
			
			int n = s.nextInt();
			s.nextLine();
			
			int[] arr = new int[n];
			int[] arr2 = new int[n];
			
			for(int j=0; j<n; j++) {
				
				int a = s.nextInt();
				arr[j] = a;
				arr2[j] = a;
				
			}
			
			int num = 0;
			
			Arrays.sort(arr2);
			
			for(int k=0;k<n;k++) {
				
				while(arr[k] != arr2[k]) {
					
					int loca = -1;
					for(int q=0;q<arr2.length; q++) {
						if(arr2[q] == arr[k]) {
							loca = q;
							break;
						}
					}
					//swap
					int temp = arr[loca];
					arr[loca] = arr[k];
					arr[k] = temp;
					num++;
					
				}
				
			}
			
			System.out.println(num);
			
			
			if(s.hasNextLine()) {
				s.nextLine();
			}
		}
		s.close();
	}

}
