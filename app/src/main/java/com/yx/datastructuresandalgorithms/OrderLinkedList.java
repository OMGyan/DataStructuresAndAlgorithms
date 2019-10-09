package com.yx.datastructuresandalgorithms;

/**
 * Author by YX, Date on 2019/9/29.
 * 有序链表;
 * 在有序链表中，数据是按照关键值有序排列的。一般在大多数需要使用有序数组的场合也可以使用有序链表。
 * 有序链表优于有序数组的地方是插入的速度（因为元素不需要移动），另外链表可以扩展到全部有效的使用内存，
 * 而数组只能局限于一个固定的大小中。
 */
public class OrderLinkedList {

    private Node head;

    private class Node{
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public OrderLinkedList() {
        head = null;
    }

    //插入节点，并按照从小到大的顺序排列
    public void insert(int value){

        Node newNode = new Node(value);
        Node flagNode = null;
        Node currentHead = head;

        while (currentHead!=null && value>currentHead.data){
            flagNode = currentHead;
            currentHead = currentHead.next;
        }

        if(flagNode==null){
            head = newNode;
            head.next = currentHead;
        }else {
           flagNode.next = newNode;
           newNode.next = currentHead;
        }

    }

    //删除头节点
    public void deleteHead(){
        head = head.next;
    }

    public void disPlay(){
        Node current = head;
        while (current!=null){
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println("");
    }


}
