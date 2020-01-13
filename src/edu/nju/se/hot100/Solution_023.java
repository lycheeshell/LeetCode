package edu.nju.se.hot100;

import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * 合并K个排序链表
 * 
 * @author zongk
 *
 */
public class Solution_023 {
	
	public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) queue.add(p.next);
        }
        return dummy.next;
    }

//	public ListNode mergeKLists(ListNode[] lists) {
//		
//		ListNode first = new ListNode(0);
//		
//		ListNode normal = first;
//		
//		while(true) {
//			
//			boolean allEmpty = true;
//			for(ListNode node : lists) {
//				if(node != null) {
//					allEmpty = false;
//					break;
//				}
//			}
//			
//			if(allEmpty) {
//				break;
//			}
//			
//			ListNode min = null;
//			int index = 0;
//			int minIndex = -1;
//			
//			for(ListNode node : lists) {
//				if(node != null && (min == null || node.val < min.val)) {
//					min = node;
//					minIndex = index;
//				}
//				index++;
//			}
//			
//			normal.next = min;
//			normal = normal.next;
//			lists[minIndex] = lists[minIndex].next;
//			
//		}
//		
//		return first.next;
//
//	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		new Solution_023().test();
	}
	
	public void test() {
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(4);
		ListNode n13 = new ListNode(5);
		ListNode n21 = new ListNode(1);
		ListNode n22 = new ListNode(3);
		ListNode n23 = new ListNode(4);
		ListNode n31 = new ListNode(2);
		ListNode n32 = new ListNode(6);
		
		n11.next = n12;
		n12.next = n13;
		n21.next = n22;
		n22.next = n23;
		n31.next = n32;
		
		ListNode[] lists = {n11,n21,n31};
		
		ListNode res = mergeKLists(lists);
		
		while(res.next != null) { 
			System.out.print(res.val + " ");
			res = res.next;
		}
		
	}

}
