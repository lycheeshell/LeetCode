package edu.nju.se.top100;

import java.util.*;
import java.util.Map.Entry;

/**
 * 字母异位词分组
 * 
 * @author zongk
 *
 */
public class Solution_049 {

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		
		List<List<Character>> res = new ArrayList<List<Character>>();
		
		for(int i=0; i<strs.length; i++) {
			List<Character> temp = new ArrayList<Character>();
			for(int j=0; j<strs[i].length(); j++) {
				temp.add(strs[i].charAt(j));
			}
			boolean contains = false;
			int index = -1;
			for(List<Character> list : res) {
				if(judge(list, temp)) {
					contains = true;
					index = res.indexOf(list);
					break;
				}
			}
			if(contains) {
				result.get(index).add(strs[i]);
			} else {
				res.add(temp);
				List<String> newStrList = new ArrayList<String>();
				newStrList.add(strs[i]);
				result.add(newStrList);
			}
		}
		
		return result;
		
	}

	private boolean judge(List<Character> list, List<Character> temp) {
		if(list.size() != temp.size()) {
			return false;
		}
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		for(Character c : list) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		for(Character c : temp) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
			} else {
				return false;
			}
		}
		
		List<Entry<Character, Integer>> ls = new ArrayList<Entry<Character, Integer>>(map.entrySet());
		for(Entry<Character, Integer> entry : ls) {
			if(entry.getValue() != 0) {
				return false;
			}
		}
		return true;
	}

}
