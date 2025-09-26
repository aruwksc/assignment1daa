package com.daa.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortUtilsTest {

    @Test
    public void testSwap() {
        int[] array = {1, 2, 3};
        SortUtils.swap(array, 0, 2);
        assertArrayEquals(new int[]{3, 2, 1}, array);
    }

    @Test
    public void testPartition() {
        int[] array = {10, 80, 30, 90, 40, 50, 70};
        int pi = SortUtils.partition(array, 0, array.length - 1);
        assertEquals(4, pi);
    }

    @Test
    public void testShuffle() {
        int[] array = {1, 2, 3, 4, 5};
        SortUtils.shuffle(array);
        assertNotEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    public void testIsValidIndex() {
        int[] array = {1, 2, 3};
        assertTrue(SortUtils.isValidIndex(array, 1));
        assertFalse(SortUtils.isValidIndex(array, 3));
    }
}
