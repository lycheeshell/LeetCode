package edu.nju.se.hot100;

/**
 * 合并石头的最低成本
 * 
 * @author zongk
 *
 */
public class Solution_1000 {

	public int mergeStones(int[] stones, int k) {
		
		int len = stones.length;
		while(len > k) {
			len = len - (k - 1);
		}
		if(len > 1) {
			return -1;
		}
		
		return -1;
		//qnmd石头
		
    }

}
