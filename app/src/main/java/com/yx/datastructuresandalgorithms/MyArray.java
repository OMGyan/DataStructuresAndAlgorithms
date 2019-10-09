package com.yx.datastructuresandalgorithms;

/**
 * Author by YX, Date on 2019/10/9.
 *
 * 数组的局限性:
 * 1.删除慢
 * 2.查找慢
 * 3.插入快
 * 4.一旦确定大小，就不可改变
 */
public class MyArray {
    //定义一个数组
    private int[] intArray;
    //定义数组的实际有效长度
    private int elems;
    //定义数组的最大长度
    private int length;

    //默认构造一个长度50的数组
    public MyArray() {
        elems = 0;
        length = 50;
        intArray = new int[length];
    }

    //初始化一个长度为length的数组
    public MyArray(int length) {
        elems = 0;
        this.length = length;
        intArray = new int[length];
    }

    //获取数组的有效长度
    public int getSize(){
        return elems;
    }

    //遍历显示元素
    public void disPlay(){
        for (int i = 0; i < elems; i++) {
            System.out.print(intArray[i]+" ");
        }
        System.out.println();
    }

    /**
     * 添加元素
     * @param value,假设操作人是不会添加重复元素的，如果有重复元素对于后面的操作都会有影响。
     * @return添加成功返回true,添加的元素超过范围了返回false
     */
    public boolean add(int value){
        if(elems >= length){
            return false;
        }else {
            intArray[elems] = value;
            elems++;
        }
        return true;
    }

    /**
     * 根据下标获取元素
     * @param i
     * @return 获取的元素在下标范围内时正常返回，超过则提示下标越界
     */
    public int get(int i){
        if(i>elems || i<0){
            System.out.println("下标越界");
        }
        return intArray[i];
    }

    /**
     * 查找元素
     * @param searchValue
     * @return 存在则返回下标，不存在则返回-1.
     */
    public int find(int searchValue){
        if(elems==0){
            return -1;
        }else {
            for (int i = 0; i < elems; i++) {
                if(intArray[i]==searchValue){
                    return i;
                }
            }
            return -1;
        }
    }

    /**
     * 删除元素
     * @param value
     * @return 如果元素存在则返回true，否则返回false
     */
    public boolean delete(int value){
        int index = find(value);
        if(index==-1){
            return false;
        }else {
            if(index==elems-1){
                elems--;
            }else {
                for (int i = index; i < elems-1; i++) {
                    intArray[i] = intArray[i+1];
                }
                elems--;
            }
            return true;
        }
    }

    /**
     * 修改数据
     * @param oldValue
     * @param newValue
     * @return
     */
    public boolean modify(int oldValue,int newValue){
        int index = find(oldValue);
        if(index==-1){
            System.out.println("需要修改的数据不存在");
            return false;
        }else {
            intArray[index] = newValue;
            return true;
        }
    }
}
