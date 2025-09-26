package com.daa.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {

    @Test
    public void testMergeSort() {
        int[] array = {5, 2, 8, 3, 1, 4};
        MergeSort.mergeSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 8}, array);
    }

    @Test
    public void testMergeSortWithSmallArray() {
        int[] array = {7, 1, 3};
        MergeSort.mergeSort(array);
        assertArrayEquals(new int[]{1, 3, 7}, array);
    }

    @Test
    public void testMergeSortWithEmptyArray() {
        int[] array = {};
        MergeSort.mergeSort(array);
        assertArrayEquals(new int[]{}, array);
    }
}
x