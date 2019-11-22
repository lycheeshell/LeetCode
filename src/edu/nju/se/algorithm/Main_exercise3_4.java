package edu.nju.se.algorithm;

import java.util.*;

/**
 * 棋盘覆盖问题
 * 
 * @author zongk
 *
 */
class Main_exercise3_4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < t; i++) {

			String line = scanner.nextLine();
			String[] ss = line.split(" ");
			int n = Integer.parseInt(ss[0]);
			int x = Integer.parseInt(ss[1]);
			int y = Integer.parseInt(ss[2]);

			line = scanner.nextLine();
			String[] ss2 = line.split(" ");
			int a = Integer.parseInt(ss2[0]);
			int b = Integer.parseInt(ss2[1]);

			chessBoard(n, x, y, a, b, 0, 0);

		}
		scanner.close();
	}
	
	public static boolean judge(int x1, int y1, int x2, int y2, int a, int b) {
		if((a == x1 && b == y1) || (a == x2 && b == y2)) {
			return false;
		}
		return true;
	}
	
	public static String getStr(int x1, int y1, int x2, int y2, int a, int b) {
		StringBuffer sb = new StringBuffer();
		if(judge(x1,y1,x2,y2,a,b)) {
			sb.append(a + " " + b + ",");
		}
		if(judge(x1,y1,x2,y2,a,b+1)) {
			sb.append(a + " " + (b+1) + ",");
		}
		if(judge(x1,y1,x2,y2,a+1,b)) {
			sb.append((a+1) + " " + b + ",");
		}
		if(judge(x1,y1,x2,y2,a+1,b+1)) {
			sb.append((a+1) + " " + (b+1) + ",");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

	public static void chessBoard(int n, int x, int y, int a, int b, int tx, int ty) {
		if (n == 1) {
			String res = getStr(x,y,a,b,tx,ty);
			System.out.println(res);
			return;
		}
		
		int width = (int) Math.pow(2, n - 1);
		
		if(0 <= a - (tx + width - 1) && a - (tx + width - 1) <= 1 
				&& 0 <= b - (ty + width - 1) && b - (ty + width - 1) <= 1 ) {
			if(tx <= x && x < tx + width && ty <= y && y < ty + width) {
				x = tx + width - 1;
				y = ty + width - 1;
			} else if (tx + width <= x && x < tx + width * 2 && ty <= y && y < ty + width) {
				x = tx + width;
				y = ty + width - 1;
			} else if (tx <= x && x < tx + width && ty + width <= y && y < ty + 2 * width) {
				x = tx + width - 1;
				y = ty + width;
			} else if (tx + width <= x && x < tx + width * 2 && ty + width <= y && y < ty + 2 * width) {
				x = tx + width;
				y = ty + width;
			}
			
			String res = getStr(x,y,a,b,tx + width - 1,ty + width - 1);
			System.out.println(res);
			return;
		}
		
		if (tx <= a && a < tx + width && ty <= b && b < ty + width) {
			if (!(tx <= x && x < tx + width && ty <= y && y < ty + width)) {
				x = tx + width - 1;
				y = ty + width - 1;
			}
		} else if (tx + width <= a && a < tx + width * 2 && ty <= b && b < ty + width) {
			if (!(tx + width <= x && x < tx + width * 2 && ty <= y && y < ty + width)) {
				x = tx + width;
				y = ty + width - 1;
			}
			tx = tx + width;
		} else if (tx <= a && a < tx + width && ty + width <= b && b < ty + 2 * width) {
			if (!(tx <= x && x < tx + width && ty + width <= y && y < ty + 2 * width)) {
				x = tx + width - 1;
				y = ty + width;
			}
			ty = ty + width;
		} else if (tx + width <= a && a < tx + width * 2 && ty + width <= b && b < ty + 2 * width) {
			if (!(tx + width <= x && x < tx + width * 2 && ty + width <= y && y < ty + 2 * width)) {
				x = tx + width;
				y = ty + width;
			}
			tx = tx + width;
			ty = ty + width;
		}

		chessBoard(n - 1, x, y, a, b, tx, ty);
	}

}
