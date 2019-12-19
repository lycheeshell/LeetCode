package edu.nju.se.algorithm.greedy;

import java.util.*;

class 时间与收益 {

	static class Task {
        int id;
        int deadline;
        int value;

        public Task(int id, int deadline, int value) {
            this.id = id;
            this.deadline = deadline;
            this.value = value;
        }

    }

    public static void solve(List<Task> list) {
        int time = 0;
        for (Task t : list) {
            time = Math.max(time, t.deadline);
        }
        int count = 0, profit = 0;
        for (int i = time; i > 0; i--) {
            Task cur = null;
            for (Task task : list) {
            	if(task.deadline >= i) {
            		if(cur == null || ((cur != null) && (cur.value < task.value))) {
            			cur = task;
            		}
            	}
            }
            if (cur != null) {
                count++;
                profit += cur.value;
                list.remove(cur);
            }
            if (list.size() == 0) {
                break;
            }
        }
        System.out.println(count + " " + profit);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testNum = Integer.parseInt(sc.nextLine());
        while (testNum > 0) {
            List<Task> list = new ArrayList<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int id = sc.nextInt();
                int deadline = sc.nextInt();
                int value = sc.nextInt();
                list.add(new Task(id, deadline, value));
            }
            solve(list);
            testNum--;
        }
        sc.close();
    }

}
