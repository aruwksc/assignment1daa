package com.daa.select;

import java.util.Arrays;

public class DeterministicSelect {

    public static int deterministicSelect(int[] array, int k) {
        if (array.length <= 5) {
            Arrays.sort(array);
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


        int[] left = Arrays.stream(array).filter(x -> x < pivot).toArray();
        int[] right = Arrays.stream(array).filter(x -> x > pivot).toArray();
        if (k < left.length) {
            return deterministicSelect(left, k);
        } else if (k < left.length + right.length) {
            return pivot;
        } else {
            return deterministicSelect(right, k - left.length - 1);
        }
    }
}
