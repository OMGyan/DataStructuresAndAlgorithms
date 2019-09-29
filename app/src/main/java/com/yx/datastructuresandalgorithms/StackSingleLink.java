package com.yx.datastructuresandalgorithms;

/**
 * Author by YX, Date on 2019/9/28.
 * 单向链表实现栈
 */
public class StackSingleLink {

    private SingleLinkedList link;

    public StackSingleLink() {
        link = new SingleLinkedList();
    }

    //添加元素
    public void push(Object obj){
        link.addHead(obj);
    }

    //移除栈顶元素
    public Object pop(){
        Object o = link.deleteHead();
        return o;
    }

    //判断是否为空
    public boolean isEmpty(){
        return link.isEmpty();
    }

    //打印栈内元素信息
    public void disPlay(){
       link.display();
    }
}
