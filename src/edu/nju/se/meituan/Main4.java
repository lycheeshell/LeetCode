package edu.nju.se.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
	
	public static void main(String[] args) {
		new Main4().func();
	}

	private void func() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		sc.nextLine();
		
		Node[] arr = new Node[n];
		for(int i=0; i<n; i++) {
			arr[i] = new Node(sc.nextInt()-1);
		}
		sc.nextLine();
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			arr[a].next.add(arr[b]);
			arr[b].next.add(arr[a]);
			if(sc.hasNextLine()) {
				sc.nextLine();
			}
		}
		
		sc.close();
		
		StringBuilder sb = new StringBuilder();
		
		int[] res = new int[n];
		
		for(int i=0; i<n; i++) {
			int[] tmp = new int[k];
			for(int t=0; t< k; t++) {
				tmp[t] = Integer.MAX_VALUE;
			}
			
			ArrayList<Node> used = new ArrayList<>();
			used.add(arr[i]);
			for(Node no : arr[i].next) {
				used.add(no);
				graph(no, 1, tmp, used);
				used.remove(no);
			}
			
			res[i] = 0;
			for(int p=0; p<tmp.length; p++) {
				if(p != arr[i].obj) {
					res[i] += tmp[p];
				}
			}
			
			sb.append(res[i] + " ");
		}
		if(sb.length() > 0) {
			sb.deleteCharAt(sb.length()-1);
		}
		
		System.out.println(sb.toString());
	}

	private void graph(Node now, int path, int[] use, ArrayList<Node> used) {
		if(use[now.obj] > path) {
			use[now.obj] = path;
		}
		for(Node n : now.next) {
			if(!used.contains(n)) {
				used.add(n);
				graph(n, path+1, use, used);
				used.remove(n);
			}
		}
	}

	class Node{
		int obj;
		
		List<Node> next;
		
		public Node(int o) {
			this.obj = o;
			this.next = new ArrayList<>();
		}
		
	}

}
