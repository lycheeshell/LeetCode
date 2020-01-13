package edu.nju.se.hot100;

/**
 * 两数之和
 * 
 * @author zongk
 *
 */
public class Solution_001 {

	public int[] twoSum(int[] nums, int target) {
        int[] outcome = new int[2];
        for(int i=0;i<nums.length-1;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[i] + nums[j] == target) {
                    outcome[0] = i;
                    outcome[1] = j;
                    return outcome;
                }
            }
        }
        return outcome;
    }

}
