package com.alamin;
public class Client {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> hm = new CustomHashMap<>();
        hm.put("one", 1);
        hm.put("two", 2);
        hm.put("three", 3);

        System.out.println(hm.size());
        System.out.println(hm.get("two"));
        hm.remove("two");
        System.out.println(hm.size());
    }
}
