package edu.nju.se.algorithm.exercise;

import java.util.*;
import java.util.Map.Entry;

/**
 * 按照数值个数排序
 * 
 * @author zongk
 *
 */
class Main_exercise3_8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < t; i++) {

			int n = scanner.nextInt();
			scanner.nextLine();

			Map<Integer, Integer> map = new HashMap<Integer, Integer>();

			for (int j = 0; j < n; j++) {
				int num = scanner.nextInt();
				if (map.containsKey(num)) {
					map.put(num, map.get(num) + 1);
				} else {
					map.put(num, 1);
				}
			}

			Set<Entry<Integer, Integer>> set = map.entrySet();
			List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(set);
			Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
				public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
					if(o2.getValue() == o1.getValue()) {
						return o1.getKey() - o2.getKey();
					}
					return (o2.getValue() - o1.getValue());
				}
			});
			
			StringBuffer sb = new StringBuffer();
			
			for(Entry<Integer, Integer> entry : list) {
				for(int k=0; k<entry.getValue(); k++) {
					sb.append(entry.getKey() + " ");
				}
			}
			
			sb.deleteCharAt(sb.length() - 1);
			
			System.out.println(sb.toString());

			if (scanner.hasNextLine()) {
				scanner.nextLine();
			}
		}
		scanner.close();
	}

}
