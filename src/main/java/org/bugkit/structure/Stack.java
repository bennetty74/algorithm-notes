package org.bugkit.structure;

/**
 * @author bugkit
 * @since 2021.10.27
 */
public interface Stack <E> extends Collection<E>{

    /**
     * Push an element at the top of the stack
     * @param e element
     * @return true if push success, false otherwise
     */
    boolean push(E e);

    /**
     * Remove and return the element at the top of stack
     * @return the element at the top of stack
     */
    E pop();
}
