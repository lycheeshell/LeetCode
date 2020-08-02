package edu.nju.se.hot100;

import java.util.*;

/**
 * 二叉树的层序遍历
 * 
 * @author lycheeshell
 * @Date 2020-08-02
 */
public class Solution_102 {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) {
			return res;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(queue.size() > 0) {
			Queue<TreeNode> temp = new LinkedList<>();
			List<Integer> tempRes = new ArrayList<>();
			while(queue.size() > 0) {
				TreeNode node = queue.poll();
				tempRes.add(node.val);
				if (node.left != null) {
					temp.offer(node.left);
				}
				if (node.right != null) {
					temp.offer(node.right);
				}
			}
			res.add(tempRes);
			queue = temp;
			
		}
		return res;
		
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
