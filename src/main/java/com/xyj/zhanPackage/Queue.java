package com.xyj.zhanPackage;


//队列的设计，先进先出 java官方使用链表实现

//也可以使用栈实现，两个栈  不过没必要，脱裤子放屁.

import com.xyj.listPackage.CircleSingleLinkedList1;
import com.xyj.listPackage.List1;

public class Queue<E>  {
    //采用链表实现。应为链表操作头元素    比 数组快.
    private List1<E> list1= new CircleSingleLinkedList1<E>();
    public void clear(){
        list1.clear();
    }
    public int size(){
        return list1.size();
    }
    //出队
    public E deQueue(){
         return list1.remove(0);
    }
    //获取头元素
    public E front(){
        return list1.get(0);
    }
    //进队
    public void enQueue(E element){
        list1.add(element);
    }
    public boolean isEmpty(){
        return list1.isEmpty();
    }

    @Override
    public String toString() {
        return list1.toString();
    }
}
