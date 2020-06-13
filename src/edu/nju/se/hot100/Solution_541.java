package edu.nju.se.hot100;

/**
 * 反转字符串2
 * 
 * @author zongk
 *
 */
public class Solution_541 {

	public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int start = 0;
        while(start <= arr.length-1) {
        	int end = Math.min(arr.length-1, start+k-1);
            reverseSubStr(arr, start, end);
            start += 2*k;
        }
        return String.valueOf(arr);
    }
    
    private void reverseSubStr(char[] s, int start, int end) {
        while(start < end) {
            char tmp = s[start];
            s[start++] = s[end];
            s[end--] = tmp;
        }
    }
    
    public static void main(String[] args) {
		String res = new Solution_541().reverseStr("abcdefg", 8);
		System.out.println(res);
	}

}
