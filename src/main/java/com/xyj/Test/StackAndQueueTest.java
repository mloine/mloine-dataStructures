package com.xyj.Test;


import com.xyj.zhanPackage.Deque;
import com.xyj.zhanPackage.Queue;
import com.xyj.zhanPackage.Stack;

public class StackAndQueueTest {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        for(int a= 0;a<8;a++){
            integerStack.push(a);
        }
        System.out.println(integerStack);
        while(integerStack.size() != 1){
         integerStack.pop();
         System.out.println(integerStack);
        }
        System.out.println("----------------------------");
        Queue<Integer> integerQueue = new Queue<>();
        for(int a = 0;a <8;a++){
            integerQueue.enQueue(a);
        }
        System.out.println(integerQueue);
        while(!integerQueue.isEmpty()){
            System.out.println(integerQueue.deQueue());
        }
        System.out.println("----------------------------");
        Deque<Integer> ii = new Deque<>();
        ii.enQueueFront(0);
        ii.enQueueFront(1);
        ii.enQueueFront(2);
        ii.enQueueRear(1);
        ii.enQueueRear(2);
        ii.deQueueFront();
        ii.deQueueFront();
        ii.deQueueRear();
        System.out.println(ii);
    }
}
