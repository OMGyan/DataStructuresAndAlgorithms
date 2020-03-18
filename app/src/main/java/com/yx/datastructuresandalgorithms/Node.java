package com.yx.datastructuresandalgorithms;

/**
 * Author by YX, Date on 2019/10/9.
 * 二叉树的节点类
 */
public class Node {
    int data;//节点数据
    Node leftChild;//左子节点的引用
    Node rightChild;//右子节点的引用
    boolean isDelete;//表示节点是否被删除

    public Node(int data) {
        this.data = data;
    }

    //打印节点内容
    public void disPlay(){
        System.out.println(data);
    }
}
