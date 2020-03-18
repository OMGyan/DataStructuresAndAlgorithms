package com.yx.datastructuresandalgorithms;

/**
 * Author by YX, Date on 2019/10/9.
 */
public class NormalSortUtil {

    /**
     * 冒泡排序
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array){

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length-i; j++) {
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;

    }

    /**
     * 选择排序
     * @param array
     * @return
     */
    public static int[] choiceSort(int[] array) {
        //外层循环有n-1次
        for (int i = 0; i < array.length-1; i++) {
            //定义最小元素下标从i开始
            int min = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[min]>array[j]){
                    min = j;
                }
            }
            if(min!=i){
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
            //第 i轮排序的结果为
            System.out.print("第"+(i+1)+"轮排序后的结果为:");
            disPlay(array);
        }
        return array;

    }

    /**
     * 插入排序(直接插入)
     * @param array
     * @return
     */
    public static int[] insertSort(int[] array){
        //记录一下下标
        int j;
        //从下标1开始比较
        for (int i = 1; i < array.length; i++) {
            //记录一下插入数据
            int temp = array[i];
            j = i;
            while (j > 0 && temp < array[j-1]){//从已排序数组最右边开始比较
                array[j] = array[j-1];
                j--;
            }
            array[j] = temp;
        }
        disPlay(array);
        return array;

    }



    /**
     * 打印
     * @param array
     */
    public static void disPlay(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println("");
    }
}
