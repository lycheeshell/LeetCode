package edu.nju.se.algorithm;

import java.util.*;

class Main_2_1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		for(int i=0; i<t; i++) {
			
			int a = s.nextInt();
			int b = s.nextInt();
			int c = s.nextInt();
			
			System.out.println(getNum(a,b,c));
			
			if(s.hasNextLine()) {
				s.nextLine();
			}
		}
        s.close();
	}
	
	public static int getNum(int a, int b, int c) {
		
		if(b == 1) {
			return a % c;
		}
//		if(b == 2) {
//			return (a * a) % c;
//		}
		
		if(b % 2 == 0) {
			return (getNum(a, b/2, c) * getNum(a, b/2, c)) % c;
		} else {
			return (getNum(a, (b-1)/2, c) * getNum(a, (b+1)/2, c)) % c;
		}
		
	}

}
