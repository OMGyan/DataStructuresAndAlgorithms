package com.yx.datastructuresandalgorithms;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * Author by YX, Date on 2019/10/23.
 */
public class Solution {

    public static Node reConstructBinaryTree(int[] pre, int[] in) {
        Node root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    /**
     * 前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
     * @param pre 前序遍历数组
     * @param startPre 前序遍历起点
     * @param endPre 前序遍历终点
     * @param in 中序遍历数组
     * @param startIn 中序遍历起点
     * @param endIn 中序遍历终点
     * @return
     */
    private static Node reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        //如果前序遍历起点大于终点或者中序遍历起点大于中序遍历终点，返回null
        if (startPre > endPre || startIn > endIn)
            return null;
        //拿到当前前序遍历到的节点，第一次为根节点
        Node root = new Node(pre[startPre]);
        //遍历中序遍历数组
        for (int i = startIn; i <= endIn; i++)
            //如果存在中序节点关键值等于前序节点关键值
            if (in[i] == pre[startPre]) {
                //
                root.leftChild = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                //
                root.rightChild = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        return root;
    }



    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int maxStrLen = 0,i = 0,j = 0;
        Set<Character> set = new HashSet<>();
        while (i < length && j < length){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                maxStrLen = Math.max(maxStrLen,j-i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return maxStrLen;
    }

    public boolean allUnique(String s, int start, int end) {

        HashSet<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character charAt = s.charAt(i);
            if(set.contains(charAt)){
                return false;
            }
            set.add(charAt);
        }
        return true;

    }

    public static void main(String[] args){
        Solution solution = new Solution();
       // int yuuiop = solution.lengthOfLongestSubstring("yxyui");
        //System.out.println(yuuiop);
        int fibonacci = solution.getFibonacciSum(6);
        int result = solution.getResult(4);
        int i = solution.jumpStairs(4);
       // System.out.println(i+"   "+result);
       // System.out.println(fibonacci);

        int i1 = solution.JumpFloorII(5);
       // System.out.println(i1);


        int[] a = {5,6,7,9};
        int i2 = solution.minNumberInRotateArray(a);
        System.out.println(i2);
    }


    /**
     * 斐波那契数列规律:
     * F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）
     * @param n
     * @return
     */
    public int getFibonacciSum(int n){
         if(n>=3){
             return getFibonacciSum(--n)+getFibonacciSum(--n);
         }
         return 1;
    }

    /**
     * 矩形覆盖
     * @param n
     * @return
     */
    public int getResult(int n){
       if(n <= 2){
           return n;
       }
       int pre1 = 1,pre2 = 2,result = 0;
        for (int i = 3; i <= n ; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }

    public int jumpStairs(int n){
        if(n <= 2){
            return n;
        }
        int pre1 = 1,pre2 = 2,result = 0;
        for(int x = 2;x < n;x++){
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }
//  通过修改二分查找算法进行求解（l 代表 low，m 代表 mid，h 代表 high）：
//  当 nums[m] <= nums[h] 时，表示 [m, h] 区间内的数组是非递减数组，[l, m] 区间内的数组是旋转数组，此时令 h = m；
//  否则 [m + 1, h] 区间内的数组是旋转数组，令 l = m + 1。
    /**
     * @param nums 输入一个非递减排序的数组 2,3,4,5
     * @return 输出旋转数组的最小元素
     */
    public int minNumberInRotateArray(int[] nums) {
        //如果数组为空,返回0
        if (nums.length == 0)
            return 0;
        //定义l(低位)为0，定义h(高位)为数组最后一位
        int l = 0, h = nums.length - 1;//3
        //如果低位小于高位
        while (l < h) {
            //根据高低获取中位数
            int m = l + (h - l) / 2;//1
            //如果中位数小于高位数
            if (nums[m] <= nums[h])//nums[1] <= nums[3]
                //就把中位赋值给高位
                h = m;  //h = m = 1;
            else
                l = m + 1;
        }
        return nums[l];
    }

    public int JumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }

}
