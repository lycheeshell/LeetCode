package edu.nju.se.hot100;

/**
 * 二叉树的最大深度
 * 
 * @author lycheeshell
 * @Date 2020-08-09
 */
public class Solution_104 {
	
	public int maxDepth(TreeNode root) {
		return getSubMax(root);
    }
	
	private int getSubMax(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(getSubMax(node.left), getSubMax(node.right));
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
