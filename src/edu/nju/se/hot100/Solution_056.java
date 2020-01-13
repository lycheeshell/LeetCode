package edu.nju.se.hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * 
 * @author zongk
 *
 */
public class Solution_056 {

    public int[][] merge(int[][] intervals) {
    	
    	if(intervals.length == 0) {
    		return intervals;
    	}
        
    	List<int[]> arrs = new ArrayList<int[]>();
    	for(int i=0; i<intervals.length; i++) {
    		arrs.add(intervals[i]);
    	}
    	
    	Collections.sort(arrs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
    	
    	List<int[]> list = new ArrayList<int[]>();
    	list.add(arrs.get(0));
    	
    	for(int i=1; i<arrs.size(); i++) {
    		if(list.get(list.size()-1)[1] < arrs.get(i)[0]) {
    			list.add(arrs.get(i));
    		} else {
    			int[] temp = list.get(list.size()-1);
    			list.remove(list.size()-1);
    			temp[1] = Integer.max(temp[1], arrs.get(i)[1]);
    			list.add(temp);
    		}
    	}
    	
    	int[][] res = new int[list.size()][2];
    	int index = 0;
    	for(int[] arr : list) {
    		res[index++] = arr;
    	}
    	
    	return res;
    }

}
