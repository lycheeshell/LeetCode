package edu.nju.se.hot100;

/**
 * 不同的二叉搜索树
 * 
 * @author zongk
 *
 */
public class Solution_096 {

	public int numTrees(int n) {
		if (n <= 1)
			return 1;

		int[] G = new int[n + 1];
		G[0] = 1;
		G[1] = 1;

		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j <= i; ++j) {
				G[i] += G[j - 1] * G[i - j];
			}
		}
		return G[n];
	}

}
