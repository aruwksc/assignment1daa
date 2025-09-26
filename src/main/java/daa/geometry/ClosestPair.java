package com.daa.geometry;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class ClosestPair {

    public static double closestPair(Point[] points) {
        if (points == null || points.length < 2) {
            throw new IllegalArgumentException("At least two points are required");
        }
        Point[] sortedByX = Arrays.copyOf(points, points.length);
        Arrays.sort(sortedByX, Comparator.comparingDouble(p -> p.x));
        return closestPairRec(sortedByX);
    }

    private static double closestPairRec(Point[] points) {
        if (points.length <= 3) {
            return bruteForce(points);
        }

        int mid = points.length / 2;
        Point midPoint = points[mid];


        Point[] left = Arrays.copyOfRange(points, 0, mid);
        Point[] right = Arrays.copyOfRange(points, mid, points.length);

        double leftMin = closestPairRec(left);
        double rightMin = closestPairRec(right);

        double minDist = Math.min(leftMin, rightMin);


        List<Point> stripList = new ArrayList<>();
        for (Point p : points) {
            if (Math.abs(p.x - midPoint.x) < minDist) {
                stripList.add(p);
            }
        }


        Point[] strip = new Point[stripList.size()];
        stripList.toArray(strip);

        return Math.min(minDist, stripClosest(strip, minDist));
    }


    private static double stripClosest(Point[] strip, double minDist) {
        double min = minDist;
        Arrays.sort(strip, Comparator.comparingDouble(p -> p.y));  // Сортировка по y-координате

        for (int i = 0; i < strip.length; i++) {
            for (int j = i + 1; j < strip.length && (strip[j].y - strip[i].y) < min; j++) {
                if (strip[i] == null || strip[j] == null) {
                    continue;  // Пропускаем null элементы
                }
                double dist = distance(strip[i], strip[j]);
                if (dist < min) {
                    min = dist;
                }
            }
        }
        return min;
    }


    private static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }


    private static double bruteForce(Point[] points) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double dist = distance(points[i], points[j]);
                if (dist < min) {
                    min = dist;
                }
            }
        }
        return min;
    }


    public static class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
