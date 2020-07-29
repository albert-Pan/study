package com.pw.study.arithmetic.leetcode;

import java.util.*;

/**
 * @author panw
 * @description
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/7/26 9:26 下午
 */
public class Solution_347 {


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap();
        //先将元素放入map 存储好
        for (int item:nums) {
            count.put(item, count.getOrDefault(item, 0) + 1);
        }
        //定义好优先对列,最小堆
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        for (int n: count.keySet()) {
            heap.add(n);
            //保持最小堆个数只有k个
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] topList = new int[k];
        for (int i = heap.size()-1; i>=0 ; i--) {
            topList[i]=heap.poll();
        }
        return topList;
    }
}
