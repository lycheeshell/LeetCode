package edu.nju.se.algorithm.exam;

import java.util.*;

class Main_4_3 {

	public static void main(String[] args) {
		int i;
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			ArrayList<Integer> li = new ArrayList<Integer>();
			for (i = 0; i < n; i++)
				li.add(in.nextInt());

			int sum = 0;
			check(li, sum);
		}
		in.close();
	}

	static void check(ArrayList<Integer> li, int sum) {
		if (li.size() == 0) {
			System.out.println(sum);
			return;
		} else {
			Collections.sort(li);
			int num = li.get(li.size() - 1);
			sum = sum + num;
			li.remove(li.size() - 1);
			if (li.size() == 0) {
				System.out.println(sum);
				return;
			}
			if (li.contains(num - 1)) {
				li.remove(Integer.valueOf(num - 1));
			}
			check(li, sum);
		}
	}
}
