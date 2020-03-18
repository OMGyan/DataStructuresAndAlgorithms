package com.yx.datastructuresandalgorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Author by YX, Date on 2019/10/22.
 *
 * 重建二叉树:根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 前序遍历:3 9 20 15 7
 * 中序遍历:9 3 15 20 7
 * 结果:
 *          3
 *         / \
 *        9   20
 *            / \
 *           15  7
 * 解题思路:
 * 前序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，
 * 左部分为树的左子树中序遍历结果，右部分为树的右子树中序遍历的结果。
 */
public class RemakeBinaryTree {

    //缓存中序遍历数组每个值对应的索引
    private Map<Integer,Integer> indexForInOrders = new HashMap<>();

    public Node reConstructBinaryTree(int[] pre,int[] in){
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i],i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    /**
     *
     * @param pre 前序遍历数组
     * @param preL 前序遍历左子树
     * @param preR 前序遍历右子树
     * @param inL  中序遍历左子树
     * @return
     */
    private Node reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        //如果二叉树为空,直接返回空                  1
        if(preL > preR){
            return null;
        }
        //获取根节点
        Node root = new Node(pre[preL]);
        //拿到该根节点在中序遍历数组中的下标
        int inIndex = indexForInOrders.get(root.data);
        //左子树的大小
        int leftTreeSize = inIndex - inL;

        root.leftChild = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.rightChild = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }

}
