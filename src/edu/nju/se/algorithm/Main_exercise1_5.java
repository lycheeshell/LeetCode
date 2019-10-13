package edu.nju.se.algorithm;

import java.util.*;

class Main_exercise1_5 {

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
			
			int a = s.nextInt();
			int b = s.nextInt();
			
			s.nextLine();
			int k = s.nextInt();
			
			int[] sub = new int[b-a+1];
			
			for(int j=a-1; j<=b-1; j++) {
				sub[j-a+1] = arr[j];
			}
			
			Arrays.sort(sub);
			
			System.out.println(sub[k-1]);
			
			if(s.hasNextLine()) {
				s.nextLine();
			}
		}
        s.close();
	}
	
}
