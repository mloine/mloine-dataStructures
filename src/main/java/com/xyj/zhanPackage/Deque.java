package com.xyj.zhanPackage;


import com.xyj.listPackage.CircleSingleLinkedList1;
import com.xyj.listPackage.List1;

//双端队列  只能从头部和尾部进出
public class Deque<E> {
    private List1<E> list1 = new CircleSingleLinkedList1<>();
    public int size(){
        return list1.size();
    }
    public boolean isEmpty(){
        return list1.isEmpty();
    }
    //从队尾入队
    public void enQueueRear(E element){
        list1.add(element);
    }
    //从队头入队
    public void enQueueFront(E element){
        list1.add(0,element);
    }
    //查看队头元素
    public E front(){
        return list1.get(0);
    }
    //查看队尾元素
    public E rear(){
        return list1.get(list1.size()-1);
    }
    //从队头出队
    public E deQueueFront(){
        return list1.remove(0);
    }
    //从队尾出队
    public E deQueueRear(){
        return list1.remove(list1.size()-1);
    }

    @Override
    public String toString() {
        return list1.toString();
    }
}
