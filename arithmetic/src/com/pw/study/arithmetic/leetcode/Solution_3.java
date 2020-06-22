package com.pw.study.arithmetic.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        Set<Character> set=null;
        for(int i=0;i<s.length();i++){
            set=new HashSet<>();
            int max1=0;
            for (int j=i;j<s.length();j++){
                 char ch=s.charAt(j);
                 if(set.contains(ch)){
                    if(max<max1){
                        max=max1;
                    }
                    break;
                }else {
                    set.add(ch);
                    max1++;
                    if(j==s.length()-1&&max<max1){
                         max=max1;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println( new Solution_3().lengthOfLongestSubstring(" "));
    }

}
