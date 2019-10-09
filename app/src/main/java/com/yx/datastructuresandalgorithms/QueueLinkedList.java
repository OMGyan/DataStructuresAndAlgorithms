package com.yx.datastructuresandalgorithms;

/**
 * Author by YX, Date on 2019/9/29.
 * 双端链表实现队列
 */
public class QueueLinkedList {

    private DoublePointLinkedList dplList;

    public QueueLinkedList() {
        dplList = new DoublePointLinkedList();
    }

    public void insert(Object data){
        dplList.addTail(data);
    }

    public void delete(){
        dplList.deleteHead();
    }

    public boolean isEmpty(){
        return dplList.isEmpty();
    }

    public int getSize(){
        return dplList.getSize();
    }

    public void disPlay(){
        dplList.disPlay();
    }
}
