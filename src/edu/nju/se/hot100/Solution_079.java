package edu.nju.se.hot100;

import java.util.ArrayList;

/**
 * 单词搜索
 * 
 * @author zongk
 *
 */
public class Solution_079 {

	public boolean exist(char[][] board, String word) {
		if(word.length() < 1) {
			return true;
		}
		int xlen = board.length;
		if(xlen < 1) {
			return false;
		}
		int ylen = board[0].length;
		
		ArrayList<Node> used = new ArrayList<>();
		for(int i=0; i<xlen; i++) {
			for(int j=0; j<ylen; j++) {
				if(board[i][j] == word.charAt(0)) {
					Node n = new Node(i, j);
					used.add(n);
					boolean res = path(board, word, used);
					used.remove(n);
					if(res) {
						return true;
					}
				}
			}
		}
		return false;
    }
	
	private boolean path(char[][] board, String word, ArrayList<Node> used) {
		if(word.length() <= 1) {
			return true;
		}
		
		word = word.substring(1);
		Node lastNode = used.get(used.size() - 1);
		int i = lastNode.x;
		int j = lastNode.y;
		
		int[][] nextLoca = new int[4][2];
		nextLoca[0][0] = i-1;
		nextLoca[0][1] = j;
		nextLoca[1][0] = i+1;
		nextLoca[1][1] = j;
		nextLoca[2][0] = i;
		nextLoca[2][1] = j-1;
		nextLoca[3][0] = i;
		nextLoca[3][1] = j+1;
		
		for(int[] loca : nextLoca) {
			if(loca[0] >= 0 && loca[0] <= board.length-1 &&loca[1] >= 0 && loca[1] <= board[0].length-1
					&& board[loca[0]][loca[1]] == word.charAt(0) && !used.contains(new Node(loca[0], loca[1]))) {
				Node n = new Node(loca[0], loca[1]);
				used.add(n);
				boolean res = path(board, word, used);
				used.remove(n);
				if(res) {
					return true;
				}
			}
		}
		return false;
	}
	
	class Node {
		int x;
		int y;
		
		public Node(int a, int b) {
			this.x = a;
			this.y = b;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (x == other.x && y == other.y)
				return true;
			return false;
		}

	}

}
