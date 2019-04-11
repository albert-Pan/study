package com.pw.study.arithmetic.model;

import java.util.Random;

public class Data implements Comparable<Data> {
    int val;

    public Data() {
    }

    public Data(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public static  Data[]  getDisOrderDataArray(int length,int bound){
        Random random=new Random();
        Data [] array=new Data[length];
        for (int i = 0; i <length ; i++) {
            array[i]=new Data(random.nextInt(bound));
        }
        return  array;
    }

    @Override
    public int compareTo(Data o) {
        if(this.val>o.val){
            return 1;
        }else  if(this.val<o.val){
            return -1;
        }
        return 0;

    }

    @Override
    public String toString() {
        return ""+val;
    }
}
