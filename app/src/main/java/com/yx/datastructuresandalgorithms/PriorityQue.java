package com.yx.datastructuresandalgorithms;

/**
 * Author by YX, Date on 2019/10/31.
 * 数组实现优先级队列,声明为int类型的数组，关键字是数组里面的元素,在插入的时候按从大到小的顺序排列,也就是最小的元素优先级最高
 */
public class PriorityQue {
    private int maxSize;
    private int[] preQueArray;
    private int nItems;

    public PriorityQue(int size) {
        maxSize = size;
        preQueArray = new int[maxSize];
        nItems = 0;
    }

    /**
     * insert() 方法，先检查队列中是否有数据项，如果没有，则直接插入到下标为0的单元里，
     * 否则，从数组顶部开始比较，找到比插入值小的位置进行插入，并把 nItems 加1.
     * @param value
     */

    public void insert(int value){
        int j;
        if(nItems == 0){
            preQueArray[nItems++] = value;
        }else {
            j = nItems-1;
            //使用插入排序
            while (j >= 0 && value > preQueArray[j]){
                preQueArray[j+1] = preQueArray[j];
                j--;
            }
            preQueArray[j+1] = value;
            nItems++;
        }
    }

    //移除数据,由于是按照大小排序，所以指针往下移动
    //由于元素是int类型，所以不能置为空，可以置为-1
    public int remove(){
        int k = nItems - 1;
        int value = preQueArray[k];
        preQueArray[k]=-1;
        nItems--;
        return value;
    }

    //查看优先级最高的元素
    public int peekMin(){
        return preQueArray[nItems-1];
    }

    public boolean isFull(){
        return nItems == maxSize;
    }

    public boolean isEmpty(){
        return nItems == 0;
    }
}
