package com.daa.geometry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClosestPairTest {

    @Test
    public void testClosestPair() {
        ClosestPair.Point[] points = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(1, 1),
                new ClosestPair.Point(2, 2),
                new ClosestPair.Point(3, 3)
        };

        double result = ClosestPair.closestPair(points);
        assertEquals(Math.sqrt(2), result, 0.001);
    }

    @Test
    public void testClosestPairWithSinglePoint() {
        ClosestPair.Point[] points = { new ClosestPair.Point(0, 0) };
        assertThrows(IllegalArgumentException.class, () -> {
            ClosestPair.closestPair(points);
        });
    }

    @Test
    public void testClosestPairWithTwoPoints() {
        ClosestPair.Point[] points = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(3, 4)
        };

        double result = ClosestPair.closestPair(points);
        assertEquals(5.0, result, 0.001);
    }
}
