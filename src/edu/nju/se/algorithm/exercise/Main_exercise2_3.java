package edu.nju.se.algorithm.exercise;

import java.util.*;

class Main_exercise2_3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < t; i++) {

			String ss = scanner.nextLine();
			
			String[] arrNormal = ss.split(" ");
			
			int k = Integer.parseInt(arrNormal[arrNormal.length-1]);
			
			String[] arr = new String[arrNormal.length-2];
			
			for(int j=1; j<arrNormal.length-1; j++) {
				arr[j-1] = arrNormal[j];
			}
			
			StringBuilder sb = new StringBuilder();
			
			int index = 0;
			while(index < arr.length) {
				
				if(index + k <= arr.length) {
					for(int a=index+k-1; a>=index; a--) {
						sb.append(arr[a] + " ");
					}
				} else {
					for(int a=index; a<arr.length; a++) {
						sb.append(arr[a] + " ");
					}
				}
				index += k;
				
			}
			
			sb.deleteCharAt(sb.length()-1);
			
			System.out.println(sb.toString());
			
		}
		scanner.close();
	}

}
