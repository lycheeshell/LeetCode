package edu.nju.se.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的右视图
 * 
 * @author zongk
 *
 */
public class Solution_199 {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		
		if(root == null) {
			return res;
		}
		
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(root);
		
		while(list!=null && list.size() > 0) {
			res.add(list.get(0).val);
			List<TreeNode> tmp = new ArrayList<>();
			for(TreeNode node : list) {
				if(node.right != null) {
					tmp.add(node.right);
				}
				if(node.left != null) {
					tmp.add(node.left);
				}
			}
			list = tmp;
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
