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

}
