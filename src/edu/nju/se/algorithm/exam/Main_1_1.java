package edu.nju.se.algorithm.exam;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public class Main_1_1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		for(int i=0; i<t; i++) {
			
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			
			int n = s.nextInt();
			s.nextLine();
			for(int j=0; j<n; j++) {
				int a = s.nextInt();
				if(map.containsKey(a)) {
					map.put(a, map.get(a)+1);
				} else {
					map.put(a, 1);
				}
			}
			
			TreeMap<Integer, ArrayList<Integer>> sortMap = new TreeMap<Integer, ArrayList<Integer>>(
					new Comparator<Integer>() {
						public int compare(Integer o1, Integer o2) {
							return o2.compareTo(o1);
						}
	                });
			for(Integer key : map.keySet()) {
				int numkey = map.get(key);
				if(sortMap.containsKey(numkey)) {
					sortMap.get(numkey).add(key);
				} else {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(key);
					sortMap.put(numkey, list);
				}
			}
			StringBuffer sb = new StringBuffer();
			
			
			Set<Integer> keySet = sortMap.keySet();
			Iterator<Integer> iter = keySet.iterator();
	        while (iter.hasNext()) {
	        	Integer key = iter.next();
	        	ArrayList<Integer> tempList = sortMap.get(key);
	        	Collections.sort(tempList);
	        	for(int k=0; k<tempList.size(); k++) {
	        		for(int q=0;q<key; q++) {
	        			sb.append(tempList.get(k) + " ");
	        		}
	        	}
	        }

	        sb.deleteCharAt(sb.length() - 1);
	        System.out.println(sb.toString());
			
			if(s.hasNextLine()) {
				s.nextLine();
			}
		}
        s.close();
	}

}
