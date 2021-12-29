package org.bugkit.structure;

import org.bugkit.structure.LinkedList;
import org.bugkit.structure.Queue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author bugkit
 * @since 2021.10.27
 */
class QueueTest {

    private Queue<Integer> queue ;


    @BeforeEach
    public void setupTest() {
        queue = new LinkedList<>();
        assertTrue(queue.offer(1));
        assertTrue(queue.offer(2));
    }

    @AfterEach
    public void reset() {
        assertTrue(queue.offer(1));
        assertTrue(queue.offer(2));
    }

    @Test
    void offerTest() {
        assertTrue(queue.offer(3));
        assertEquals(3,queue.size());
    }

    @Test
    void pollTest() {
        assertEquals(1,queue.poll());
        assertEquals(2,queue.poll());
        assertEquals(0,queue.size());
    }

    @Test
    void peekTest() {
        assertEquals(1, queue.peek());
        assertEquals(2, queue.size());
    }
}