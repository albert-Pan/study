package com.pw.study.arithmetic.search;

/**
 * Created by 酷酷哒 on 2019/9/26.
 */
public class BSTTest {
    public static void main(String[] args) {
        BST<Integer,String> bst=new BST<>();
        bst.put(1,"hello");
        bst.put(2,"world");
        bst.put(2,"java");
        System.out.println(bst.size());
        System.out.println(bst.get(2));
        System.out.println(bst.get(3));
    }
}
