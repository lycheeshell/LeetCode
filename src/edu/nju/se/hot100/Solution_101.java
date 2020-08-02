package edu.nju.se.hot100;

/**
 * 对称二叉树
 * 
 * @author lycheeshell
 * @Date 2020-08-02
 */
public class Solution_101 {

	public boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}
	
	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if(left == null && right != null) {
			return false;
		} else if(left != null && right == null) {
			return false;
		} else if(left == null && right == null) {
			return true;
		}
		if(left.val != right.val) {
			return false;
		}
		return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
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
