package com.yx.datastructuresandalgorithms;

/**
 * Author by YX, Date on 2020/3/17.
 * 自定义实现HashMap
 */
public class MyHashMap {

    //HashMap内部的位桶数组(长度必须为2的整数次幂,这是为了后面的hash值算法<采用位运算实现取余>)
    private Node[] table;
    //定义Map键值对数量变量
    private int size;

    //HashMap内部链表节点类
    static class Node{
        //key的hash值
        int keyHash;
        //HashMap的key
        Object key;
        //HashMap的value
        Object value;
        //节点指针
        Node next;
    }

    public MyHashMap() {
        table = new Node[16];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < table.length; i++) {
            Node node = table[i];
            if(node!=null){
                while (node!=null){
                    if(sb.length()==1){
                        sb.append(node.key+":"+node.value);
                    }else {
                        sb.append(","+node.key+":"+node.value);
                    }
                    node = node.next;
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public Object get(Object key){
        int hash = myHash(key,table.length);
        if(table[hash]!=null){
            Node node = table[hash];
            while (node!=null){
                if(node.key.equals(key)){
                    return node.value;
                }
                node = node.next;
            }
        }
        return null;
    }

    public void put(Object key, Object value){
        int hash = myHash(key, table.length);
        Node newNode = new Node();
        newNode.keyHash = hash;
        newNode.key = key;
        newNode.value = value;
        Node temp = table[hash];
        Node lastNode = null;
        boolean isRepeat = false;
        if(temp==null){
            table[hash] = newNode;
            size++;
        }else {
            while (temp!=null){
                if(temp.key.equals(key)){
                   temp.value = value;
                   isRepeat = true;
                   break;
                }else {
                   lastNode = temp;
                   temp = temp.next;
                }
            }
            if(!isRepeat){
                lastNode.next = newNode;
                size++;
            }
        }
    }

    public int getSize(){
        return size;
    }

    //hash算法
    public int myHash(Object key,int length){
        System.out.println(key.hashCode()&(length-1));
        return key.hashCode()&(length-1);
    }

    public static void main(String[] args){
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("james",23);
        myHashMap.put("wade",21);
        myHashMap.put("irving",22);
        myHashMap.put("davis",25);
        myHashMap.put("curry",24);
        myHashMap.put("james",35);
        System.out.println("map长度:"+myHashMap.getSize());
        System.out.println(myHashMap);
        System.out.println(myHashMap.get("james"));
    }
}
