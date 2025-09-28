package com.daa.select;

import com.daa.metrics.Metrics;
import java.util.Arrays;

public class DeterministicSelect {

    public static int deterministicSelect(int[] array, int k) {
        if (array == null || array.length == 0 || k < 0 || k >= array.length)
            throw new IllegalArgumentException("Invalid array or k");

        Metrics.enterRecursion();

        // edge case: small array
        if (array.length <= 5) {
            Arrays.sort(array);
            Metrics.exitRecursion();
            return array[k];
        }

        int numGroups = (int) Math.ceil(array.length / 5.0);
        int[] medians = new int[numGroups];

        for (int i = 0; i < numGroups; i++) {
            int start = i * 5;
            int end = Math.min(start + 5, array.length);
            int[] group = Arrays.copyOfRange(array, start, end);
            Arrays.sort(group);
            medians[i] = group[group.length / 2];
        }

        int pivot = deterministicSelect(medians, medians.length / 2);

        int[] lows = Arrays.stream(array).filter(x -> x < pivot).toArray();
        int[] highs = Arrays.stream(array).filter(x -> x > pivot).toArray();
        int numPivots = array.length - lows.length - highs.length;

        Metrics.incrementComparison();
        int result;
        if (k < lows.length) result = deterministicSelect(lows, k);
        else if (k < lows.length + numPivots) result = pivot;
        else result = deterministicSelect(highs, k - lows.length - numPivots);

        Metrics.exitRecursion();
        return result;
    }
}
