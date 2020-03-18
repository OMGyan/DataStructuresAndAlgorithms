package com.yx.datastructuresandalgorithms;

/**
 * Author by YX, Date on 2019/10/30.
 */
public class TreeLinkNode {

    int val;
    TreeLinkNode right = null;
    TreeLinkNode left = null;
    TreeLinkNode next = null;

    public TreeLinkNode(int val) {
        this.val = val;
    }

    //① 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点。
    //② 否则，向上找第一个左链接指向的树包含该节点的祖先节点。
    public TreeLinkNode getNext(TreeLinkNode treeLinkNode) {
        if(treeLinkNode.right!=null){
            TreeLinkNode node = treeLinkNode.right;
            while (node.left!=null){
                node = node.left;
            }
            return node;
        }else {
            while (treeLinkNode.next!=null){
                TreeLinkNode parent = treeLinkNode.next;
                if(parent.left == treeLinkNode){
                    return parent;
                }
                treeLinkNode = treeLinkNode.next;
            }
        }
        return null;
    }

    public void inorder(TreeLinkNode node){
        if(node!=null){
            inorder(node.left);
            System.out.println(node.val);
            inorder(node.right);
        }
    }

    public static void main(String[] args){

    }
}
