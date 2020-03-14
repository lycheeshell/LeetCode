package edu.nju.se.bytedance;

import java.util.Scanner;

public class 万万没想到之聪明的编辑 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int t = scanner.nextInt();
		scanner.nextLine();
		for (int tc = 0; tc < t; tc++) {
			String str = scanner.nextLine();
			char[] arr = str.toCharArray();
			System.out.println(getRightstring(arr));
		}
		scanner.close();
	}

	private static String getRightstring(char[] arr) {
		StringBuilder sb = new StringBuilder();
		for(char c: arr) {
			if(sb.length() < 2) {
				sb.append(c);
				continue;
			}
			if(sb.length() >=2 ) {
				if(sb.charAt(sb.length()-1) == sb.charAt(sb.length()-2) && c == sb.charAt(sb.length()-1)) {
					continue;
				}
			}
			if(sb.length() >= 3) {
				if(sb.charAt(sb.length()-3) == sb.charAt(sb.length()-2) && c == sb.charAt(sb.length()-1)) {
					continue;
				}
			}
			sb.append(c);
		}
				
		return sb.toString();
	}

}
