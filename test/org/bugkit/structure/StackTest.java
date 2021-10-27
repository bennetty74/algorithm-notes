package org.bugkit.structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author bugkit
 * @since 2021.10.27
 */
class StackTest {

    private Stack<Integer> stack;

    @BeforeEach
    public void setup() {
        stack = new LinkedList<>();
        assertTrue(stack.push(1));
        assertTrue(stack.push(2));
    }

    @Test
    void push() {
        assertTrue(stack.push(3));
        assertEquals(3,stack.size());
    }

    @Test
    void pop() {
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertEquals(0,stack.size());
    }
}