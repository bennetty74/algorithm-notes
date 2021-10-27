package org.bugkit.structure;

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
    public void setup() {
        queue = new LinkedList<>();
        assertTrue(queue.offer(1));
        assertTrue(queue.offer(2));
    }

    @Test
    void offer() {
        assertTrue(queue.offer(3));
        assertEquals(3,queue.size());
    }

    @Test
    void poll() {
        assertEquals(1,queue.poll());
        assertEquals(2,queue.poll());
        assertEquals(0,queue.size());
    }

    @Test
    void peek() {
        assertEquals(1, queue.peek());
        assertEquals(2, queue.size());
    }
}