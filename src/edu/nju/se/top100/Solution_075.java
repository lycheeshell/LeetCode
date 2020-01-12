package edu.nju.se.top100;

/**
 * 颜色分类
 * 
 * @author zongk
 *
 */
public class Solution_075 {

    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        int curr = 0;
        while(curr <= p2) {
        	switch(nums[curr]) {
        	case 1:
        		curr++;
        		break;
        	case 2:
        		int temp2 = nums[curr];
        		nums[curr] = nums[p2];
        		nums[p2] = temp2;
        		p2--;
        		break;
        	case 0:
        		int temp0 = nums[curr];
        		nums[curr] = nums[p0];
        		nums[p0] = temp0;
        		p0++;
        		curr++;
        		break;
        	}
        		
        }
    }

}
