package edu.nju.se.algorithm;

import java.util.*;

class Main_exercise1_8 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		for (int i = 0; i < t; i++) {

			String sline1 = s.nextLine();
			String[] sarr1 = sline1.split(" ");
			int[] arr1 = new int[sarr1.length];
			for (int j = 0; j < sarr1.length; j++) {
				arr1[j] = Integer.parseInt(sarr1[j]);
			}

			String sline2 = s.nextLine();
			String[] sarr2 = sline2.split(" ");
			int[] arr2 = new int[sarr2.length];
			for (int j = 0; j < sarr2.length; j++) {
				arr2[j] = Integer.parseInt(sarr2[j]);
			}
			
			List<Integer> arr = new ArrayList<>();
			for(int k : arr1) {
				arr.add(k);
			}
			for(int k : arr2) {
				arr.add(k);
			}
			
			int sum = 0;
            for (Integer k : arr) {
                sum += k;
            }
            int minResult = Integer.MAX_VALUE;
            Collections.sort(arr);
            List<List<Integer>> result = new ArrayList<>();
            
            findCombinations(arr,arr1.length,0,new Stack<>(),result);
            
            for (List<Integer> list : result) {
                int listSum = 0;
                for (Integer k : list) {
                    listSum += k;
                }
                minResult = Math.min(minResult,Math.abs((sum-listSum)-listSum));
            }
            System.out.println(minResult);

		}
		s.close();
	}
	
    private static void findCombinations(List<Integer> list,int n,int begin,Stack<Integer> pre,List<List<Integer>> res) {
        if (pre.size() == n) {
            res.add(new ArrayList<>(pre));
            return;
        }

        for (int i = begin; i < list.size(); i++) {
            pre.add(list.get(i));
            findCombinations(list,n,i+1,pre,res);
            pre.pop();
        }
    }

//	public static void getNums(int[] arr, List<Integer> indexs) {
//		
//		if(indexs.size() == arr.length/2) {
//			int sum1 = 0, sum2 = 0;
//			for(int i=0; i<arr.length; i++) {
//				if(indexs.contains(i)) {
//					sum1 += arr[i];
//				} else {
//					sum2 += arr[i];
//				}
//			}
//			if(Math.abs(sum1 - sum2) < abs) {
//				abs = Math.abs(sum1 - sum2);
//			}
//			return;
//		}
//		
//		for(int i=indexs.size() != 0 ? indexs.get(indexs.size()-1)+1 : 0; i<arr.length; i++) {
//			List<Integer> newindexs = new ArrayList<Integer>();
//			for(Integer index : indexs) {
//				newindexs.add(index);
//			}
//			newindexs.add(i);
//			getNums(arr, newindexs);
//		}
//	}
	
}