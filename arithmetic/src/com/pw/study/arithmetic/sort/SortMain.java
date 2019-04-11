package com.pw.study.arithmetic.sort;


import com.pw.study.arithmetic.model.Data;

public class SortMain {

    public  static void  main(String[] args){
        Data []  array=Data.getDisOrderDataArray(100,1000);
        QuickSort.sort(array);
        QuickSort.show(array);
    }

}
