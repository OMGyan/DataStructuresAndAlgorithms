package com.yx.datastructuresandalgorithms;

import android.util.Log;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author by YX, Date on 2019/9/11.
 * 单向链表
 */
public class SingleLinkedList {

    private int size;//链表节点的个数

     Node head;//头节点

    public SingleLinkedList() {

        size = 0;

        head = null;

    }

    /**
     * 链表的每个节点类
     */
    private class Node{

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    //在链表头添加元素(更新链表头)
    public Object addHead(Object obj){
        //创建新节点
        Node newHead = new Node(obj);

        if(size==0){
            //如果当前链表节点个数为空，直接将该创建节点置为头节点
            head = newHead;
        }else {
            //如果当前链表size不为空，
            //1.先将创建节点next属性指向当前链表头head
            newHead.next = head;
            //2.再把创建节点置位表头head
            head = newHead;
        }
        //添加完后，将链表size加一
        size++;

        return obj;
    }

    //删除链表头
    public Object deleteHead(){
        //首先取出当前表头的数据
        Object obj = head.data;
        //将表头next属性指向新表头
        head = head.next;
        //链表size减一
        size--;
        return obj;
    }

    //删除指定元素
    public boolean delete (Object value){

         if(size==0){
             return false;
         }

        Node newHead = this.head;
        Node oldHead = this.head;

        while (newHead.data!=value){
            if(size==1){
                return false;
            }else {
                oldHead = newHead;
                newHead = newHead.next;
            }
        }

        if(newHead == head){
            head = newHead.next;
            size--;
        }else {
            oldHead.next = newHead.next;
            size--;
        }

        return true;
    }
    //判断链表是否为空
    public boolean isEmpty(){
        return (size==0);
    }

    //打印链表数据
    public void display(){
        if(size > 0){
            Node node = this.head;
            int tempSize = this.size;
            if(tempSize == 1){//当前链表只有一个节点，即打印头节点数据
                System.out.println("["+node.data+"]");
                return;
            }
            while (tempSize>0){
                if(node.equals(head)){
                   System.out.print("["+node.data+"->");
                }else if(node.next == null){
                   System.out.print(node.data+"]");
                }else {
                   System.out.print(node.data+"->");
                }
                node = node.next;
                tempSize--;
            }
            System.out.println();
        }else {
            System.out.println("[]");
        }
    }


}
