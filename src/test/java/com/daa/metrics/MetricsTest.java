package com.daa.metrics;

import com.daa.sorting.MergeSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MetricsTest {

    @Test
    void testMetricsCountMergeSort() {
        int[] array = {5, 2, 3, 1, 4};
        Metrics.reset();
        MergeSort.mergeSort(array);

        assertArrayEquals(new int[]{1,2,3,4,5}, array);

        assertTrue(Metrics.getComparisonCount() >= 0);
        assertTrue(Metrics.getMaxRecursionDepth() > 0);
    }
}
