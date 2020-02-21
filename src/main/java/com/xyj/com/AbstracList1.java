package com.xyj.com;

public abstract class AbstracList1<E> implements List1<E> {
    protected int size;

    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public void add(E element) {
        add(size,element);
    }
    @Override
    public boolean contains(E element) {
        return indexof(element) != ELEMENT_NOT_FIND;
    }

    protected void rangChecked(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index:"+index+","+"size"+size);
        }
    }
    protected void addChecked(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("index:"+index+","+"size"+size);
        }
    }

}
