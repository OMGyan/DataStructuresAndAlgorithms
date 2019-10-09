package com.yx.datastructuresandalgorithms;

/**
 * Author by YX, Date on 2019/10/8.
 * 双向链表
 */
public class TwoWayLinkedList {
    private Node head;
    private Node tail;
    private int size;


    private class Node{
        private Node next;
        private Node prev;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }
    }

    public TwoWayLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    //在链表头增加节点
    public void addHead(Object value){
        Node newHeadNode = new Node(value);
        if(head == null){
            head = newHeadNode;
            tail = newHeadNode;
            size++;
        }else {
            newHeadNode.next = head;
            head.prev = newHeadNode;
            head = newHeadNode;
            size++;
        }
    }

    //在链表尾增加节点
    public void addTail(Object value){
        Node newTailNode = new Node(value);
        if(tail==null){
            head = newTailNode;
            tail = newTailNode;
            size++;
        }else {
            tail.next = newTailNode;
            newTailNode.prev = tail;
            tail = newTailNode;
            size++;
        }
    }

    //删除链表头
    public void deleteHead(){
        if(size!=0){
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    //删除链表尾
    public void deleteTail(){
        if(size!=0){
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }

    //获得链表的节点个数
    public int getSize() {
        return size;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //打印节点信息
    public void disPlay(){
        Node current = head;
        int temp = size;
        if(temp==0){
            System.out.println("[]");
        }else if(temp==1){
            System.out.println("["+head.data+"]");
        }else {
            while (temp!=0){

                if(current == head){
                    System.out.print("["+current.data+"->");
                }else if(current == tail){
                    System.out.print(current.data+"]");
                }else {
                    System.out.print(current.data+"->");
                }
                temp--;
                current = current.next;
            }
            System.out.println("");
        }
    }

    //倒序打印节点
    public void reverseDisPlay(){
        Node ct = tail;
        int temp = size;
        if(temp!=0){
            if(temp == 1){
                System.out.println("["+ct.data+"]");
            }else {
                while (temp!=0){
                    if(ct == head){
                        System.out.print(ct.data+"]");
                    }else if(ct == tail){
                        System.out.print("["+ct.data+",");
                    }else {
                        System.out.print(ct.data+",");
                    }
                    temp--;
                    ct = ct.prev;
                }
                System.out.println("");
            }
        }else {
            System.out.println("[]");
        }
    }
}
