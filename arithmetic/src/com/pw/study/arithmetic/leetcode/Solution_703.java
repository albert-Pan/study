package com.pw.study.arithmetic.leetcode;

import java.util.PriorityQueue;

/**
 * @author panw
 * @description
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * @date 2020/7/18 10:51 下午
 */
public class Solution_703 {

    class KthLargest {
        private PriorityQueue<Integer> priorityQueue;
        private int k;
        public KthLargest(int k, int[] nums) {
            priorityQueue = new PriorityQueue<>(k);
            this.k = k;
            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }
        }

        public int add(int val) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(val);
            } else {
                if (val > priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.add(val);
                }
            }
            return priorityQueue.peek();
        }
    }
}
