package org.bugkit.structure;

/**
 * A base interface of concrete implemented collections
 * Such as ArrayList, LinkedList,Queue,Stack. etc.
 * @author bugkit
 * @since 2021.10.27
 */
public interface Collection<E> {

    /**
     * Test weather the collection is empty
     * @return true if the collection is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Get number of current elements in this collection
     * @return number of current elements in this collection
     */
    int size();

    /**
     * Return this as an iterator
     * @return a iterator
     */
    default Iterator iterator() {
        return null;
    }

}
