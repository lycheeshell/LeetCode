package edu.nju.se.hot100;

import java.util.Stack;

/**
 * 有效的括号
 * 
 * @author zongk
 *
 */
public class Solution_020 {

	public boolean isValid(String s) {
		
		if(s == null || s.length() == 0) {
			return true;
		}
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if(c == ')') {
				if(stack.isEmpty()) {
					return false;
				}
				char t = stack.pop();
				if(t != '(') {
					return false;
				}
			} else if(c == '}') {
				if(stack.isEmpty()) {
					return false;
				}
				char t = stack.pop();
				if(t != '{') {
					return false;
				}
			} else if(c == ']') {
				if(stack.isEmpty()) {
					return false;
				}
				char t = stack.pop();
				if(t != '[') {
					return false;
				}
			} else {
				return false;
			}
		}
		if(stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
		
	}
}
