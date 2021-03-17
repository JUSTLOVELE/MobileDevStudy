package com.test;

public class Sort {

    public static void sort(String[] x) {
        sort(x, 0);
    }

    /** Sorts strings destructively. */
    public static void sort(String[] x, int start) {
        if (start == x.length) {
            return;
        }
        // find the smallest item
        int smallestIndex = findSmallest(x, start);
        // move it to the front
        swap(x, 0, smallestIndex);
        // selection sort the rest (using recursion?)
        sort(x, start + 1);

    }
    /** Returns the smallest string in x. */
    public static int findSmallest(String[] x, int start) {
        int smallestIndex = start;
        for (int i = start; i < x.length; i += 1) {
            int cmp = x[i].compareTo(x[smallestIndex]);
            if (cmp < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }
}
