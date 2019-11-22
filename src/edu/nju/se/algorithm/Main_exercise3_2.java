package edu.nju.se.algorithm;

import java.util.*;

/**
 * KD树构造和查找
 * 
 * @author zongk
 *
 */
class Main_exercise3_2 {

	public static void main(String[] args) {
		new Main_exercise3_2().doFunc();
	}
	
	public void doFunc() {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < t; i++) {
			
			String line = scanner.nextLine();
			String[] nss = line.split(",");
			
			List<Node> nodes = new ArrayList<Node>();
			for (int j=0; j<nss.length; j++) {
				String[] xy = nss[j].split(" ");
				nodes.add(new Node(Double.parseDouble(xy[0]), Double.parseDouble(xy[1])));
			}
			
			line = scanner.nextLine();
			String[] pointstr = line.split(" ");
			double[] point = new double[2];
			point[0] = Double.parseDouble(pointstr[0]);
			point[1] = Double.parseDouble(pointstr[1]);
			
			line = scanner.nextLine();
			int k = Integer.parseInt(line);
			
//			Node root = generateTree(nodes);
			
			Node[] res = getResult(nodes, k, point);
			
			StringBuffer sb = new StringBuffer();
			for(Node n : res) {
				if ((int)n.x == n.x) {
					sb.append((int)n.x);
				} else {
					sb.append(n.x);
				}
				sb.append(" ");
				if ((int)n.y == n.y) {
					sb.append((int)n.y);
				} else {
					sb.append(n.y);
				}
				sb.append(",");
			}
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb.toString());
		}
		scanner.close();
	}
	
	public Node[] getResult(List<Node> nodes, int k, double[] point) {
		Node[] res = new Node[k];
		for(Node n : nodes) {
			for(int i=0; i< k; i++) {
				if(res[i] == null) {
					res[i] = n;
				} else if(calculateDistance(res[i], point) > calculateDistance(n, point)) {
					for(int j=k-1; j>i; j--) {
						res[j] = res[j-1];
					}
					res[i] = n;
					break;
				}
			}
		}
		return res;
	}
	
	public double calculateDistance(Node n, double[] point) {
		return Math.pow(Math.pow(n.x-point[0], 2) + Math.pow(n.y-point[1], 2), 0.5);
	}
	
//	public Node generateTree(List<Node> nodes) {
//		
//	}
//	
//	public Node[] searchNode(Node root, int k) {
//		
//	}
	
	
	class Node{
		double x;
		double y;
		Node left;
		Node right;
		int dimension; // 1 x  2 y  0 no set
		
		public Node(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}
