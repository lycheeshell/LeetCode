package edu.nju.se.hot100;

/**
 * 二叉树中的最大路径和
 * 
 * @author lycheeshell
 * @Date 2020-08-15
 */
public class Solution_124 {
	
	int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		maxSubNodeSum(root);
		return maxSum;
	}
	
	private int maxSubNodeSum(TreeNode node) {
		if(node == null) {
			return 0;
		}
		
		int left = maxSubNodeSum(node.left);
		int right = maxSubNodeSum(node.right);
		
		int nodeSum = node.val + left + right;
		maxSum = Math.max(maxSum, nodeSum);
		
		return Math.max(0, node.val + Math.max(left, right));
		
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
