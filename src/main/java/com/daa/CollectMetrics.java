package com.daa.metrics;

import com.daa.sorting.MergeSort;
import com.daa.sorting.QuickSort;
import com.daa.select.DeterministicSelect;

import java.util.Random;
import java.util.Arrays;

public class CollectMetrics {

    public static void main(String[] args) {
        int[] sizes = {10, 50, 100, 500}; // размеры массивов
        String csvFile = "metrics.csv";

        // Заголовок CSV
        try (java.io.FileWriter writer = new java.io.FileWriter(csvFile)) {
            writer.append("Algorithm,n,time_ms,comparisons,depth\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int n : sizes) {
            int[] array = new int[n];
            Random rand = new Random();
            for (int i = 0; i < n; i++) array[i] = rand.nextInt(n);

            // --- MergeSort ---
            Metrics.reset();
            int[] arrMerge = array.clone();
            long start = System.nanoTime();
            MergeSort.mergeSort(arrMerge);
            long end = System.nanoTime();
            Metrics.writeMetricsToCSV(csvFile, "MergeSort", n, (end - start)/1e6);

            // --- QuickSort ---
            Metrics.reset();
            int[] arrQuick = array.clone();
            start = System.nanoTime();
            QuickSort.quickSort(arrQuick);
            end = System.nanoTime();
            Metrics.writeMetricsToCSV(csvFile, "QuickSort", n, (end - start)/1e6);

            // --- DeterministicSelect ---
            Metrics.reset();
            int[] arrSelect = array.clone();
            int k = n/2;
            start = System.nanoTime();
            DeterministicSelect.deterministicSelect(arrSelect, k);
            end = System.nanoTime();
            Metrics.writeMetricsToCSV(csvFile, "DeterministicSelect", n, (end - start)/1e6);
        }

        System.out.println("Metrics collected and saved to " + csvFile);
    }
}
