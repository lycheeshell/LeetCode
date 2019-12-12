package edu.nju.se.algorithm;

import java.util.*;

/**
 * 时间与收益
 * 
 * @author zongk
 *
 */
class Main_5_3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int p = 0; p < t; p++) {

			int n = scanner.nextInt();
			scanner.nextLine();

			ArrayList<Job> arr = new ArrayList<Job>();
			for(int i=0; i<n; i++) {
				arr.add(new Job(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
			}
			
			Job.printJobScheduling(arr); 
			
			if (scanner.hasNextLine()) {
				scanner.nextLine();
			}
		}
		scanner.close();
	}

}

//A Simple Disjoint Set Data Structure 
class DisjointSet {
	int parent[];

	// Constructor
	DisjointSet(int n) {
		parent = new int[n + 1];

		// Every node is a parent of itself
		for (int i = 0; i <= n; i++)
			parent[i] = i;
	}

	// Path Compression
	int find(int s) {
		/*
		 * Make the parent of the nodes in the path from u--> parent[u] point to
		 * parent[u]
		 */
		if (s == parent[s])
			return s;
		return parent[s] = find(parent[s]);
	}

	// Makes u as parent of v.
	void merge(int u, int v) {
		// update the greatest available
		// free slot to u
		parent[v] = u;
	}
}

class Job implements Comparator<Job> {
	// Each job has a unique-id, profit and deadline
	int id;
	int deadline, profit;

	// Constructors
	public Job() {
	}

	public Job(int id, int deadline, int profit) {
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}

	// Returns the maximum deadline from the set of jobs
	public static int findMaxDeadline(ArrayList<Job> arr) {
		int ans = Integer.MIN_VALUE;
		for (Job temp : arr)
			ans = Math.max(temp.deadline, ans);
		return ans;
	}

	// Prints optimal job sequence
	public static void printJobScheduling(ArrayList<Job> arr) {
		List<Job> res = new ArrayList<Job>();
		
		// Sort Jobs in descending order on the basis
		// of their profit
		Collections.sort(arr, new Job());

		// Find the maximum deadline among all jobs and
		// create a disjoint set data structure with
		// maxDeadline disjoint sets initially.
		int maxDeadline = findMaxDeadline(arr);
		DisjointSet dsu = new DisjointSet(maxDeadline);

		// Traverse through all the jobs
		for (Job temp : arr) {
			// Find the maximum available free slot for
			// this job (corresponding to its deadline)
			int availableSlot = dsu.find(temp.deadline);

			// If maximum available free slot is greater
			// than 0, then free slot available
			if (availableSlot > 0) {
				// This slot is taken by this job 'i'
				// so we need to update the greatest free
				// slot. Note that, in merge, we make
				// first parameter as parent of second
				// parameter. So future queries for
				// availableSlot will return maximum slot
				// from set of "availableSlot - 1"
				dsu.merge(dsu.find(availableSlot - 1), availableSlot);
				res.add(temp);
			}
		}
		System.out.print(res.size() + " ");
		int sum = 0;
		for(Job j : res) {
			sum += j.profit;
		}
		System.out.print(sum);
		System.out.println();
	}

	// Used to sort in descending order on the basis
	// of profit for each job
	public int compare(Job j1, Job j2) {
		return j1.profit > j2.profit ? -1 : 1;
	}
}
