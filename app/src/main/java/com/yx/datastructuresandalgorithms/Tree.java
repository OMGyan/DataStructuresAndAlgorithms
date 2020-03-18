package com.yx.datastructuresandalgorithms;

/**
 * Author by YX, Date on 2019/10/9.
 */
public interface Tree {

    //查找节点
    public Node find(int key);

    //插入新节点
    public boolean insert(int data);

    //删除节点
    public boolean delete(int key);

    //中序遍历
    public void infixOrder(Node current);

    //前序遍历
    public void preOrder(Node current);

    //后序遍历
    public void postOrder(Node current);

    //找到最大值
    public Node findMax();

    //找到最小值
    public Node findMin();

}
