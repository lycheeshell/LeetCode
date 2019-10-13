package edu.nju.se.algorithm;

import java.util.*;

class Main_exercise1_6 {

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
			
			int n = s.nextInt();
			
			int num = 0;
			Arrays.sort(arr);
			
			int a=0, b=arr.length-1;
			
			while(a<b) {
				if(arr[a] + arr[b] > n) {
					b--;
				} else if(arr[a] + arr[b] == n) {
					a++;
					b--;
					num++;
				} else if(arr[a] + arr[b] < n) {
					a++;
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
