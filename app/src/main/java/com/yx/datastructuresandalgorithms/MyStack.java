package com.yx.datastructuresandalgorithms;

/**
 * Author by YX, Date on 2019/10/31.
 * 栈
 */
public class MyStack {
    private int[] array;
    private int maxSize;
    private int top;

    public MyStack(int size){
        this.maxSize = size;
        array = new int[size];
        top = -1;
    }

    //压入数据，进栈操作
    public void push(int value){
        if(top < maxSize - 1){
            array[++top] = value;
        }
    }

    //弹出栈顶数据
    public int pop(){
        return array[top--];
    }

    //访问栈顶数据
    public int peek(){
        return array[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    //判断栈是否满了
    public boolean isFull(){
        return top == maxSize -1;
    }


}
