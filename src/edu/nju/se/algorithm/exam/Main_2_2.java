package edu.nju.se.algorithm.exam;

import java.util.*;

/*
input
2
3
1 2 3 1 5 6
3
1 2 4 4 5 1

output
1 2, 3 1, 5 6
1 2, 4 4, 5 1
 */

class Main_2_2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		for (int i = 0; i < t; i++) {

			int n = s.nextInt();
			s.nextLine();

			Point[] points = new Point[n];
			for (int j = 0; j < n; j++) {
				int x = s.nextInt();
				int y = s.nextInt();
				points[j] = new Point(x, y);
			}

			Point[] results = getConvexPoint(points);
			
			String[] res = new String[results.length];
			int index = 0;
			for(Point p : results) {
				res[index] = p.toString();
				index++;
			}
			
			Arrays.sort(res);
			
			StringBuilder sb = new StringBuilder();
			for(String str : res) {
				sb.append(str).append(", ");
			}
			sb.delete(sb.length()-2, sb.length());
			System.out.println(sb.toString());

			if (s.hasNextLine()) {
				s.nextLine();
			}
		}
		s.close();
	}

	//蛮力法解决凸包问题，返回点集合中凸多边形的点集合
    public static Point[] getConvexPoint(Point[] A){
        Point[] result = new Point[A.length];
        int len = 0;  //用于计算最终返回结果中是凸包中点的个数
        for(int i = 0;i < A.length;i++){
            for(int j = 0;j < A.length;j++){
                if(j == i)     //除去选中作为确定直线的第一个点
                    continue;
                
                int[] judge = new int[A.length];   //存放点到直线距离所使用判断公式的结果
                
                for(int k = 0;k < A.length;k++){
                    int a = A[j].getY() - A[i].getY();
                    int b = A[i].getX() - A[j].getX();
                    int c = (A[i].getX())*(A[j].getY()) - (A[i].getY())*(A[j].getX());

                    judge[k] = a*(A[k].getX()) + b*(A[k].getY()) - c;  //根据公式计算具体判断结果
                }
                
                if(JudgeArray(judge)){  // 如果点均在直线的一边,则相应的A[i]是凸包中的点
                    result[len++] = A[i];
                    break;
                }    
            }
        }
        Point[] result1 = new Point[len];
        for(int m = 0;m < len;m++)
            result1[m] = result[m];
        return result1;
    }
    
    //判断数组中元素是否全部大于等于0或者小于等于0，如果是则返回true，否则返回false
    public static boolean JudgeArray(int[] Array){
        boolean judge = false;
        int len1 = 0, len2 = 0;
        
        for(int i = 0;i < Array.length;i++){
            if(Array[i] >= 0)
                len1++;
        }
        for(int j = 0;j < Array.length;j++){
            if(Array[j] <= 0)
                len2++;
        }
        
        if(len1 == Array.length || len2 == Array.length)
            judge = true;
        return judge;
    }

	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}


		public int getY() {
			return y;
		}


		@Override
		public String toString() {
			return x + " " + y;
		}
	}

}
