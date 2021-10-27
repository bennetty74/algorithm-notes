package org.bugkit.structure;

import java.util.Objects;

/**
 * key and value are not permitted null
 * @author bennetty74
 * @since 2021.10.24
 */
public class HashMap <K,V> implements Map<K,V>{

    private Entry<K,V>[] entries;
    private final double loadFactor = 0.75d;
    private int capacity = 8;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public HashMap() {
        entries = new Entry[this.capacity];
    }

    @SuppressWarnings("unchecked")
    public HashMap(int capacity) {
        this.capacity = capacity;
        entries = new Entry[capacity];
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    public boolean put(K key, V value) {
        if (Objects.isNull(key) || Objects.isNull(value)) {
            throw new IllegalArgumentException("Key or value is null");
        }
        int idx = getIndex(key);
        // if null, put in entries array
        if (Objects.isNull(entries[idx])) {
            entries[idx] = new Entry<>(key, value);
        } else {
            // else put at the head of Entry list
            Entry<K, V> newEntry = new Entry<>(key, value);
            newEntry.next = entries[idx];
            entries[idx] = newEntry;
        }
        // if load factor greater than 0.75, then rehash
        if (size++ / (double) capacity > 0.75f) {
            rehash();
        }
        return true;
    }

    private void rehash() {
        // TODO rehash
        System.out.println("TODO REHASH");
    }

    public V get(K key) {
        if (Objects.isNull(key)) {
            throw new IllegalArgumentException("Key is null");
        }
        // get idx by key's hashCode
        int idx = getIndex(key);
        Entry<K, V> entry = entries[idx];
        if (!Objects.isNull(entry)) {
            while (!Objects.isNull(entry)) {
                if (key.equals(entry.key)) {
                    return entry.value;
                }
                entry = entry.next;
            }
        }
        // not found the specific key, return null
        return null;
    }

    private int getIndex(K key) {
        return key.hashCode() % capacity;
    }

    private static class Entry<K,V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        Entry<K,V> next;
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(6);
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        System.out.println("Get one: " + map.get("one"));
        System.out.println("Get two: " + map.get("two"));
        System.out.println("Get three: " + map.get("three"));
        System.out.println("Get four: " + map.get("four"));
        System.out.println("Get five: " + map.get("five"));
        System.out.println("Get six: " + map.get("six"));
        System.out.println("Get seven: " + map.get("seven"));
    }
}
