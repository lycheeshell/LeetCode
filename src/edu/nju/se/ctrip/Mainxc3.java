package edu.nju.se.ctrip;

import java.util.*;

public class Mainxc3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] corrects = {"surprise", "happy", "ctrip", "travel", "wellcome","student","system","program","editor"};
		
		while(scanner.hasNextLine()) {
			String word = scanner.nextLine();
			if(word == null || word.length() == 0) {
				break;
			}
			
			boolean hasWord = false;
			for(String correct : corrects) {
				if(correctFunc(word, correct)) {
					System.out.println(correct);
					hasWord = true;
					break;
				}
			}
			
			if(!hasWord) {
				System.out.println("null");
			}
		}
		
		scanner.close();
	}

	private static boolean correctFunc(String word, String correct) {
		int line = word.length();
		int col = correct.length();
		
		int[][] dp = new int[line][col];
		dp[0][0] = word.charAt(0) == correct.charAt(0) ? 0 : 1;
		String word0 = String.valueOf(word.charAt(0));
		for(int i=1; i<col; i++) {
			if(word.charAt(0) == correct.charAt(i)) {
				if(correct.substring(0, i).contains(word0)) {
					dp[0][i] = dp[0][i-1] + 1;
				} else {
					dp[0][i] = dp[0][i-1];
				}
			} else {
				dp[0][i] = dp[0][i-1] + 1;
			}
		}
		String correct0 = String.valueOf(correct.charAt(0));
		for(int i=1; i<line; i++) {
			if(correct.charAt(0) == word.charAt(i)) {
				if(word.substring(0, i).contains(correct0)) {
					dp[i][0] = dp[i-1][0] + 1;
				} else {
					dp[i][0] = dp[i-1][0];
				}
			} else {
				dp[i][0] = dp[i-1][0] + 1;
			}
		}
		
		for(int i=1; i<line; i++) {
			for(int j=1; j<col; j++) {
				int tmp = Integer.MAX_VALUE;
				if(word.charAt(i) == correct.charAt(j)) {
					tmp = dp[i-1][j-1];
				} else {
					tmp = dp[i-1][j-1] + 1;
				}
				dp[i][j] = Math.min(tmp, Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
			}
		}
		
		if(dp[line-1][col-1] <= 2) {
			return true;
		}
		
		return false;
	}

}
