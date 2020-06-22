package com.pw.study.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author albert
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Solution_9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while (x > 0) {
            int item = x % 10;
            list.add(item);
            x /= 10;
        }
        int mid = list.size() / 2;
        for (int i = 0; i < mid; i++) {
            if (!list.get(i).equals(list.get(list.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        //先获取到x总的位数
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            //获取第一位数字
            int left = x / div;
             //获取最后一位数字
            int right = x % 10;
            if (left != right) {
                return false;
            }
            //x去除头部和尾部的数字
            x = (x % div) / 10;
            div /= 100;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_9().isPalindrome(12321));
    }

}
