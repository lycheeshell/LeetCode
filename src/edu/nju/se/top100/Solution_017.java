package edu.nju.se.top100;

import java.util.*;

/**
 * 电话号码的字母组合
 * 
 * @author zongk
 *
 */
public class Solution_017 {

	public List<String> letterCombinations(String digits) {

		List<String> res = new ArrayList<String>();

		if (digits == null || digits.length() == 0) {
			return res;
		}
		
		getLetters(digits, 0, "", res);
		
		return res;

	}

	public void getLetters(String digits, int index, String existed, List<String> res) {

		if (index == digits.length()) {
			res.add(existed);
			return;
		}

		switch (digits.charAt(index)) {
		case '2':
			getLetters(digits, index + 1, existed + "a", res);
			getLetters(digits, index + 1, existed + "b", res);
			getLetters(digits, index + 1, existed + "c", res);
			break;
		case '3':
			getLetters(digits, index + 1, existed + "d", res);
			getLetters(digits, index + 1, existed + "e", res);
			getLetters(digits, index + 1, existed + "f", res);
			break;
		case '4':
			getLetters(digits, index + 1, existed + "g", res);
			getLetters(digits, index + 1, existed + "h", res);
			getLetters(digits, index + 1, existed + "i", res);
			break;
		case '5':
			getLetters(digits, index + 1, existed + "j", res);
			getLetters(digits, index + 1, existed + "k", res);
			getLetters(digits, index + 1, existed + "l", res);
			break;
		case '6':
			getLetters(digits, index + 1, existed + "m", res);
			getLetters(digits, index + 1, existed + "n", res);
			getLetters(digits, index + 1, existed + "o", res);
			break;
		case '7':
			getLetters(digits, index + 1, existed + "p", res);
			getLetters(digits, index + 1, existed + "q", res);
			getLetters(digits, index + 1, existed + "r", res);
			getLetters(digits, index + 1, existed + "s", res);
			break;
		case '8':
			getLetters(digits, index + 1, existed + "t", res);
			getLetters(digits, index + 1, existed + "u", res);
			getLetters(digits, index + 1, existed + "v", res);
			break;
		case '9':
			getLetters(digits, index + 1, existed + "w", res);
			getLetters(digits, index + 1, existed + "x", res);
			getLetters(digits, index + 1, existed + "y", res);
			getLetters(digits, index + 1, existed + "z", res);
			break;
		}
	}

}
