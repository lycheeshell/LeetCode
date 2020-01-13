package edu.nju.se.hot100;

/**
 * 最长回文子串
 * 
 * @author zongk
 *
 */
public class Solution_005 {

	public String longestPalindrome(String s) {

		if(s.length() == 0) {
			return s;
		}
		
		String result = s.substring(0, 1);
		
		for(int t=1; t<=s.length(); t++) {
			for(int i=0; i< s.length()-t; i++) {
				if(isPalindrome(s.substring(i, i+t+1))) {
					result = s.substring(i, i+t+1);
					i = s.length();
				}
			}
		}
		
		return result;
		
	}
	
	private boolean isPalindrome(String s) {
		int i=0;
		int j=s.length()-1;
		
		while(i<j) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution_005().longestPalindrome("cbbd"));
	}

}
