package edu.nju.se.algorithm.exam;

import java.util.*;

/*
 * runtime error
 * python 解决
 */
class Main_2_4_B {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		for (int i = 0; i < t; i++) {

			int n = s.nextInt();

			System.out.println(maxPeople(n));

			if (s.hasNextLine()) {
				s.nextLine();
			}

		}
		s.close();
	}

	static int maxPeople(int p) {
		int tmp = 0, count = 0;

		// Loop will break when the ith person
		// cannot be killed
		for (int i = 1; i * i <= p; i++) {
			tmp = tmp + (i * i);
			if (tmp <= p)
				count++;
			else
				break;
		}
		return count;
	}

}
