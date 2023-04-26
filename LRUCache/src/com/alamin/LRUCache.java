package com.alamin;

import java.util.HashMap;

public class LRUCache {
	private int capacity;
	private HashMap<Integer , Node> map = new HashMap<>();
	private Node head = null;
	private Node tail = null;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	
    //	The get method retrieves an item from the cache. If the item is already in the cache,
    //	it is moved to the front of the list (since it is now the most recently used item)
    //	and its value is returned. If the item is not in the cache, -1 is returned.

	public int get(int key) {
		if(map.containsKey(key)) {
			Node node = map.get(key);
			removeFromLL(node);
			addToTop(node);
			return node.value;
		}else {
			return -1;
		}
		
	}
    // The add method adds a node to the front of the list. 
	private void addToTop(Node node) {
		Node newNode = new Node(node.key , node.value);
		newNode.prev = null;
		newNode.next = head;
		if(head != null) {
			head.prev = newNode;
		}
		head = newNode;
		if(tail == null) {
			tail= newNode;
		}
		
	}
	
    //remove method removes a node from the list
	private void removeFromLL(Node node) {
		if(node.prev != null) {
			node.prev.next = node.next;
		}else {
			head = node.next;
		}
		if(node.next != null) {
			node.next.prev = node.prev;
		}else {
			tail = node.prev;
		}
		node.prev = null;
		node.next = null;
	}
}
