package edu.nju.se.algorithm;

import java.util.*;

class Main_3_5 {
	
	static Map<Long, Long> map = new HashMap<Long, Long>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int p = 0; p < t; p++) {

			long n = scanner.nextLong();
			
			long res = fib(n+1);
			
			System.out.println(res);
			
			
			if(scanner.hasNextLine()) {
				scanner.nextLine();
			}

		}
		scanner.close();
	}

	public static long fib(long n) {
		if (n == 0)
			return 0;
		if (n == 2 || n == 1)
			return 1;
//check if already exists in map ( precalculated val)
		if (map.containsKey(n))
			return map.get(n);
		if (n % 2 != 0) {
			long k = (n + 1) / 2;
			map.put(n, (fib(k) * fib(k) + fib(k - 1) * fib(k - 1)) % 1000000007);
		} else {
			long k = n / 2;
			map.put(n, (fib(k) * ((fib(k - 1) << 1) + fib(k))) % 1000000007);

		}
		return map.get(n);
	}
}
