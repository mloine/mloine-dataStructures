package com.mloine.linkedlist;

import java.util.Stack;

/**
 * @Author mloine
 * @Description 栈 基本使用
 * @Date 12:03 下午 2020/2/23
 */
public class TestStack {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        //入栈
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");

        //出栈
        while(stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
}
