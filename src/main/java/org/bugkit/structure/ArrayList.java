package org.bugkit.structure;

/**
 * @param <E> Type of element
 * @author bugkit
 * @since 2021.10.27
 */
public class ArrayList<E> extends AbstractList<E> implements List<E> {

    private E[] data;

    private int capacity = 8;


    public ArrayList() {
        data = (E[]) new Object[capacity];
    }

    public ArrayList(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
    }

    @Override
    public E get(int i) {
        if (i >= size) {
            throw new IndexOutOfBoundsException("Index " + i + " is out of range " + size);
        }
        return data[i];
    }

    @Override
    public E remove(int i) {
        if (i >= size) {
            throw new IndexOutOfBoundsException("Index " + i + " is out of range " + size);
        }
        E e = data[i];
        System.arraycopy(data, i + 1, data, i, size - i);
        size--;
        return e;
    }

    @Override
    public boolean add(E e, int i) {
        if (i > size) {
            throw new IndexOutOfBoundsException("Index " + i + " is out of range " + size);
        }
        if (size == capacity - 1) {
            resize();
        }
        if (size + 1 - i >= 0)
            System.arraycopy(data, i, data, i + 1, size + 1 - i);
        data[i] = e;
        size++;
        return true;
    }

    @Override
    public boolean add(E e) {
        return add(e, size);
    }

    @Override
    public boolean remove(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayList { ");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]).append(", ");
        }
        sb.replace(sb.length() - 1, sb.length(),"").append(" }");
        return sb.toString();
    }

    private void resize() {
        capacity = capacity * 2;
        E[] newData = (E[]) new Object[capacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }
}
