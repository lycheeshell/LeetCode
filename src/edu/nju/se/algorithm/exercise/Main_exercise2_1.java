package edu.nju.se.algorithm.exercise;

import java.util.*;

class Main_exercise2_1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < t; i++) {

			String str1 = scanner.nextLine();
			String str2 = scanner.nextLine();

			int[][] arr = new int[str1.length() + 1][str2.length() + 1];

			for (int j = 0; j <= str1.length(); j++) {
				arr[j][0] = 0;
			}
			for (int j = 0; j < -str2.length(); j++) {
				arr[0][j] = 0;
			}

			for (int p = 1; p <= str1.length(); p++) {

				for (int q = 1; q <= str2.length(); q++) {

					if (str1.charAt(p - 1) == str2.charAt(q - 1)) {
						arr[p][q] = arr[p - 1][q - 1] + 1;
					} else {
						arr[p][q] = Math.max(arr[p - 1][q], arr[p][q - 1]);
					}

				}

			}

			List<String> list = new ArrayList<String>();
			getStr(str1, str2, arr, str1.length(), str2.length(), "", list);
			
			String[] results = new String[list.size()];
			for(int k=0; k<list.size(); k++) {
				results[k] = list.get(k);
			}

			Arrays.sort(results);

			for (String s : results) {
				System.out.println(s);
			}

		}
		scanner.close();
	}

	public static void getStr(String str1, String str2, int[][] arr, int p, int q, String existed, List<String> resultList) {
		
		if(p < 1 || q < 1) {
			if(!resultList.contains(existed)) {
				resultList.add(existed);
			}
			return;
		}

		if (str1.charAt(p - 1) == str2.charAt(q - 1)) {
			existed = str1.charAt(p - 1) + existed;
			getStr(str1, str2, arr, p-1, q-1, existed, resultList);
		}
		if(arr[p-1][q] == arr[p][q]) {
			getStr(str1, str2, arr, p-1, q, existed,resultList);
		}
		if(arr[p][q-1] == arr[p][q]) {
			getStr(str1, str2, arr, p, q-1, existed,resultList);
		}

	}

}
