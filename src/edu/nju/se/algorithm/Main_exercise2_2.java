package edu.nju.se.algorithm;

import java.util.*;

class Main_exercise2_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < t; i++) {

			String ss = scanner.nextLine();
			
			String[] arrNormal = ss.split(" ");
			
			String[] arr = new String[arrNormal.length-1];
			
			for(int j=1; j<arrNormal.length; j++) {
				arr[j-1] = arrNormal[j];
			}
			
			int a = 0;
			int b = arr.length-1;
			
			boolean result = true;
			
			while(a<b) {
				if(!arr[a].equals(arr[b])) {
					result = false;
					break;
				}
				a++;
				b--;
			}
			
			System.out.println(result);
			
		}
		scanner.close();
	}

}
