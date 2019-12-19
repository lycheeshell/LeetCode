package edu.nju.se.algorithm.exam;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main_1_4 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		for(int i=0; i<t; i++) {
			
			int m = s.nextInt();
			int n = s.nextInt();
			s.nextLine();
			
			int[] a1 = new int[m];
			int[] a2 = new int[n];
			
			StringBuffer sb = new StringBuffer();
			
			for(int j=0; j<m;j++) {
				a1[j] = s.nextInt();
			}
			s.nextLine();
			for(int j=0; j<n;j++) {
				a2[j] = s.nextInt();
			}
			
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(
					new Comparator<Integer>() {
						public int compare(Integer o1, Integer o2) {
							return o1.compareTo(o2);
						}
	                });
			
			for(int j=0; j<m; j++) {
				int a = a1[j];
				if(map.containsKey(a)) {
					map.put(a, map.get(a)+1);
				} else {
					map.put(a, 1);
				}
			}
			
			for(int j=0; j<n; j++) {
				int a = a2[j];
				int anum = map.get(a);
				for(int q=0; q<anum; q++) {
					sb.append(a + " ");
				}
				map.remove(a);
			}
			
			Set<Integer> keySet = map.keySet();
			Iterator<Integer> iter = keySet.iterator();
	        while (iter.hasNext()) {
	        	Integer key = iter.next();
	        	for(int q=0; q<map.get(key); q++) {
	        		sb.append(key + " ");
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
