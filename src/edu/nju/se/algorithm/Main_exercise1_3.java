package edu.nju.se.algorithm;

import java.util.*;

class Main_exercise1_3 {

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
			
			int sum = 0;
			for(int k=0; k<=arr.length-num; k++) {
				
				int[] temp = new int[num];
				for(int q=0; q<num; q++) {
					temp[q] = arr[k+q];
				}
				Arrays.sort(temp);
				sum += temp[num-1];
				
			}
			System.out.println(sum);
			
			if(s.hasNextLine()) {
				s.nextLine();
			}
		}
        s.close();
	}
	
}
