package com.pw.study.arithmetic.leetcode;

/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: "aba"
 *
 * 输出: False
 * 示例 3:
 *
 * 输入: "abcabcabcabc"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 * @author albert
 */
public class Solution_459 {

    public static  boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <s.length() ; i++) {
            if(s.length()%i==0){
                if(check(s.substring(0,i),s.substring(i,s.length()))) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean check(String sub, String str) {
        int len = sub.length();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=sub.charAt(i%len)){
                return false;
            }
        }
        return true;
    }
}
