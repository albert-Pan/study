package com.pw.study.arithmetic.sort;


import com.pw.study.arithmetic.model.Data;

public class SortMain {

    public  static void  main(String[] args){
        /*Data []  array=Data.getDisOrderDataArray(100,1000);
        QuickSort.sort(array);
        QuickSort.show(array);*/

        /*Data []  array1=Data.getDisOrderDataArray(100,1000);
        InsertionSort.sort(array1);
        InsertionSort.show(array1);*/

        Data []  array2=Data.getDisOrderDataArray(100,1000);
        /*MergeSort.aux=new Data[array2.length];
        MergeSort.sort(array2,0,array2.length-1);*/
        MergeSort.sort(array2);
        MergeSort.show(array2);


    }

}
