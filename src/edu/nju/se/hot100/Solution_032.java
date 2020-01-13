package edu.nju.se.hot100;

import java.util.Stack;

/**
 * 最长有效括号
 * 
 * @author zongk
 *
 */
public class Solution_032 {

	public int longestValidParentheses(String s) {
		
		if(s == null || s.length() == 0)
			return 0;
		
		if((!s.contains("(")) || (!s.contains(")")) )  {
			return 0;
		}
		
		int max = 0;
		
		for(int i=0; i<s.length()-max; i++) {
			
			Stack<Character> stack = new Stack<>();
			
			int num = 0;
			
			for(int k=i; k<s.length(); k++) {
				if(s.charAt(k) == '(') {
					stack.push(s.charAt(k));
				}
				if(s.charAt(k) == ')') {
					if(stack.isEmpty()) {
						break;
					} else {
						stack.pop();
						num += 2;
						if(stack.isEmpty()) {
							max = Math.max(max, num);
						}
					}
					
				}
			}
			
		}
		
		return max;
		
	}
}
