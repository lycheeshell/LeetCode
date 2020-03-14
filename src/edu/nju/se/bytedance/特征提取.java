package edu.nju.se.bytedance;

import java.util.ArrayList;
import java.util.Scanner;

public class 特征提取 {

	public static void main(String[] args) {
		new 特征提取().func();
	}
	
	public void func() {
		Scanner sc = new Scanner(System.in);
		int line = Integer.parseInt(sc.nextLine());
		ArrayList<Node> list = new ArrayList<>();
		for(int p=0; p<line; p++) {
			int m = Integer.parseInt(sc.nextLine());
			for(int i=0; i<m; i++) {
				int num = sc.nextInt();
				Node n = new Node(num);
				for(int j=0; j<num; j++) {
					int[] arr = new int[2];
					arr[0] = sc.nextInt();
					arr[1] = sc.nextInt();
					n.fea[j] = arr;
				}
				list.add(n);
			}
		}
		sc.close();
		
		System.out.println(getMaxLen(list));
	}
	
	private int getMaxLen(ArrayList<Node> list) {
		int max = 0;
		for(int i=0; i<list.size(); i++) {
			Node n = list.get(i);
			for(int[] f : n.fea) {
				int num = 1;
				while(i+num < list.size() && list.get(i+num).contains(f)) {
					num++;
				}
				if(num > max) {
					max = num;
				}
			}
		}
		
		return max;
	}

	class Node{
		int num = 0;
		int[][] fea;
		
		public Node(int num) {
			this.num = num;
			fea = new int[num][2];
		}
		
		public boolean contains(int[] f) {
			for(int[] tmp : fea) {
				if(tmp[0] == f[0] && tmp[1] == f[1]) {
					return true;
				}
			}
			return false;
		}
	}

}
