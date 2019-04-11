package com.pw.study.arithmetic.sort;

public class QuickSort extends SortExample {

    public static void sort(Comparable[] a) {
        sort(a,0,a.length-1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = position(a, lo, hi);
        sort(a, lo, index - 1);
        sort(a, index + 1, hi);
    }

    private static int position(Comparable[] a, int lo, int hi) {
        Comparable v = a[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(a[++i], v)) {
                if (i >= hi) {
                    break;
                }
            }

            while (less(v, a[--j])) {
                if (j <= lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exChange(a, i, j);
        }
        exChange(a, lo, j);
        return j;
    }


}
