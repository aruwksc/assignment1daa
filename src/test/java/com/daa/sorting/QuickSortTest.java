package com.daa.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    @Test
    public void testQuickSort() {
        int[] array = {5, 2, 8, 3, 1, 4};
        QuickSort.quickSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 8}, array);
    }

    @Test
    public void testQuickSortWithSmallArray() {
        int[] array = {7, 1, 3};
        QuickSort.quickSort(array);
        assertArrayEquals(new int[]{1, 3, 7}, array);
    }

    @Test
    public void testQuickSortWithEmptyArray() {
        int[] array = {};
        QuickSort.quickSort(array);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    public void testQuickSortWithSingleElement() {
        int[] array = {1};
        QuickSort.quickSort(array);
        assertArrayEquals(new int[]{1}, array);
    }
}
