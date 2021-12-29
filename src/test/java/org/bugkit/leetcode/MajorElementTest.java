package org.bugkit.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author bugkit
 * @since 2021.12.29
 */
class MajorElementTest {

    MajorElement majorElement = new MajorElement();

    @Test
    void majorityElementTest() {
        int[] arr = new int[]{2, 2, 1, 1, 1, 2, 2};
        assertEquals(2,majorElement.majorityElement(arr));
        int[] arr1 = new int[]{3, 2, 3};
        assertEquals(3, majorElement.majorityElement(arr1));
    }
}