package com.daa;

import com.daa.sorting.MergeSort;
import com.daa.metrics.Metrics;

public class Main {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 3, 1, 4};
        System.out.println("Before merging:");
        printArray(array);

        Metrics.reset(); // сбрасываем метрики перед запуском

        long start = System.nanoTime();
        MergeSort.mergeSort(array);
        long end = System.nanoTime();

        System.out.println("After merging:");
        printArray(array);

        // Записываем метрики в CSV
        Metrics.writeMetricsToCSV("metrics.csv", "MergeSort", array.length, (end - start)/1e6);
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
