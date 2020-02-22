package com.xyj.zhanPackage;

public interface zhan<E> {
    //获得长度
    public int size();
    //判断是否为空
    public boolean isRmpty();

    //添加元素
    public void push(E element);

    //删除顶部元素
    public E pop();

    //获得顶部元素
    public E top();

    public void claar();

}
