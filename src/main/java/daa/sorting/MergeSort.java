package com.daa.sorting;

import com.daa.metrics.Metrics;
import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] array) {
        if (array.length <= 10) {
            insertionSort(array);
        } else {
            if (array.length < 2) return;
            int mid = array.length / 2;
            int[] left = Arrays.copyOfRange(array, 0, mid);
            int[] right = Arrays.copyOfRange(array, mid, array.length);

            Metrics.updateRecursionDepth(Metrics.getMaxRecursionDepth() + 1);
            mergeSort(left);
            mergeSort(right);

            Metrics.updateRecursionDepth(Metrics.getMaxRecursionDepth() - 1);
            merge(array, left, right);
        }
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            Metrics.incrementComparisons();
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) array[k++] = left[i++];
        while (j < right.length) array[k++] = right[j++];
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
