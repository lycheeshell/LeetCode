package edu.nju.se.hot100;

/**
 * 从前序与中序遍历序列构造二叉树
 * 
 * @author lycheeshell
 * @Date 2020-08-09
 */
public class Solution_105 {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || preorder.length == 0) {
			return null;
		}
		return getTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
	}

	private TreeNode getTree(int[] preorder, int[] inorder, 
			int preLeft, int preRight, int inLeft, int inRight) {
		if (preLeft > preRight) {
			return null;
		}
		if (preLeft == preRight) {
			return new TreeNode(preorder[preLeft]);
		}
		int nodeVal = preorder[preLeft];
		TreeNode node = new TreeNode(nodeVal);
		int newPreRight = preLeft;
		int newInRight = inLeft - 1;
		
		while(inorder[newInRight + 1] != nodeVal) {
			newInRight++;
			newPreRight++;
		}
		
		TreeNode left = getTree(preorder, inorder, preLeft + 1, newPreRight, inLeft, newInRight);
		TreeNode right = getTree(preorder, inorder, newPreRight + 1, preRight, newInRight + 2, inRight);
		node.left = left;
		node.right = right;
		return node;
	}
	
	public static void main(String[] args) {
		int[] pre = {3,9,20,15,7};
		int[] in = {9,3,15,20,7};
		new Solution_105().buildTree(pre, in);
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
