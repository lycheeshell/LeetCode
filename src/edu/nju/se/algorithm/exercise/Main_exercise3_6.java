package edu.nju.se.algorithm.exercise;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 广度优先遍历图
 * 
 * @author zongk
 *
 */
class Main_exercise3_6 {
	
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
			
			List<Integer> result = bfs(arr, index);
			
			StringBuffer sb = new StringBuffer();
			for(Integer num : result) {
				sb.append(names[num] + " ");
			}
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb.toString());
			
		}
		scanner.close();
	}
	
	public static List<Integer> bfs(int[][] arr, int index) {
		List<Integer> result = new ArrayList<Integer>();
		Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
		
		queue.add(index);
		while(!queue.isEmpty()) {
			int num = queue.poll();
			if(visited[num]) {
				continue;
			}
			visited[num] = true;
			result.add(num);
			for (int i=0; i<arr.length; i++) {
				if(arr[num][i] > 0 && !visited[i]) {
					queue.add(i);
				}
			}
		}
		return result;
	}
	
}
