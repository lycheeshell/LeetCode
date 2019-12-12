package edu.nju.se.str;

import java.util.*;

public class 能否成环 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		scanner.nextLine();
		for(int tc=0; tc<t; tc++) {
			scanner.nextLine();
			String[] sarr = scanner.nextLine().split(" ");
			List<String> list = new ArrayList<String>();
			for(String s : sarr) {
				list.add(s);
			}
			
			boolean res = isCircle(list);
			if(res) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
			
		}
		scanner.close();
	}
	
	public static boolean isCircle(List<String> list) {
		if(list.size() == 1) {
			String one = list.get(0);
			if(one.charAt(0) == one.charAt(one.length()-1)) {
				return true;
			} else {
				return false;
			}
		}
		for(int i=1; i<list.size(); i++) {
			if(list.get(i).charAt(0) == list.get(0).charAt(list.get(0).length()-1)) {
				String newStr = list.get(0) + list.get(i);
				List<String> newList = new ArrayList<String>();
				newList.addAll(list);
				newList.remove(list.get(0));
				newList.remove(list.get(i));
				newList.add(newStr);
				if(isCircle(newList)) {
					return true;
				}
			}
		}
		return false;
	}
	
}
