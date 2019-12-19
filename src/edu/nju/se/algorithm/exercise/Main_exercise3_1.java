package edu.nju.se.algorithm.exercise;

import java.util.*;

/**
 * 分配问题
 * 
 * @author zongk
 *
 */
class Main_exercise3_1 {

	static int min;

	static List<List<Integer>> res;

	static int[][] cost;

	static boolean[] visited;

	static int n;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < t; i++) {

			String line = scanner.nextLine();
			n = Integer.parseInt(line);
			
			min = Integer.MAX_VALUE;
			cost = new int[n][n];
			visited = new boolean[n];
			res = new ArrayList<List<Integer>>();
//			for (int p = 0; p < n; p++) {
//				for (int q = 0; q < n; q++) {
//					cost[p][q] = Integer.MAX_VALUE;
//				}
//			}
			line = scanner.nextLine();
			String[] ones = line.split(",");
			for (String one : ones) {
				String[] info = one.split(" ");
				int person = Integer.parseInt(info[0]);
				int task = Integer.parseInt(info[1]);
				int spend = Integer.parseInt(info[2]);
				cost[person - 1][task - 1] = spend;
			}

			List<Integer> seq = new ArrayList<Integer>();
			getMin(0, 0, seq);
			
			Collections.sort(res, new Comparator<List<Integer>>() {

				@Override
				public int compare(List<Integer> o1, List<Integer> o2) {
					for(int k=0; k<o1.size(); k++) {
						if(o1.get(k) != o2.get(k)) {
							return o2.get(k) - o1.get(k);
						}
					}
					return 0;
				}
			});
			
			StringBuffer sb = new StringBuffer();
			for(List<Integer> list : res) {
				for(Integer k : list) {
					sb.append((k+1) + " ");
				}
				sb.deleteCharAt(sb.length() - 1);
				sb.append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb.toString());
		}
		scanner.close();
	}

	public static void getMin(int num, int sum, List<Integer> seq) {
		if (n == num) {
			if (sum < min) {
				min = sum;
				res.clear();
				res.add(seq);
			} else if (sum == min) {
				res.add(seq);
			}
		} else {
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					sum += cost[num][i];
					if (sum > min) {
						sum -= cost[num][i];
						continue;
					}
					visited[i] = true;
					List<Integer> newSeq = new ArrayList<Integer>();
					newSeq.addAll(seq);
					newSeq.add(i);
					getMin(num + 1, sum, newSeq);
					sum -= cost[num][i];
					visited[i] = false;
				}
			}
		}
	}

}
