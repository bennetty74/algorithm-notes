package org.bugkit.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author bugkit
 * @since 2021.12.28
 */
class MinStackTest {

    @Test
    void totalTest() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertEquals(-3, minStack.getMin());
        minStack.pop();
        assertEquals(0,minStack.top());
        assertEquals(-2,minStack.getMin());
    }

    @Test
    void totalTest1() {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);

        minStack.pop();
        minStack.pop();
        minStack.pop();
        assertEquals(2,minStack.getMin());
    }
}