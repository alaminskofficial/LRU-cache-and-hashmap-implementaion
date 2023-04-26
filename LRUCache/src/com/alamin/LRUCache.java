package com.alamin;

import java.util.HashMap;

public class LRUCache {
	private int capacity;
	private HashMap<String , Node> map = new HashMap<>();
	private Node head = null;
	private Node tail = null;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	
    //	The get method retrieves an item from the cache. If the item is already in the cache,
    //	it is moved to the front of the list (since it is now the most recently used item)
    //	and its value is returned. If the item is not in the cache, -1 is returned.

	public int get(String key) {
		if(map.containsKey(key)) {
			Node node = map.get(key);
			removeFromLL(node);
			addToTop(node);
			return node.value;
		}else {
			return -1;
		}
		
	}
//	The put method adds an item to the cache. If the item is already in the cache, 
//	its value is updated and it is moved to the front of the list.
//	If the cache is already at its capacity, the least recently used item
//	is removed from the cache. Then, a new node is created with the key and value,
//	added to the front of the list, and added to the hashmap.
	
	public void put(String key, int value) {
		if(map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			removeFromLL(node);
			addToTop(node);
		}else {
			if(map.size() == capacity) {
				map.remove(tail.key);
				removeFromLL(tail);
			}
			Node node = new Node(key , value);
			addToTop(node);
			map.put(key, node);
		}
	}
	
	// most recent key 
	
	public Node front() {
        return head;
    }
	
    // The add method adds a node to the front of the list. 
	private void addToTop(Node node) {
		Node newNode = new Node(node.key, node.value);
	    newNode.prev = null;
	    newNode.next = head;
	    if (head != null) {
	        head.prev = newNode;
	    } else {
	        tail = newNode; 
	    }
	    head = newNode;
		
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
