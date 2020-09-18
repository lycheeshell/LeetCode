package edu.nju.se.hot100;

/**
 * 环形链表
 * 
 * @author lycheeshell
 * @Date 2020-09-18
 */
public class Solution_141 {

	public boolean hasCycle(ListNode head) {
		
		if (head == null || head.next == null) {
			return false;
		}

		ListNode speed1 = head;
		ListNode speed2 = head.next;
		
		while(speed1 != speed2) {
			if (speed2 == null || speed2.next == null) {
				return false;
			}
			speed1 = speed1.next;
			speed2 = speed2.next.next;
		}
		return true;
		
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
