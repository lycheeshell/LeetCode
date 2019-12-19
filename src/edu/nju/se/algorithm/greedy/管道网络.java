package edu.nju.se.algorithm.greedy;

import java.util.*;

public class 管道网络 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for(int p=0; p<t; p++) {
			int n = scanner.nextInt();
			n = n + 1; // useless
			int m = scanner.nextInt();
			scanner.nextLine();
			
			List<Line> list = new ArrayList<Line>();
			for(int i=0; i<m; i++) {
				list.add(new Line(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
				if(scanner.hasNextLine()) {
					scanner.nextLine();
				}
			}
			
			List<Line> res = new ArrayList<Line>();
			while (list.size() > 0) {
				Line line = list.get(0);
				Line prev = null;
				Line next = null;
				for(Line l : list) {
					if(l.to == line.from) {
						prev = l;
					}
					if(l.from == line.to) {
						next = l;
					}
				}
				
				if(prev != null) {
					line.from = prev.from;
					line.val = Math.min(prev.val, line.val);
					list.remove(prev);
				}
				if(next != null) {
					line.to = next.to;
					line.val = Math.min(next.val, line.val);
					list.remove(next);
				}
				if(prev == null && next == null) {
					res.add(line);
					list.remove(line);
				}
			}
			
			Collections.sort(res, new Comparator<Line>() {

				@Override
				public int compare(Line o1, Line o2) {
					return o1.from-o2.from;
				}
			});
			
			System.out.println(res.size());
			for(Line l : res) {
				System.out.println(l.from + " " + l.to + " " + l.val);
			}
			
		}
		
		scanner.close();
	}
	
	static class Line {
		int from;
		int to;
		int val;
		
		public Line() {
		}
		
		public Line(int f, int t, int v) {
			this.from = f;
			this.to = t;
			this.val = v;
		}

	}

}
