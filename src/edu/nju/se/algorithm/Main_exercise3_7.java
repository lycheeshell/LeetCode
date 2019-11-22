package edu.nju.se.algorithm;

import java.util.*;

/**
 * 拓扑排序解的个数
 * 
 * @author zongk
 *
 */
class Main_exercise3_7 {
	
	static int sum;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < t; i++) {
			
			sum = 1;
			
			Map<String, List<String>> map = new HashMap<String, List<String>>();

			String line = scanner.nextLine();
			String[] edges = line.split(",");
			for(String edge : edges) {
				String[] points = edge.trim().split(" ");
				if(map.containsKey(points[0])) {
					map.get(points[0]).add(points[1]);
				} else {
					List<String> temp = new ArrayList<String>();
					temp.add(points[1]);
					map.put(points[0], temp);
				}
			}
			
			topSort(map);
			System.out.println(sum);
			
		}
		scanner.close();
	}
	
	public static void topSort(Map<String, List<String>> map) {
		
		if(map.size() == 0) {
			return;
		}
		
		Map<String, Integer> singleMap = getInNum(map);
		if(singleMap.size() == 0) {
			return;
		}
		
		List<String> singleList = new ArrayList<String>();
		
		for(String key : singleMap.keySet()) {
			if(singleMap.get(key) == 0) {
				singleList.add(key);
			}
		}
		
		for(int k=0; k<singleList.size(); k++) {
			String node = singleList.get(k);
			if(k > 0) {
				sum += 1;
			}
			Map<String, List<String>> newMap = new HashMap<String, List<String>>();
			newMap.putAll(map);
			
			newMap.keySet().removeIf(key -> key.equals(node));
			
			topSort(newMap);
		}
		
	}
	
	public static Map<String, Integer> getInNum(Map<String, List<String>> map) {
		Map<String, Integer> res = new HashMap<String, Integer>();
		
		for(String key : map.keySet()) {
			res.put(key, 0);
		}
		
		for(String key : map.keySet()) {
			List<String> list = map.get(key);
			for(String to : list) {
				if(res.containsKey(to)) {
					int num = res.get(to) + 1;
					res.put(to, num);
				} else {
					res.put(to, 1);
				}
			}
		}
		return res;
	}

}
