package edu.nju.se.top100;

/**
 * 跳跃游戏
 * 
 * @author zongk
 *
 */
public class Solution_055 {

	public boolean canJump(int[] nums) {
		boolean[] dp = new boolean[nums.length];
		dp[0] = true;
		for(int i=1; i<dp.length; i++) {
			for(int j=0; j<i; j++) {
				if(dp[j] && nums[j] >= i-j) {
					dp[i] = true;
					break;
				}
			}
		}
		
		return dp[dp.length-1];
	}

}
