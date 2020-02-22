package com.xyj.zhanPackage;


import com.xyj.listPackage.ArrayList1;
import com.xyj.listPackage.List1;

//实现栈   后进后出
public class Stack<E> {
    //内部使用，变成私有，外部就不可以调用
    //数组操作微元素比较快,查询也快  但可能让费内存.
    // 链表也可以，不过得用循环链表，尾元素操作比较快，不循环单向链表不建议使用.
    private List1<E> list1 = new ArrayList1<E>();
    //返回长度
    public int size(){
        return list1.size();
    }
    //添加元素
    public void push(E element){
    list1.add(element);
    }

    //删除顶部元素
    public E pop(){
        return list1.remove(list1.size()-1);
    }

    //获得顶部元素
    public E top(){
    return list1.get(list1.size()-1);
    }

    public Boolean isEmpty(){
        return list1.isEmpty();
    }

    public void clear(){
        list1.clear();
    }
    @Override
    public String toString() {
        return list1.toString();
    }
}
