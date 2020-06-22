package com.pw.study.arithmetic.leetcode;

import com.pw.study.arithmetic.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author albert
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 */
public class Solution_617 {
    /**
     * 递归解法
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2==null){
            return null;
        }
        //说明t1已经没有子树了后续都是t2子树
        if(t1==null){
            return t2;
        }
        //说明t2已经没有子树了后续都是t1子树
        if(t2==null){
            return t1;
        }
        t1.val=t1.val+t2.val;
        t1.left=mergeTrees(t1.left,t2.left);
        t1.right=mergeTrees(t1.right,t2.right);
        return t1;
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        Stack<List<TreeNode>> stack=new Stack<>();
        List<TreeNode> item=new ArrayList();
        item.add(t1);
        item.add(t2);
        stack.push(item);
        while (!stack.empty()){
               List<TreeNode> it= stack.pop();

                if(it.get(0)==null||it.get(1)==null){
                    continue;
                }
                it.get(0).val += it.get(1).val;

                if (it.get(0).left == null) {
                    it.get(0).left = it.get(1).left;
                } else {
                    stack.push(new ArrayList(Arrays.asList(it.get(0).left, it.get(1).left)));
                }
                if (it.get(0).right == null) {
                    it.get(0).right = it.get(1).right;
                } else {
                    stack.push(new ArrayList(Arrays.asList(it.get(0).right, it.get(1).right)));
                }
        }
        return t1;
    }

    }
