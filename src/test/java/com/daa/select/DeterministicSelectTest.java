package com.daa.select;

import com.daa.metrics.Metrics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeterministicSelectTest {

    @Test
    void testSelectSimple() {
        int[] array = {7, 2, 5};
        Metrics.reset();
        int median = DeterministicSelect.deterministicSelect(array, 1);
        assertEquals(5, median);
        assertTrue(Metrics.getComparisonCount() >= 0);
        assertTrue(Metrics.getMaxRecursionDepth() > 0);
    }

    @Test
    void testSelectWithDuplicates() {
        int[] array = {3, 1, 3, 2, 2};
        Metrics.reset();
        int median = DeterministicSelect.deterministicSelect(array, 2);
        assertEquals(2, median);
    }

    @Test
    void testSelectSingleElement() {
        int[] array = {42};
        Metrics.reset();
        int val = DeterministicSelect.deterministicSelect(array, 0);
        assertEquals(42, val);
    }

    @Test
    void testSelectEmptyArray() {
        int[] empty = {};
        Metrics.reset();
        assertThrows(IllegalArgumentException.class, () -> {
            DeterministicSelect.deterministicSelect(empty, 0);
        });
    }

    @Test
    void testSelectLargeArray() {
        int[] array = {9, 1, 5, 3, 7, 2, 6, 4, 8};
        Metrics.reset();
        int val = DeterministicSelect.deterministicSelect(array, 4); // 5-й по порядку
        assertEquals(5, val);
    }
}
