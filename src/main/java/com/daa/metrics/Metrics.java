package com.daa.metrics;

import java.io.FileWriter;
import java.io.IOException;

public class Metrics {
    private static int comparisonCount = 0;
    private static int recursionDepth = 0;
    private static int maxRecursionDepth = 0;

    public static void reset() {
        comparisonCount = 0;
        recursionDepth = 0;
        maxRecursionDepth = 0;
    }

    public static void incrementComparison() {
        comparisonCount++;
    }

    public static void enterRecursion() {
        recursionDepth++;
        if (recursionDepth > maxRecursionDepth) maxRecursionDepth = recursionDepth;
    }

    public static void exitRecursion() {
        recursionDepth--;
    }

    public static int getComparisonCount() {
        return comparisonCount;
    }

    public static int getMaxRecursionDepth() {
        return maxRecursionDepth;
    }

    // --- Новый метод для записи в CSV ---
    public static void writeMetricsToCSV(String fileName, String algorithm, int n, double timeMs) {
        try (FileWriter writer = new FileWriter(fileName, true)) { // true → дозапись
            writer.append(algorithm).append(",");
            writer.append(String.valueOf(n)).append(",");
            writer.append(String.valueOf(timeMs)).append(",");
            writer.append(String.valueOf(comparisonCount)).append(",");
            writer.append(String.valueOf(maxRecursionDepth)).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
