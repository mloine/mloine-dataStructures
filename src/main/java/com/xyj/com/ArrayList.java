package com.xyj.com;

//实现动态数组
/*
缺点：内存空间的大量浪费
* */
public class ArrayList<E> extends AbstracList{
    private E[] elements;
    private static final int DEFAULT_CAPACITY=10;
    public ArrayList(int capaticy){
        if(capaticy <= DEFAULT_CAPACITY){
            capaticy = DEFAULT_CAPACITY;
        }
        elements = (E[]) new Object[capaticy];//所有的类都继承object
    }
    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }
    @Override
    public void clear(){
        for(int a = 0;a < size;a++){
            elements[a] = null;
        }
    }

    @Override
    public void add(int index, Object element){
        addsize(index);
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("index:"+index+","+"size"+size);
        }
        int i = size - 1;
        for(int a = i;a >= index;a--){
            elements[a+1]=elements[a];
        }
        elements[index]= (E) element;
        size++;
    }
    @Override
    public E set(int index, Object element){
        rangChecked(index);
        E old = elements[index];
        elements[index] = (E) element;
        return old;
    }
    @Override
    public E remove(int index){
        E result = elements[index];
        int i = index + 1;
        for(int a = i;a < size;a++){
            elements[a -1]=elements[a];
        }
        elements[--size] = null;
        return result;
    }
    @Override
    public E remove(Object element){
        int indexof = indexof((E) element);
        return remove(indexof);
    }

    @Override
    public E get(int index){
        rangChecked(index);
        return elements[index];
    }
    @Override
    public int indexof(Object element){
        if(element == null){
            for(int i = 0;i<size;i++){
                if(elements[i]==null){
                    return i;
                }
            }
        }else{
            for(int i = 0;i< size;i++){
            if(element.equals( elements[i])){
                return i;
            }
            }
        }
        return ELEMENT_NOT_FIND;
    }
    //确保容量足够的方法
    private void addsize(int capacity){
        int oldCapacity = elements.length;
        if(oldCapacity >= capacity){
            return;
        }
        int newCapacity = oldCapacity + (oldCapacity>>1);//新容量为1.5倍
        System.out.println("扩容 [旧] "+oldCapacity+"[新] "+newCapacity);
        E[] aa = (E[]) new Object[newCapacity];
        for(int a = 0;a< size;a++){
            aa[a] = elements[a];
        }
        elements = aa;
    }
    @Override
    public String toString() {
        String ss = "Size="+size+" [";
        for(int a =0;a<size;a++){
            ss = ss +elements[a]+",";
        }
        return ss.substring(0,ss.length()-1)+"]";
    }
}
