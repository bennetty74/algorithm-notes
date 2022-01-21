package org.bugkit.structure;

/**
 * @author bugkit
 * @since 2022.1.21
 */
public class LRUCache {

    private final java.util.Map<Integer, Integer> lruMap;
    private final java.util.LinkedList<Integer> list;
    private int size = 0;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.lruMap = new java.util.HashMap<>(capacity);
        this.list = new java.util.LinkedList<>();
    }

    public int get(int key) {
        Integer value = lruMap.get(key);
        // 添加到头部
        list.addFirst(list.removeLast());
        return value == null ? -1 : value;
    }

    public void put(int key, int value) {
        if (oversize()) {
            removeLRU();
        }
        size = oversize() ? capacity : size + 1;
        lruMap.put(key, value);
        // 添加到头部
        list.addFirst(key);
    }


    private boolean oversize() {
        return size == capacity;
    }

    /**
     * 移除链表最后一个元素
     */
    private void removeLRU() {
        int key = list.removeLast();
        lruMap.remove(key);
    }


}
