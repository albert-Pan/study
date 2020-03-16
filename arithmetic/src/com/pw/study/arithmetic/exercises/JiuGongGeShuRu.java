package com.pw.study.arithmetic.exercises;

import java.util.Scanner;

/**
 * 假设有九宫格输入法键盘布局如下：
 *
 *      [ 1,.?! ] [ 2ABC ] [ 3DEF  ]
 *      [ 4GHI  ] [ 5JKL ] [ 6MNO  ]
 *      [ 7PQRS ] [ 8TUV ] [ 9WXYZ ]
 *                [ 0空  ]
 *
 * 注意：中括号[ ]仅为了表示键盘的分隔，不是输入字符。每个中括号中，位于首位的数字字符即是键盘的按键，按一下即可输入该数字字符。多次按同一个键，则输入的字符依次循环轮流，例如按两次3，则输入D；按5次7，则输入S；按6次2，则输入A。按键0的输入组合是0和空格字符，即按两次0输入空格。
 *
 * 你需要对于给定的按键组合，给出该组合对应的文本。
 * 输入格式:
 *
 * 输入在一行中给出数个字符的按键组合（例如 999 表示按3次9），每个字符的按键组合之间用空格间隔，最后一个输入法组合之后以换行结束。输入数据至少包括一个字符的按键组合，且输入总长度不超过500个字符。
 * 输出格式:
 *
 * 在一行中输出该按键组合对应的文本。
 * 输入样例:
 *
 * 22 5555 22 666 00 88 888 7777 4444 666 44
 *
 * 输出样例:
 * ALAN TURING
 */
public class JiuGongGeShuRu {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
		for(int j=0;scanner.hasNext()&&j<500;j++){
        String n =scanner.next();
        int length = n.length();
        char c = n.charAt(0);
        switch (c){
            case '0':
                if(length%2==1) {System.out.print("0");}
                if(length%2==0) {System.out.print(" ");}
                break;
            case '1':
                if(length%5==1) {System.out.print("1");}
                if(length%5==2) {System.out.print(",");}
                if(length%5==3) {System.out.print(".");}
                if(length%5==4) {System.out.print("?");}
                if(length%5==0) {System.out.print("!");}
                break;
            case '2':
                if(length%4==1) {System.out.print("2");}
                if(length%4==2) {System.out.print("A");}
                if(length%4==3) {System.out.print("B");}
                if(length%4==0) {System.out.print("C");}
                break;
            case '3':
                if(length%4==1) {System.out.print("3");}
                if(length%4==2) {System.out.print("D");}
                if(length%4==3) {System.out.print("E");}
                if(length%4==0) {System.out.print("F");}
                break;
            case '4':
                if(length%4==1) {System.out.print("4");}
                if(length%4==2) {System.out.print("G");}
                if(length%4==3) {System.out.print("H");}
                if(length%4==0) {System.out.print("I");}
                break;
            case '5':
                if(length%4==1) {System.out.print("5");}
                if(length%4==2) {System.out.print("J");}
                if(length%4==3) {System.out.print("K");}
                if(length%4==0) {System.out.print("L");}
                break;
            case '6':
                if(length%4==1) {System.out.print("6");}
                if(length%4==2) {System.out.print("M");}
                if(length%4==3) {System.out.print("N");}
                if(length%4==0) {System.out.print("O");}
                break;
            case '7':
                if(length%5==1) {System.out.print("7");}
                if(length%5==2) {System.out.print("P");}
                if(length%5==3) {System.out.print("Q");}
                if(length%5==4) {System.out.print("R");}
                if(length%5==0) {System.out.print("S");}
                break;
            case '8':
                if(length%4==1) {System.out.print("8");}
                if(length%4==2) {System.out.print("T");}
                if(length%4==3) {System.out.print("U");}
                if(length%4==0) {System.out.print("V");}
                break;
            case '9':
                if(length%5==1) {System.out.print("9");}
                if(length%5==2) {System.out.print("W");}
                if(length%5==3) {System.out.print("X");}
                if(length%5==4) {System.out.print("Y");}
                if(length%5==0) {System.out.print("Z");}
                break;
            default:
                break;
        }
     }
    }
}









