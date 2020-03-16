package com.pw.study.arithmetic.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 100个人围成一圈，每个人有一个编码，编号从1开始到100.他们从1开始依次报数，报到为M的人自动退出圈圈，然后下一个人接着从1开始报数，直到剩余的人数小于M。请问最后剩余的人在原先的编号为多少？例如输入M=3时，输出为：“58，91”，输入M=4时，输出为： “34，45， 97”。
 * 如果m小于等于1， 则输出“ERROR!”;
 * 如果m大于等于100，则输出“ERROR!”；
 *
 *     示例
 *     输入
 *     3
 *     输出
 *     58，91
 */
public class BaoShu {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            List<Integer> data=new ArrayList(100);
            for (int i = 1; i <=100 ; i++) {
                data.add(i);
            }
            int input = Integer.parseInt(scan.next());
            if(input<=1||input>=100){
                System.out.println("ERROR!");
            }else {
               int temp=0;
               int temp2=0;
               while (data.size()>=input){
                   temp++;
                  if(temp%input==0){
                      data.remove(temp2);
                      temp=1;
                  }
                  temp2++;
                  if(temp2>data.size()-1){
                      temp2=0;
                  }


               }
                System.out.println(data.toString());
            }
        }
    }



}
