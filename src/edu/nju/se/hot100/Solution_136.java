package edu.nju.se.hot100;

/**
 * 只出现一次的数字
 * 
 * @author lycheeshell
 * @Date 2020-08-18
 */
public class Solution_136 {
	
	public int singleNumber(int[] nums) {
        int res = 0;
        for(int n : nums) {
            res = res ^ n;
        }
        return res;
    }

}
