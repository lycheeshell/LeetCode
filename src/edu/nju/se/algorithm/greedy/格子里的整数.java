package edu.nju.se.algorithm.greedy;

import java.util.*;

public class 格子里的整数 {
	
	static int result = Integer.MAX_VALUE;
	static int sum = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for(int p=0; p<t; p++) {
			int n = scanner.nextInt();
			scanner.nextLine();
			Node[][] arr = new Node[n][n];
			List<Node> list = new ArrayList<Node>();
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j] = new Node(scanner.nextInt());
					list.add(arr[i][j]);
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n-1; j++) {
					arr[i][j].addNext(arr[i][j+1]);
					arr[i][j+1].addNext(arr[i][j]);
				}
			}
			for(int j=0; j<n; j++) {
				for(int i=0; i<n-1; i++) {
					arr[i][j].addNext(arr[i+1][j]);
					arr[i+1][j].addNext(arr[i][j]);
				}
			}
			list.remove(arr[0][0]);
			sum += arr[0][0].val;
			dfs(arr[0][0], arr[n-1][n-1], list);
			
			System.out.println(result);
			sum = 0;
			result = Integer.MAX_VALUE;
			
			if(scanner.hasNextLine()) {
				scanner.nextLine();
			}
		}
		
		scanner.close();
	}
	
	static void dfs(Node start, Node end, List<Node> list) {
		
		if(start == end) {
			if(sum < result) {
				result = sum;
			}
			return;
		}
		
		List<Node> next = start.next;
		for(Node n : next) {
			if(list.contains(n)) {
				sum += n.val;
				list.remove(n);
				dfs(n, end, list);
				list.add(n);
				sum -= n.val;
			}
		}
	}
	
	static class Node{
		int val;
		List<Node> next;
		
		public Node(int value) {
			this.val = value;
			next = new ArrayList<Node>();
		}
		
		public void addNext(Node n) {
			next.add(n);
		}
	}

	static void useDP(int[][] arr, int n) {
		int[][] dp = new int[n][n];
		dp[0][0] = arr[0][0];
		for(int i=1; i<n; i++) {
			dp[0][i] = dp[0][i-1] + arr[0][i];
			dp[i][0] = dp[i-1][0] + arr[i][0];
		}
		for(int i=1; i<n; i++) {
			for(int j=1; j<n; j++) {
				dp[i][j] = arr[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		System.out.println(dp[n-1][n-1]);
	}

}
