package com.daa;

import com.daa.sorting.MergeSort;
import com.daa.metrics.Metrics;

public class Main {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 3, 1, 4};
        System.out.println("Before merging:");
        printArray(array);

        MergeSort.mergeSort(array);

        System.out.println("After merging:");
        printArray(array);

        Metrics.writeMetricsToCSV();
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
