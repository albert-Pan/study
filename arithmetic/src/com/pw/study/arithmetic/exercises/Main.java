package com.pw.study.arithmetic.exercises;

import java.util.*;

/**
 * ABCCBCCCAA
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String data=in.next();
            char[]  s=data.toCharArray();
          while (true){
              StringBuilder res=new StringBuilder("");
              for (int i = 0; i <s.length ; ++i) {
                 if ((i==s.length-1)||(s[i] != s[i+1])) {
                      res.append(s[i]+"");
                  }else {
                      ++i;
                  }
              }
              if(res.toString().equals(new String(s))){
                  break;
              }else {
                  s=res.toString().toCharArray();
              }
          }
          if(s==null||s.length<=0){
              System.out.println("YES");
          }else {
              System.out.println("NO");
          }
        }
    }
}