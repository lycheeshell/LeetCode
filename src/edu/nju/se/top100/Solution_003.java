package edu.nju.se.top100;

/**
 * 无重复字符的最长子串
 * 
 * @author zongk
 *
 */
public class Solution_003 {

    public int lengthOfLongestSubstring(String s) {
        
    	int len = s.length();
    	
    	int max = 0;
    	if(len > 0) {
    		max = 1;
    	}
    	
    	for(int i=0; i<len; i++) {
    		
    		if(i + max >= len)
    			break;
    		String temp = s.substring(i, i + max + 1);
    		while(!containSame(temp)) {
    			max++;
    			if(i + max >= len)
        			break;
    			temp = s.substring(i, i + max + 1);
    		}
    		
    	}
    	
    	return max;
    }

	private boolean containSame(String sub) {
		for(int i=0; i<sub.length(); i++) {
			for(int j=i+1; j<sub.length(); j++) {
				if(sub.charAt(i) == sub.charAt(j)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution_003().lengthOfLongestSubstring("au"));
	}

}
