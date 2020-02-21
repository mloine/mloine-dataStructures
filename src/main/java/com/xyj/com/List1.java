package com.xyj.com;

public interface List1<E> {
     static final int ELEMENT_NOT_FIND=-1;
     void clear();
     int size();
     boolean isEmpty();

    //添加元素
     void add(E element);

     void add(int index, E element);

     E set(int index, E element);

     E remove(int index);

     E remove(E element);

     boolean contains(E element);

     E get(int index);

     int indexof(E element);

}
