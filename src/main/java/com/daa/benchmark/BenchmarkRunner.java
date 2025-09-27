package com.daa.benchmark;

import com.daa.sorting.MergeSort;
import com.daa.select.DeterministicSelect;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import java.util.Random;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class BenchmarkRunner {

    private int[] array;
    private int k = 5;

    @Setup(Level.Iteration)
    public void setUp() {
        array = new int[1000];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1000);
        }
    }

    @Benchmark
    public void benchmarkSort() {
        MergeSort.mergeSort(Arrays.copyOf(array, array.length));
    }

    @Benchmark
    public int benchmarkSelect() {
        return DeterministicSelect.deterministicSelect(Arrays.copyOf(array, array.length), k);
    }
}
