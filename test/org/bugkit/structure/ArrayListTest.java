package org.bugkit.structure;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author bugkit
 * @since 2021.10.29
 */
class ArrayListTest {

    private List<Integer> list;

    @BeforeEach
    public void setup() {
        list = new ArrayList<>();
        assertTrue(list.add(1));
        assertTrue(list.add(3));
    }

    @AfterEach
    public void print() {
        System.out.println(list);
    }

    @Test
    void get() {
        assertEquals(1,list.get(0));
        assertEquals(3,list.get(1));
    }

    @Test
    void removeElement() {
        assertTrue(list.remove(new Integer(3)));
        assertEquals(1, list.size());
    }

    @Test
    void addWithIndex() {
        assertTrue(list.add(0, 0));
        assertTrue(list.add(2, 2));
        assertTrue(list.add(4, 4));
        assertEquals(5, list.size());
    }

    @Test
    void add() {
        assertTrue(list.add(4));
        assertEquals(4, list.get(2));
        assertEquals(3,list.size());
    }

    @Test
    void removeWithIndex() {
        assertEquals(1, list.remove(0));
        assertEquals(1, list.size());
    }

    @Test
    void contains() {
        assertTrue(list.contains(1));
    }
}