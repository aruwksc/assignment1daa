package com.daa.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Scope;

import com.daa.sorting.MergeSort;
import com.daa.select.DeterministicSelect;

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
