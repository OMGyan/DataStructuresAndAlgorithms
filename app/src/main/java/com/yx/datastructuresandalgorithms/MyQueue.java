package com.yx.datastructuresandalgorithms;

/**
 * Author by YX, Date on 2019/10/31.
 * 单向队列（Queue）：只能在一端插入数据，另一端删除数据。
 */
public class MyQueue {
    private Object[] queArray;
    //队列总大小
    private int maxSize;
    //队列前端
    private int front;
    //队列后端
    private int rear;
    //队列中实际元素数目
    private int nItems;

    public MyQueue(int size){
        maxSize = size;
        queArray = new Object[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    //在队列中新增元素
    public void insert(int value){
        if(isFull()){
            System.out.println("队列已经满了");
        }else {
            //如果队尾已经到顶了，就是回到队头
            if(rear == maxSize-1){
                rear = -1;
            }
            queArray[++rear] = value;
            nItems++;
        }
    }

    //移除数据
    public Object remove(){

        Object removeValue = null;
        if(!isEmpty()){
            //拿到当前队头数据
            removeValue = queArray[front];
            //将队头数据置为空
            queArray[front] = null;
            //队头指针向上移动
            front++;
            //如果队头指针指向最顶端，便重新初始化(因为队头空置)
            if(front == maxSize - 1){
                front = 0;
            }
            //实际数量减一
            nItems--;
            //返回移除的数据
            return removeValue;
        }
        return removeValue;
    }

    //查看队头
    public Object peekFront(){
        return queArray[front];
    }

    //判断队列是否满了
    public boolean isFull(){
        return nItems == maxSize;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return nItems == 0;
    }

    //获取队列元素个数
    public int getSize(){
        return nItems;
    }
}
