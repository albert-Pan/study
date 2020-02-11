package com.pw.study.arithmetic.search;

/**
 * Created by 酷酷哒 on 2019/9/26.
 */
public class BST<Key extends Comparable<Key>,Value> {

    public class Node{
        private Key key;
        private Value value;
        private Node left;
        private  Node right;
        private int N;
        public Node(Key key,Value value,int N){
            this.key=key;
            this.value=value;
            this.N=N;
        }
    }

    private Node root;

    /**
     * 有多少个节点
     * @return
     */
    public  int size(){
        return size(root);
    }

    private int size(Node x) {
        if(x==null){
            return 0;
        }else{
            return x.N;
        }
    }

    public Value get(Key key){

        return  get(key,root);
    }

    private Value get(Key key, Node x) {
        if(x==null){
            return null;
        }
        int cmp=key.compareTo(x.key);
        if(cmp>0){
           return get(key,x.right);
        }else if(cmp<0){
          return   get(key,x.left);
        }
        return x.value;
    }

    public void put(Key key,Value value){
        root=put(root,key,value);
    }

    private Node put(Node x, Key key, Value value) {
        if(x==null){
            return  new Node(key,value,1);
        }
        int cmp=key.compareTo(x.key);
        if(cmp>0){
            x.right=put(x.right,key,value);
        }else if(cmp<0){
            x.left=put(x.left,key,value);
        }else {
            x.value=value;
        }
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }


}
