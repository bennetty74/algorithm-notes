package org.bugkit.structure;

/**
 * @author bugkit
 * @since 2021.10.27
 */
public interface Queue<E> extends Collection<E>{
    /**
     * Add an element at the last of the queue
     * @param e element
     * @return true if the element is added success, false otherwise
     */
    boolean offer(E e);

    /**
     * Remove and return an element at the first of queue
     * @return the element at the first of queue
     */
    E poll();

    /**
     * Return but not remove the element at the first of queue
     * @return the element at the first of queue
     */
    E peek();

}
