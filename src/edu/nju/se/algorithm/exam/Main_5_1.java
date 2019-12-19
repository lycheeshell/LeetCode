package edu.nju.se.algorithm.exam;

import java.util.*;

/**
 * 管道网络
 * 
 * @author zongk
 *
 */
class Main_5_1 {

	// number of houses and number
	// of pipes
	static int n, p;

	// Array rd stores the
	// ending vertex of pipe
	static int rd[] = new int[1100];

	// Array wd stores the value
	// of diameters between two pipes
	static int wt[] = new int[1100];

	// Array cd stores the
	// starting end of pipe
	static int cd[] = new int[1100];

	// arraylist a, b, c are used
	// to store the final output
	static List<Integer> a = new ArrayList<Integer>();

	static List<Integer> b = new ArrayList<Integer>();

	static List<Integer> c = new ArrayList<Integer>();

	static int ans;

	static int dfs(int w) {
		if (cd[w] == 0)
			return w;
		if (wt[w] < ans)
			ans = wt[w];

		return dfs(cd[w]);
	}

	// Function to perform calculations.
	static void solve(int arr[][]) {
		int i = 0;

		while (i < p) {

			int q = arr[i][0];
			int h = arr[i][1];
			int t = arr[i][2];

			cd[q] = h;
			wt[q] = t;
			rd[h] = q;
			i++;
		}

		a = new ArrayList<Integer>();
		b = new ArrayList<Integer>();
		c = new ArrayList<Integer>();

		for (int j = 1; j <= n; ++j)

			/*
			 * If a pipe has no ending vertex but has starting vertex i.e is an outgoing
			 * pipe then we need to start DFS with this vertex.
			 */
			if (rd[j] == 0 && cd[j] > 0) {
				ans = 1000000000;
				int w = dfs(j);

				// We put the details of
				// component in final output
				// array
				a.add(j);
				b.add(w);
				c.add(ans);
			}

		System.out.println(a.size());

		for (int j = 0; j < a.size(); ++j)
			System.out.println(a.get(j) + " " + b.get(j) + " " + c.get(j));
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int k = 0; k < t; k++) {

			rd = new int[1100];
            wt = new int[1100];
            cd = new int[1100];

            String[] s = scanner.nextLine().split(" ");
            n = Integer.parseInt(s[0]);
            p = Integer.parseInt(s[1]);
            int[][] arr = new int[p][3];
            for (int i = 0; i < p; i++) {
                String[] pipes = scanner.nextLine().split(" ");
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(pipes[j]);
                }
            }

			solve(arr);
		}
		scanner.close();
	}

}
