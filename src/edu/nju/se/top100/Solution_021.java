package edu.nju.se.top100;

/**
 * 合并两个有序链表
 * 
 * @author zongk
 *
 */
public class Solution_021 {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode normal = new ListNode(0);
		
		ListNode first = normal;
		
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				normal.next = l1;
				l1 = l1.next;
			} else {
				normal.next = l2;
				l2 = l2.next;
			}
			normal = normal.next;
		}
		
		while(l1 != null) {
			normal.next = l1;
			l1 = l1.next;
			normal = normal.next;
		}
		
		while(l2 != null) {
			normal.next = l2;
			l2 = l2.next;
			normal = normal.next;
		}
		
		return first.next;
		
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
