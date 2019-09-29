package com.yx.datastructuresandalgorithms;

/**
 * Author by YX, Date on 2019/9/29.
 * 双端链表DoublePointLinkedList:只能从一个方向遍历,相对于单向链表多了一个对尾节点的引用
 */
public class DoublePointLinkedList {

    private Node head;//头节点
    private Node tail;//尾节点
    private int size;//链表size

    private class Node{
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    public DoublePointLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    //新增链表头
    public void addHead(Object data){
        Node currentHead = new Node(data);
        if(size==0){
            head = currentHead;
            tail = currentHead;
            size++;
        }else{
            currentHead.next = head;
            head = currentHead;
            size++;
        }
    }

    //新增尾节点
    public void addTail(Object data){
        Node currentTail = new Node(data);
        if(size == 0){
            head = currentTail;
            tail = currentTail;
            size++;
        }else{
            tail.next = currentTail;
            tail = currentTail;
            size++;
        }
    }

    public boolean deleteHead(){
        if(size == 0){
            return false;
        }
        if(size == 1){
            head = null;
            tail = null;
        }else {
            head = head.next;

        }
        size--;
        return true;
    }

    //判断是否为空
    public boolean isEmpty(){
        return (size == 0);
    }

    //获得链表的节点个数
    public int getSize(){
        return size;
    }

    //显示节点信息
    public void disPlay(){
        if(size==0){
            //当前链表size为0，表明链表为空
            System.out.println("[]");
        }else {
            if(size == 1){
                //当前链表只有一个节点
                System.out.println("["+head.data+"]");
                return;
            }
            //当链表内超过一个节点时，我们需要从头节点开始遍历输出
            Node node = head;
            int tempSize = size;
            while (tempSize > 0){
                //如果当前遍历节点是头节点
                if(node.equals(head)){
                    System.out.print("["+node.data+"->");
                //如果当前遍历节点是尾节点
                }else if(node.equals(tail)){
                    System.out.print(node.data+"]");
                //其他节点
                }else {
                    System.out.print(node.data+"->");
                }
                //依次取出next
                node = node.next;
                tempSize--;
            }
            System.out.println();
        }
    }
}
