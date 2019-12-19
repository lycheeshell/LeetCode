package edu.nju.se.algorithm.str;

import java.util.*;

public class 字符串匹配问题 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		scanner.nextLine();
		for(int tc=0; tc<t; tc++) {
			String[] all = scanner.nextLine().split(",");
			String txt = all[0];
			String pat = all[1];
			System.out.println(search(txt, pat));
		}
		scanner.close();
	}
	
	public static String search(String txt, String pat) {
		StringBuffer sb = new StringBuffer();
		int len = pat.length();
		for(int i=0; i<=txt.length()-pat.length(); i++) {
			if(pat.equals(txt.substring(i, i+len))) {
				sb.append(i + " ");
			}
		}
		if(sb.length() > 0) {
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}

}
