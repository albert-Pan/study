package com.pw.study.arithmetic.sort;

public  class SortExample {


    public static boolean less(Comparable a,Comparable b){
        if(a.compareTo(b)<0){
            return true;
        }else {
            return false;
        }
    }

    public static void exChange(Comparable [] a ,int i , int j){
        Comparable temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void show(Comparable [] a){
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }

    public static  boolean  isSort(Comparable [] a){
        for (int i = 0; i <a.length ; i++) {
            if(less(a[i+1],a[i])){
                return false;
            }
        }
        return true;
    }

}
