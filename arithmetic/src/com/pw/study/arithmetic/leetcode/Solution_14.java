package com.pw.study.arithmetic.leetcode;

public class Solution_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        String s0=strs[0];
        for (int i = 1; i <strs.length ; i++) {
           while(strs[i].indexOf(s0)!=0){
               s0=s0.substring(0,s0.length()-1);
               if(s0.length()<=0){
                   return "";
               }
           }
        }
        return  s0;
    }




    public static void main(String[] args) {
        new Solution_14().longestCommonPrefix(new String[]{"flower","flow","flight"});
    }
}
