package edu.nju.se.hot100;

/**
 * 环形链表 II
 * 
 * @author lycheeshell
 * @Date 2020-09-18
 */
public class Solution_142 {

	public ListNode detectCycle(ListNode head) {
		
		if (head == null || head.next == null) {
			return null;
		}

		ListNode speed1 = head;
		ListNode speed2 = head;

		while (speed2 != null && speed2.next != null) {
			speed1 = speed1.next;
			speed2 = speed2.next.next;
			if (speed1 == speed2) {
				break;
			}
		}
		if (speed2 == null || speed2.next == null) {
			return null;
		}
		
		speed1 = head;
		
		while(speed1 != speed2) {
			speed1 = speed1.next;
			speed2 = speed2.next;
		}
		
		return speed1;
		
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(0);
		ListNode n4 = new ListNode(-4);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n2;
		
		new Solution_142().detectCycle(n1);
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
