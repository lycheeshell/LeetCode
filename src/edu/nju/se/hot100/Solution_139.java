package edu.nju.se.hot100;

import java.util.List;

/**
 * 单词拆分
 * 
 * @author lycheeshell
 * @Date 2020-09-18
 */
public class Solution_139 {

	public boolean wordBreak(String s, List<String> wordDict) {

		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		
		for(int i=1; i<=s.length(); i++) {
			for(String temp : wordDict) {
				if(i - temp.length() >= 0) {
					boolean loca = dp[i - temp.length()] && temp.equals(s.substring(i - temp.length(), i));
					if (loca) {
						dp[i] = true;
						break;
					}
				}
			}
		}
		
		return dp[s.length()];
	}

	// 贪婪 超时
//	public boolean wordBreak(String s, List<String> wordDict) {
//		
//		if (s == null || s.length() == 0) {
//			return true;
//		}
//			
//		for(String temp : wordDict) {
//			if (s.startsWith(temp)) {
//				String newStr = s.substring(temp.length());
//				if (wordBreak(newStr, wordDict)) {
//					return true;
//				}
//			}
//		}
//		
//		return false;
//    }

}
