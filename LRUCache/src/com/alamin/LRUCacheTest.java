package com.alamin;

public class LRUCacheTest {

	public static void main(String[] args) {
		
		LRUCache cache = new LRUCache(3);
		 cache.put("mango", 10);
		 cache.put("apple", 20);
		 cache.put("guava", 30);
		
		 System.out.println(cache.front().key);
		 cache.put("banana", 30);
		 System.out.println(cache.front().key);
		 
		 if(cache.get("mango")== -1){
				System.out.println("apple doesn't exist");
			}

	}

}
