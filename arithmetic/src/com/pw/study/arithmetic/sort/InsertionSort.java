package com.pw.study.arithmetic.sort;

public class InsertionSort extends  SortExample {

    public static void sort(Comparable[] a) {
        int length=a.length;
        for (int i = 1; i <length ; i++) {
            for (int j = i; j >0 &&less(a[j],a[j-1]); j--) {
                exChange(a,j-1,j);
            }
        }
    }
}
