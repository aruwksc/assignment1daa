package com.daa.sorting;

import com.daa.util.SortUtils;

import java.util.Random;

public class QuickSort {

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = SortUtils.partition(array, low, high);


            quickSort(array, low, pi - 1);

            quickSort(array, pi + 1, high);
        }
    }

    public static void shuffleArray(int[] array) {
        SortUtils.shuffle(array);  // Перемешиваем массив
    }
}
