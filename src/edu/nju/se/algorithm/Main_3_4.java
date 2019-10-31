package edu.nju.se.algorithm;

import java.util.*;

class Main_3_4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int p = 0; p < t; p++) {

			String str = scanner.nextLine();
			
			String[] sarr = str.split(",");
			
			String a = sarr[0];
			String b = sarr[1];
			
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<=a.length() - b.length(); i++) {
				if(a.substring(i, i + b.length()).equals(b)) {
					sb.append(i + " ");
				}
			}
			
			if(sb.length() == 0) {
				System.out.println();
			} else {
				sb.deleteCharAt(sb.length() - 1);
				
				System.out.println(sb.toString());
			}
			
		}
		scanner.close();
	}

}
