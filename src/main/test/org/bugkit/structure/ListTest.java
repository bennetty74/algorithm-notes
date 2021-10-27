package org.bugkit.structure;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author bugkit
 * @since 2021.10.27
 */
class ListTest {

    private List<Integer> list;

    @BeforeEach
    public void setup() {
        list = new LinkedList<>();
        assertTrue(list.add(1));
        assertTrue(list.add(2));
    }

    @AfterEach
    public void print() {
        System.out.println(list);
    }

    @Test
    void get() {
        assertTrue(list.add(3));
        assertEquals(1, list.get(0)) ;
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }


    @Test
    void removeByElement() {
        assertTrue(list.remove(new Integer(1)));
        assertEquals(1, list.size());
    }

    @Test
    void addWithIndex() {
        assertTrue(list.add(3, 2));
        assertEquals(3,list.size());
    }

    @Test
    void add() {
        assertTrue(list.add(3));
        assertEquals(3,list.size());
    }

    @Test
    void removeByIndex() {
        assertEquals(1,list.remove(0));
        assertEquals(1,list.size());
    }

    @Test
    void contains() {
        assertTrue(list.contains(1));
    }


}