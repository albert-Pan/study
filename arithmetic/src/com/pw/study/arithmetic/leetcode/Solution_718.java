package com.pw.study.arithmetic.leetcode;

/**
 * @author panw
 * @description
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 示例：
 *
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *  
 *
 * 提示：
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * @date 2020/7/1 11:05 下午
 */
public class Solution_718 {

    public int findLength(int[] A, int[] B) {
        int sameCount=0;
        int n=A.length;
        int m=B.length;
        for (int i = 0; i <n ; i++) {
            for (int j =0 ; j <m ; j++) {
                int subLen=1;
                while (A[i+subLen]==B[j+subLen]&&i + subLen < n && j+subLen<m){
                    subLen++;
                }
                sameCount=Math.max(sameCount,subLen);
            }
        }
        return sameCount;
    }
    public int findLength2(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        int maxLen = 0;
        //初始化dp[0],第一行
        for (int i = 0; i < B.length; i++) {
            if (A[0] == B[i]) {
                dp[0][i] = 1;
            }
        }
        //初始化dp[][0],第一列
        for (int i = 0; i < A.length; i++) {
            if (B[0] == A[i]) {
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen;
    }

    public int findLength3(int[] A, int[] B) {
        return A.length < B.length ? findMax(A, B) : findMax(B, A);
    }

    private int findMax(int[] a, int[] b) {
        int max=0;
        int aLen=a.length;
        int bLen=b.length;
        //b从a开始的地方划入，此时a从0开始增加，b从bLen处逐渐减小
        for (int i=1;i<aLen;i++){
            max=Math.max(max,maxLenth(a,0,b,bLen-i,i));
        }

        for (int j=0;j<bLen-aLen;j++){
            max=Math.max(max,maxLenth(a,0,b,bLen-aLen-j,aLen));
        }
        for (int k=0;k<aLen;k++){
            max=Math.max(max,maxLenth(a,k,b,0,aLen-k));
        }
        return max;
    }

    private int maxLenth(int[] a, int i, int[] b, int j, int len) {
        int count = 0;
        int max = 0;
        for(int k = 0; k < len; k++) {
            if(a[i+k] == b[j+k]) {
                count++;
            } else if(count > 0) {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return count > 0 ? Math.max(max, count) : max;
    }

}
