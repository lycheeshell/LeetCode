package edu.nju.se.algorithm;

import java.util.*;

/**
 * 深度优先遍历
 * 
 * @author zongk
 *
 */
class Main_exercise3_5 {
	
	static int max = -1;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < t; i++) {

			String firstLine = scanner.nextLine();
			String[] firstLineArr = firstLine.split(" ");
			int n = Integer.parseInt(firstLineArr[0]);
			if(n < 1) {
				System.out.println(0);
				continue;
			}
			String firstStr = firstLineArr[1];
			
			String secondLine = scanner.nextLine();
			String[] names = secondLine.split(" ");
			
			int index = -1;
			for(int j=0; j<names.length; j++) {
				if(names[j].equals(firstStr)) {
					index = j;
					break;
				}
			}
			
			int[][] arr = new int[n][n];
			for(int p=0; p<n; p++) {
				String newLine = scanner.nextLine();
				String[] sarr = newLine.split(" ");
				for(int q=1; q<=n; q++) {
					arr[p][q-1] = Integer.parseInt(sarr[q]);
				}
			}
			
			visited = new boolean[n];
			
			dfs(arr, index, 0);
			
			System.out.println(max);
			max = -1;
		}
		scanner.close();
	}
	
	public static void dfs(int[][] arr, int index, int layer) {
		visited[index] = true;
		layer += 1;
		if(layer > max) {
			max = layer;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(arr[index][i] > 0 && !visited[i]) {
				dfs(arr, i, layer);
			}
		}
		
		
	}
	
}
