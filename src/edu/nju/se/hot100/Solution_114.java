package edu.nju.se.hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树展开为链表
 * 
 * @author lycheeshell
 * @Date 2020-08-15
 */
public class Solution_114 {

	public void flatten(TreeNode root) {
		
		if (root == null) {
			return;
		}
		
		List<TreeNode> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
			node.left = null;
			node.right = null;
			res.add(node);
		}
		
		for(int i=0; i<res.size() - 1; i++) {
			res.get(i).right = res.get(i+1);
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
