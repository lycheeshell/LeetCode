package edu.nju.se.top100;

/**
 * 删除链表的倒数第N个节点
 * 
 * @author zongk
 *
 */
public class Solution_019 {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		ListNode normal = new ListNode(0);
		normal.next = head;
		
		ListNode first = normal;
		ListNode second = normal;
		
		for(int i=0; i<=n; i++) {
			first = first.next;
		}
		
		while(first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		
		return normal.next;

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
