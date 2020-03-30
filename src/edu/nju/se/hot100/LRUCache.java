package edu.nju.se.hot100;

import java.util.*;

/**
 * LRU缓存机制 O(1) 时间复杂度
 * 
 * @author zongk
 *
 */
public class LRUCache {

	Map<Integer, Node> nodes;

	Node head, tail;

	int capacity;

	int size;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		nodes = new HashMap<>(capacity);
	}

	public int get(int key) {
		Node res = nodes.get(Integer.valueOf(key));
		if (res == null) {
			return -1;
		}

		if (res == tail) {
			return res.value;
		}

		if (res == head) {
			head = res.next;
			head.prev = null;
		} else {
			res.prev.next = res.next;
			if (res.next != null)
				res.next.prev = res.prev;
		}

		res.prev = tail;
		tail.next = res;
		tail = res;
		res.next = null;

		return res.value;
	}

	public void put(int key, int value) {
		Node old = nodes.get(Integer.valueOf(key));
		if(old != null) {
			old.value = value;
			if(old != tail) {
				if(old == head) {
					head = head.next;
					head.prev = null;
				} else {
					old.prev.next = old.next;
					old.next.prev = old.prev;
				}
				old.prev = tail;
				tail.next = old;
				tail = old;
				old.next = null;
			}
			return;
		}
		
		Node node = new Node(key, value);
		if (head == null) {
			head = node;
			tail = node;
			size++;
			nodes.put(Integer.valueOf(key), node);
		} else {
			if (size == capacity) {
				nodes.remove(Integer.valueOf(head.key));
				if (head == tail) {
					head = node;
					tail = node;
				} else {
					head = head.next;
					head.prev = null;
					node.prev = tail;
					tail.next = node;
					tail = node;
				}
				nodes.put(Integer.valueOf(key), node);
			} else {
				node.prev = tail;
				tail.next = node;
				tail = node;
				size++;
				nodes.put(Integer.valueOf(key), node);
			}
		}
	}

	class Node {
		int key;
		int value;
		Node next;
		Node prev;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

}
