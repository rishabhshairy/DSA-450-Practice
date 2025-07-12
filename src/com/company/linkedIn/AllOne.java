package com.company.linkedIn;

import java.util.*;

public class AllOne {

    static class Node {
        int freq;
        Node prev, next;
        Set<String> keys = new HashSet<>();

        public Node(int freq) {
            this.freq = freq;
        }
    }

    Node head, tail;
    Map<String, Node> map = new HashMap<>();

    public AllOne() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
//        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    public void dec(String key) {

    }

    public String getMaxKey() {
        return "";
    }

    public String getMinKey() {
        return "";
    }

/**
 * Below solution is O(nLogn)
 */
/*    TreeMap<String, Integer> map;
    TreeSet<Pair> set;

    public AllOne() {
        map = new TreeMap<>();
        set = new TreeSet<>((x, y) -> x.value.equals(y.value) ? x.key.compareTo(y.key) : x.value - y.value);
    }

    public void inc(String key) {
        int x = map.getOrDefault(key, 0);
        set.remove(new Pair(x, key));
        map.put(key, x + 1);
        set.add(new Pair(x + 1, key));
    }

    public void dec(String key) {
        int x = map.get(key);
        set.remove(new Pair(x, key));
        if (x == 0) {
            map.remove(key);
            return;
        } else {
            map.put(key, x - 1);
            set.add(new Pair(x - 1, key));
        }
    }

    public String getMaxKey() {
        if (map.isEmpty()) {
            return "";
        }
        return set.last().key;
    }

    public String getMinKey() {
        if (map.isEmpty()) {
            return "";
        }
        return set.first().key;
    }

    static class Pair {
        Integer value;
        String key;

        public Pair(Integer value, String key) {
            this.value = value;
            this.key = key;
        }
    }*/
}
