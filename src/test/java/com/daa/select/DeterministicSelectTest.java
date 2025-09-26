package com.daa.select;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeterministicSelectTest {

    @Test
    public void testDeterministicSelect() {
        int[] array = {10, 80, 30, 90, 40, 50, 70};
        int k = 3;
        int result = DeterministicSelect.deterministicSelect(array, k);
        assertEquals(50, result);
    }

    @Test
    public void testDeterministicSelectWithSmallArray() {
        int[] array = {7, 1, 3};
        int k = 1;
        int result = DeterministicSelect.deterministicSelect(array, k);
        assertEquals(3, result);
    }

    @Test
    public void testDeterministicSelectWithEmptyArray() {
        int[] array = {};
        int k = 0;
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            DeterministicSelect.deterministicSelect(array, k);
        });
    }

    @Test
    public void testDeterministicSelectWithSingleElement() {
        int[] array = {5};
        int k = 0;
        int result = DeterministicSelect.deterministicSelect(array, k);
        assertEquals(5, result);
    }
}
