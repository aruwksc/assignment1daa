package com.daa.metrics;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Metrics {
    private static int comparisonCount = 0;
    private static int recursionDepth = 0;
    private static int maxRecursionDepth = 0;

    public static void incrementComparisons() {
        comparisonCount++;
    }

    public static void updateRecursionDepth(int depth) {
        recursionDepth = depth;
        if (depth > maxRecursionDepth) {
            maxRecursionDepth = depth;
        }
    }

    public static void writeMetricsToCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("metrics.csv"))) {
            writer.println("Comparisons,Max Recursion Depth");
            writer.println(comparisonCount + "," + maxRecursionDepth);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reset() {
        comparisonCount = 0;
        maxRecursionDepth = 0;
        recursionDepth = 0;
    }

    public static int getComparisonCount() {
        return comparisonCount;
    }

    public static int getMaxRecursionDepth() {
        return maxRecursionDepth;
    }
}
