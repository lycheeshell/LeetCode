package edu.nju.se.hot100;

import java.util.*;

/**
 * 二叉树的序列化与反序列化
 * 
 * @author zongk
 *
 */
public class Solution_297 {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node != null) {
				sb.append(node.val + ",");
				queue.add(node.left);
				queue.add(node.right);
			}
			else {
				sb.append("null,");
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] sarr = data.split(",");
		int len = sarr.length;
		
		TreeNode root = null;
		if(sarr[0].equals("null")) {
			return root;
		} else {
			root = new TreeNode(Integer.parseInt(sarr[0]));
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int index = 1;
		while(index < len && !queue.isEmpty()) {
			TreeNode node = queue.poll();
			String leftStr = sarr[index];
			if(leftStr.equals("null")) {
				node.left = null;
			} else {
				TreeNode leftNode = new TreeNode(Integer.parseInt(sarr[index]));
				node.left = leftNode;
				queue.add(leftNode);
			}
			index++;
			String rightStr = sarr[index];
			if(rightStr.equals("null")) {
				node.right = null;
			} else {
				TreeNode rightNode = new TreeNode(Integer.parseInt(sarr[index]));
				node.right = rightNode;
				queue.add(rightNode);
			}
			index++;
		}
		return root;
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
