package com.daa.cli;

import com.daa.sorting.MergeSort;
import com.daa.metrics.Metrics;
import com.daa.geometry.ClosestPair;
import com.daa.geometry.ClosestPair.Point;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class CLI {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: java CLI <algorithm> <input> [options]");
            System.exit(1);
        }

        String algorithm = args[0];
        String input = args[1];


        if ("mergesort".equalsIgnoreCase(algorithm)) {

            String[] numbers = input.split(",");
            int[] array = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
            System.out.println("Before sorting:");
            printArray(array);

            MergeSort.mergeSort(array);

            System.out.println("After sorting:");
            printArray(array);
            Metrics.writeMetricsToCSV();
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
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    private static void writeCSV(String filename, String[] headers, String[] data) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (String header : headers) {
                writer.append(header).append(",");
            }
            writer.append("\n");

            for (String value : data) {
                writer.append(value).append(",");
            }
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
