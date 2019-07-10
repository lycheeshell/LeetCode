package edu.nju.se.num1_10;

import java.util.ArrayList;

/**
 * 两数相加
 * 
 * @author zongk
 *
 */
public class Solution_02 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}
        
		ArrayList<ListNode> list1 = new ArrayList<ListNode>();
		ArrayList<ListNode> list2 = new ArrayList<ListNode>();
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		
		ListNode head = null;
		
		int len1=-1, len2=-1; // index
		
		while(l1 != null) {
			list1.add(l1);
			len1++;
			l1 = l1.next;
		}
		while(l2 != null) {
			list2.add(l2);
			len2++;
			l2 = l2.next;
		}
		
		int extra = 0;
		
		int i=0, j=0;
		
		while(i<=len1 || j<=len2) {
			
			int num = 0;
			if(i > len1) {
				num = list2.get(j).val + extra;
				if(num >= 10) {
					extra = 1;
					num = num-10;
				} else {
					extra = 0;
				}
				j++;
				
			} else if(j > len2) {
				num = list1.get(i).val + extra;
				if(num >= 10) {
					extra = 1;
					num = num-10;
				} else {
					extra = 0;
				}
				i++;
			} else {
				num = list1.get(i).val + list2.get(j).val + extra;
				if(num >= 10) {
					extra = 1;
					num = num-10;
				} else {
					extra = 0;
				}
				i++;
				j++;
			}
			
			
			head = new ListNode(num);
			list.add(head);
			
		}
		
		if(extra == 1) {
			head = new ListNode(1);
			list.add(head);
		}
		
		for(int k=0; k<list.size()-1; k++) {
			list.get(k).next = list.get(k+1);
		}
		
		return list.get(0);
		
    }

	
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	 
	 public static void main(String[] args) {
		new Solution_02().test();
	}

	private void test() {
		ListNode n1 = new ListNode(1);
		
		ListNode n4 = new ListNode(9);
		ListNode n5 = new ListNode(9);
		n4.next = n5;
		
		System.out.println(addTwoNumbers(n1, n4));
		
	}
	 

}
