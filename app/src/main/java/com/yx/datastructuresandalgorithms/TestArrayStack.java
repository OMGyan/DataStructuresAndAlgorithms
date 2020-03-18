package com.yx.datastructuresandalgorithms;

/**
 * Author by YX, Date on 2019/10/31.
 */
public class TestArrayStack {

    public static void main(String[] args){
       /* ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(23);
        arrayStack.push(3);
        arrayStack.push(39);
        arrayStack.push("lakers");
        System.out.println(arrayStack.peek());
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        System.out.println(arrayStack.peek());*/

        TestArrayStack stack = new TestArrayStack();
        //stack.testStringReversal();
        ArrayStack arrayStack = stack.testMatch();
        System.out.println(arrayStack.isEmpty());

    }

    /**
     * 字符串逆序输出
     */
    public void testStringReversal(){
        ArrayStack arrayStack = new ArrayStack();
        String str = "semaJ";
        for (int i = 0; i < str.length(); i++) {
            arrayStack.push(str.charAt(i));
        }

        while (!arrayStack.isEmpty()){
            System.out.print(arrayStack.pop());
        }
    }

    /**
     * 分隔符匹配
     *
     * 遇到左边分隔符了就push进栈，遇到右边分隔符了就pop出栈，看出栈的分隔符是否和这个有分隔符匹配
     */
    public ArrayStack testMatch(){
        ArrayStack stack = new ArrayStack(3);
        String str = "12a[b{c}";
        char[] cha = str.toCharArray();
        for(char c : cha){
            switch (c) {
                case '{':
                case '[':
                case '<':
                    stack.push(c);
                    break;
                case '}':
                case ']':
                case '>':
                    if(!stack.isEmpty()){
                        char ch = stack.pop().toString().toCharArray()[0];
                        if(c=='}' && ch != '{'
                                || c==']' && ch != '['
                                || c=='>' && ch != '<'){
                            System.out.println("Error:"+ch+"-"+c);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return stack;
    }
}
