package edu.nju.se.hot100;

import java.util.*;

/**
 * 子集
 * 
 * @author zongk
 *
 */
public class Solution_078 {

    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	res.add(new ArrayList<Integer>());
    	for(int i : nums) {
    		int size = res.size();
    		for(int k=0; k<size; k++) {
    			List<Integer> temp = new ArrayList<Integer>(res.get(k));
    			temp.add(i);
    			res.add(temp);
    		}
    	}
    	return res;
    }

}
