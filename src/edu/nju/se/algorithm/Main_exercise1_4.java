package edu.nju.se.algorithm;

import java.util.*;

class Main_exercise1_4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		for(int i=0; i<t; i++) {
			
			int n = s.nextInt();
			
			int num = getNum(n, 1, 2, 3);
			
			System.out.println(num);
			
			if(s.hasNextLine()) {
				s.nextLine();
			}
		}
        s.close();
	}
	
	public static int getNum(int n, int p1, int p2, int p3) {
		if(n==1) {
			if(p1 == 2 || p3 == 2) {
				return 1;
			} else {
				return 2;
			}
		}
		else{
			if(p1 == 2 || p3 == 2) {
				return getNum(n-1, p1, p3, p2) + 1 + getNum(n-1, p2, p1, p3);
			} else {
				return getNum(n-1, p1, p3, p2) + getNum(n-1, p2, p1, p3) + 1 + getNum(n-1, p3, p1, p2) + 
						getNum(n-1, p2, p3, p1) + 1 + getNum(n-1, p1, p3, p2) + getNum(n-1, p2, p1, p3);
			}
		}
	}
	
}
