package org.bugkit.structure;

/**
 * @author bugkit
 * @since 2021.10.27
 */
public interface List<E> extends Collection<E>{


    /**
     * Get element at indic i of the list
     * @param i indic in the list
     * @return element at indic
     */
    E get(int i);

    /**
     * Rmemove an element at indic i in the list
     * @param i indic in the list
     * @return element at the
     */
    E remove(int i);

    /**
     * Add an element at the specific indic in the list.
     * Eg: add(3,1) into [1,2], it result [1,3,2]
     * @param i indic the element will be inserted
     * @param e an element
     * @return true if element be inserted success, false otherwise
     */
    boolean add(E e,int i);

    /**
     * Add an element into collection
     * @param e element
     * @return true if insert success, false otherwise.
     */
    boolean add(E e);

    /**
     * Remove a specific element in the collection
     * @param e an element will be removed
     * @return true if the element contains and be removed, false otherwise
     */
    boolean remove(E e);

    /**
     * Test weather the collection contains the specific element
     * @param e the specific element
     * @return true if the collection contains the specific element, false otherwise.
     */
    boolean contains(E e);
}
