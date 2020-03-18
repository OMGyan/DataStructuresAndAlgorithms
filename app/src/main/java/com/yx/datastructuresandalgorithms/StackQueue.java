package com.yx.datastructuresandalgorithms;

import java.util.Stack;

/**
 * Author by YX, Date on 2019/10/31.
 * 用两个栈实现队列
 *
 * 思路:
 * 将例如1,2,3放入栈一中，出栈时顺序为3,2,1，随后将栈一里元素出栈放到栈二中那么这个时候栈二的出栈顺序就是1,2,3
 * 由与队列是先进先出，所以我们可以将栈一的入栈看作是入队(push),栈二的出栈看作是出队(pop)
 *
 */
public class StackQueue {

    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public void push(int node){
        in.push(node);
    }

    public int pop() throws Exception {
        if (out.isEmpty())
            while (!in.isEmpty())
                out.push(in.pop());

        if (out.isEmpty())
            throw new Exception("queue is empty");

        return out.pop();
    }

}
