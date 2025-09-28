package com.daa.cli;

import com.daa.sorting.MergeSort;
import com.daa.metrics.Metrics;
import com.daa.geometry.ClosestPair;
import com.daa.geometry.ClosestPair.Point;

import java.util.Arrays;

public class CLI {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: java CLI <algorithm> <input>");
            System.exit(1);
        }

        String algorithm = args[0];
        String input = args[1];

        if ("mergesort".equalsIgnoreCase(algorithm)) {

            String[] numbers = input.split(",");
            int[] array = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
            System.out.println("Before sorting:");
            printArray(array);

            Metrics.reset(); // сбросим метрики перед запуском
            long start = System.nanoTime();
            MergeSort.mergeSort(array);
            long end = System.nanoTime();

            System.out.println("After sorting:");
            printArray(array);

            // Запись метрик в CSV
            Metrics.writeMetricsToCSV("metrics.csv", "MergeSort", array.length, (end - start)/1e6);

        } else if ("closestpair".equalsIgnoreCase(algorithm)) {

            String[] points = input.split(",");
            Point[] pointArray = new Point[points.length / 2];
            for (int i = 0; i < points.length; i += 2) {
                double x = Double.parseDouble(points[i]);
                double y = Double.parseDouble(points[i + 1]);
                pointArray[i / 2] = new Point(x, y);
            }

            double closestDistance = ClosestPair.closestPair(pointArray);
            System.out.println("Closest pair distance: " + closestDistance);

        } else {
            System.out.println("Unknown algorithm: " + algorithm);
        }
    }

    private static void printArray(int[] array) {
        for (int num : array) System.out.print(num + " ");
        System.out.println();
    }
}
