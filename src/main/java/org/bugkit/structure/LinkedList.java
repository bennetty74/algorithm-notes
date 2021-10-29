package org.bugkit.structure;

/**
 * @author bugkit
 * @since 2021.10.27
 */
public class LinkedList<E> extends AbstractList<E> implements List<E>, Queue<E>, Stack<E> {

    private Node<E> head;
    private Node<E> tail;


    public LinkedList() {
        tail = head = null;
    }


    @Override
    public boolean add(E e) {
        return offer(e);
    }

    @Override
    public boolean remove(E e) {
        Node<E> tmp = head;
        int idx = 0;
        while (tmp != null) {
            if (tmp.e.equals(e)) {
                remove(idx);
                return true;
            }
            idx++;
            tmp = tmp.next;
        }
        return false;
    }

    @Override
    public boolean contains(E e) {
        Node<E> tmp = head;
        while (tmp != null) {
            if (tmp.e.equals(e)) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    @Override
    public E get(int i) {
        if (i > size) {
            throw new IndexOutOfBoundsException("Index i " + i + "out of range " + size);
        }
        if (i == 0) {
            return head.e;
        }
        if (i == size - 1) {
            return tail.e;
        }
        Node<E> tmp = head;
        for (int j = 0; j < i; j++) {
            tmp = tmp.next;
        }
        return tmp.e;
    }

    @Override
    public E remove(int i) {
        if (i >= size) {
            throw new IndexOutOfBoundsException("Index i " + i + "out of range " + size);
        }
        if (i == 0) {
            return poll();
        }
        if (i == size - 1) {
            return pop();
        }
        Node<E> tmp = head;
        for (int j = 0; j < i; j++) {
            tmp = tmp.next;
        }
        E e = tmp.next.e;
        tmp.next.next.prev = tmp;
        tmp.next = tmp.next.next;
        return e;
    }

    @Override
    public boolean add(E e, int i) {
        if (i > size) {
            throw new IndexOutOfBoundsException("Index i " + i + "out of range " + size);
        }
        Node<E> node = new Node<>(e);
        if (i == size) {
            return offer(e);
        }
        if (i == 0) {
            node.next = head;
            node.prev = null;
            head = node;
        } else {
            Node<E> tmp = head;
            for (int j = 0; j <= i; j++) {
                tmp = tmp.next;
            }
            tmp.next = node;
            node.prev = tmp;
        }
        size++;
        return false;
    }

    @Override
    public boolean offer(E e) {
        return push(e);
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        E e = head.e;
        if (size() == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return head.e;
    }

    @Override
    public boolean push(E e) {
        Node<E> node = new Node<>(e);
        if (isEmpty()) {
            tail = head = node;
        }else{
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        E e = tail.e;
        if (size() == 1) {
            tail = head = null;
        }else{
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList: { ");
        Node<E> node = head;
        while (node != null) {
            sb.append(node.e).append("<->");
            node = node.next;
        }
        sb.append("null }");
        return sb.toString();
    }

    private static class Node<E> {

        E e;

        Node<E> next;
        Node<E> prev;

        public Node(E e) {
            this.e = e;
        }
    }

}
