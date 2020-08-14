package edu.nju.se.hot100;

/**
 * 买卖股票的最佳时机
 * 
 * @author lycheeshell
 * @Date 2020-08-15
 */
public class Solution_121 {
	
	public int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int minPrice = prices[0];
		int res = 0;
		for(int i=1; i<prices.length; i++) {
			if (prices[i] > minPrice) {
				res = Math.max(prices[i] - minPrice, res);
			} else {
				minPrice = prices[i];
			}
		}
		return res;
    }

}
