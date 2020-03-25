package edu.nju.se.hot100;

import java.util.*;

/**
 * 二叉树的中序遍历
 * 
 * @author zongk
 *
 */
public class Solution_094 {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		middleIntera(root, res);
		return res;
	}
	
	private void middleIntera(TreeNode node, List<Integer> res) {
		if(node == null) {
			return;
		}
		middleIntera(node.left, res);
		res.add(node.val);
		middleIntera(node.right, res);
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
