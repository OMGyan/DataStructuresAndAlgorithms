package com.yx.datastructuresandalgorithms;



/**
 * Author by YX, Date on 2019/10/31.
 * 单向队列测试
 */
public class MyQueueTest {

     public static void main(String[] args){
         MyQueue queue = new MyQueue(3);
         queue.insert(3);
         queue.insert(5);
         queue.insert(6);
         System.out.println(queue.peekFront());
         queue.remove();
         System.out.println(queue.peekFront());
         queue.insert(4);
         queue.insert(5);
     }


}
