package org.bugkit.structure;

/**
 * @author bugkit
 * @since 2021.10.29
 */
public abstract class AbstractList<E> implements List<E> {

    protected int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
