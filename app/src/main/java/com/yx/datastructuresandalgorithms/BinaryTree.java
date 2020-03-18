package com.yx.datastructuresandalgorithms;




/**
 * Author by YX, Date on 2019/10/9.
 * 二叉树
 *
 * 树是由边和节点构成，根节点是树最顶端的节点，它没有父节点;
 * 二叉树中，最多有两个子节点;某个节点的左子树每个节点的关键值都比该节点的关键值小;
 * 某个节点的右子树每个节点的关键值都比该节点的关键值大
 * 其查找、插入、删除的时间复杂度都为logN；
 * 可以通过前序遍历，中序遍历，后序遍历来
 */

public class BinaryTree implements Tree{

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(50);
        bt.insert(20);
        bt.insert(80);
        bt.insert(10);
        bt.insert(30);
        bt.insert(60);

        //bt.delete(10);//删除没有子节点的节点
        //bt.delete(30);//删除有一个子节点的节点
        //bt.delete(80);//删除有两个子节点的节点

        bt.preOrder(bt.root);
        System.out.println();
        bt.infixOrder(bt.root);
        System.out.println();
        //System.out.println(bt.findMax().data);
        //System.out.println(bt.findMin().data);
        //System.out.println(bt.find(100));
        //System.out.println(bt.find(200));
        RemakeBinaryTree remakeBinaryTree = new RemakeBinaryTree();
        Node node = remakeBinaryTree.reConstructBinaryTree(new int[]{50, 20, 10, 30, 80, 60}, new int[]{10, 20, 30, 50, 60, 80});
        //System.out.println(node.data);


        Node newNode = Solution.reConstructBinaryTree(new int[]{50, 20, 10, 30, 80, 60}, new int[]{10, 20, 30, 50, 60, 80});

        bt.preOrder(newNode);
    }

    //表示根节点
    private Node root;

    /**
     * 查找节点
     * @param key
     * @return
     */
    @Override
    public Node find(int key) {
        //拿到当前根节点
        Node current = root;
        while (current!=null){
            if(current.data > key){
                //如果查找节点数据小于当前节点数据,则搜索左子树
                current = current.leftChild;
            }else if(current.data < key){
                //如果查找节点数据大于当前节点数据,则搜索右子树
                current = current.rightChild;
            }else {
                return current;
            }
        }

        return null;//没找到则返回null
    }

    /**
     * 插入节点
     * @param data
     * @return
     */
    @Override
    public boolean insert(int data) {
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
            return true;
        }else {
            Node current = root;
            Node parentNode = null;
            while (current!=null){
                parentNode = current;
                if(current.data > data){
                    //当前值比插入值大，搜索左子节点
                    current = current.leftChild;
                    if(current == null){
                        //如果左子节点为空,则直接插入
                        parentNode.leftChild = newNode;
                        return true;
                    }
                }else {
                    current = current.rightChild;
                    if(current == null){
                        parentNode.rightChild = newNode;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 删除节点:
     * 1:该节点是叶子节点(没有子节点),要删除叶节点,只需将其父节点对其的引用改为null即可
     * 2:该节点有一个子节点
     * 3:该节点有两个子节点
     * @param key
     * @return
     */
    //删除没有子节点的节点
    @Override
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
        //查找删除值，找不到，直接返回false
        while (current.data!=key){
           parent = current;
           if(current.data > key){
               isLeftChild = true;
               current = current.leftChild;
           }else{
               isLeftChild = false;
               current = current.rightChild;
           }
           if(current==null){
               return false;
           }
        }
        //如果当前节点没有子节点(找到节点置为空)
        if(current.leftChild==null&&current.rightChild==null){
            if(current == root){
                root = null;
            }else if(isLeftChild){
                parent.leftChild = null;
            }else {
                parent.rightChild = null;
            }
            return true;
            //如果当前节点只有一个子节点(我们只需将当前节点的父节点对其的引用指向其子节点)
        }else if(current.leftChild!=null&&current.rightChild==null){
            if(current==root){
                root = root.leftChild;
            }else if(isLeftChild){
                parent.leftChild = current.leftChild;
            }else {
                parent.rightChild = current.leftChild;
            }
            return true;
        }else if(current.leftChild==null&&current.rightChild!=null){
            if(current==root){
                root = current.rightChild;
            }else if(isLeftChild){
                parent.leftChild = current.rightChild;
            }else {
                parent.rightChild = current.rightChild;
            }
            return true;
        }else {
            //当前节点存在两个子节点
            Node successor = getSuccessor(current);
            if(current == root){
                root= successor;
            }else if(isLeftChild){
                parent.leftChild = successor;
            }else{
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return false;
    }
    //删除节点存在两个子节点
    public Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null){
           successorParent = successor;
           successor = current;
           current = current.leftChild;
        }
        //将后继节点替换删除节点
        if(successor != delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    /**
     * 中序遍历:左子树——》根节点——》右子树
     * @param current
     */
    @Override
    public void infixOrder(Node current) {
        if(current!=null){
            infixOrder(current.leftChild);
            System.out.print(current.data+" ");
            infixOrder(current.rightChild);
        }
    }

    /**
     * 前序遍历 根节点——》左子树——》右子树
     * @param current
     */
    @Override
    public void preOrder(Node current) {
          if(current!=null){
              System.out.print(current.data+" ");
              preOrder(current.leftChild);
              preOrder(current.rightChild);
          }
    }

    /**
     * 后序遍历 左子树——》右子树——》根节点
     * @param current
     */
    @Override
    public void postOrder(Node current) {
       if(current!=null){
           postOrder(current.leftChild);
           postOrder(current.rightChild);
           System.out.println(current.data+" ");
       }
    }

    //找到最大节点:从根节点开始往右子树遍历，直到为空。
    @Override
    public Node findMax() {
        Node current = root;
        Node maxNode = current;
        while (current!=null){
            maxNode = current;
            current = current.rightChild;
        }
        return maxNode;
    }

    //找到最小节点:从根节点开始，向左子树遍历，直到为空；
    @Override
    public Node findMin() {
        Node current = root;
        Node minNode = current;
        while (current!=null){
            minNode = current;
            current =  current.leftChild;
        }
        return minNode;
    }



}
