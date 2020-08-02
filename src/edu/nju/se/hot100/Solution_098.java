package edu.nju.se.hot100;

/**
 * 验证二叉搜索树
 * 
 * @author lycheeshell
 * @Date 2020-08-02
 */
public class Solution_098 {

	public boolean isValidBST(TreeNode root) {
		if(root == null) {
			return true;
		}
		
		if(!(isValidBST(root.left) && isValidBST(root.right))) {
			return false;
		}
		TreeNode temp = root.left;
		while(temp != null) {
			if(temp.val >= root.val) {
				return false;
			}
			temp = temp.right;
		}
		temp = root.right;
		while (temp != null) {
			if (temp.val <= root.val) {
				return false;
			}
			temp = temp.left;
		}
		return true;
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
