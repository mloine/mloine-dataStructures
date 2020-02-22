package com.xyj.listPackage;

//实现动态数组
/*
缺点：内存空间的大量浪费
提升空间：当前数组只会自动扩容  没实现自动缩容
* */
public class ArrayList1<E> extends AbstracList1 {
    private E[] elements;
    private static final int DEFAULT_CAPACITY=10;

    public ArrayList1(int capaticy){
        if(capaticy <= DEFAULT_CAPACITY){
            capaticy = DEFAULT_CAPACITY;
        }
        elements = (E[]) new Object[capaticy];//所有的类都继承object
    }
    public ArrayList1(){
        this(DEFAULT_CAPACITY);
    }
    @Override
    public void clear(){
        /*for(int a = 0;a < size;a++){
            elements[a] = null;
        }*/
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(int index, Object element){
        addsize(index);
        addChecked(index);
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
    /*o()
    * 实现下缩容  抢救下浪费内存的问题
    * */
    public E remove(int index){
        E result = elements[index];
        int i = index + 1;
        for(int a = i;a < size;a++){
            elements[a -1]=elements[a];
        }
        elements[--size] = null;
        int length = elements.length;
        int b = size +1;
        if(size < (elements.length>>1) &&size > 10){
            E[] nelememts = (E[]) new Object[b];
            for(int a = 0;a<size;a++){
                nelememts[a] = elements[a];
            }
            elements = nelememts;
            System.out.println("缩容:"+"原空间 "+length+"  现空间"+b);
        }

        return result;
    }
    @Override
    public E removeByelement(Object element){
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
        if(oldCapacity > capacity){
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
        if (size != 0) {
            for(int a =0;a<size;a++){
                ss = ss +elements[a]+",";
            }
            return ss.substring(0,ss.length()-1)+"]";
        }else{ return ss +"]";}
    }
}

