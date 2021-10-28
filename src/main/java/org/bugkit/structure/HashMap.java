package org.bugkit.structure;

import java.util.Arrays;
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
        int idx = getIndex(key);
        if (entries[idx] == null) {
            return false;
        }
        Entry<K, V> entry = entries[idx];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return true;
            }
            entry = entry.next;
        }
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
        capacity = 2 * capacity;
        Entry<K, V>[] oldEntries = Arrays.copyOf(this.entries, capacity);
        entries = new Entry[capacity];
        for (Entry<K, V> oldEntry : oldEntries) {
            if (oldEntry != null) {
                put(oldEntry.key, oldEntry.value);
            }
        }
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HashMap {");
        for (int i = 0; i < capacity; i++) {
            if (entries[i] != null) {
                Entry<K, V> entry = entries[i];
                while (entry != null) {
                    sb.append(entry.key).append("=").append(entry.value).append(",");
                    entry = entry.next;
                }
            }
        }
        sb.append("}");
        return sb.toString();
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


}
