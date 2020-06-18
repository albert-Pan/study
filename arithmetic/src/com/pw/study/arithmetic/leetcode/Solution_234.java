package com.pw.study.arithmetic.leetCode;

import com.pw.study.arithmetic.model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author albert
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 */
public class Solution_234 {
    public boolean isPalindrome(ListNode head) {


        ListNode current = head;
        Set<ListNode> set = new HashSet<>();
        while (current != null) {
            if (set.contains(current)) {
                return true;
            } else {
                set.add(current);
            }
            current = current.next;
        }
        return false;
    }
}
