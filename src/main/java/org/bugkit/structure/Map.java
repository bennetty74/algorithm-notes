package org.bugkit.structure;

/**
 * @author bennetty74
 * @since 2021.10.27
 */
public interface Map<K,V> {

    /**
     * Test weather the map contains the element with specific key
     * @param key the specific key
     * @return true if contains, false otherwise
     */
    boolean contains(K key);

    /**
     * Put key and value into map
     * @param key key
     * @param value value
     * @return true if put success, false otherwise
     */
    boolean put(K key, V value);

    /**
     * Get corresponds value by key
     * @param key key
     * @return value
     */
    V get(K key);
}
