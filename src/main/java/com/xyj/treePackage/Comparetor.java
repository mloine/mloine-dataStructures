package com.xyj.treePackage;
//用来个性化比较

//java里面有自带的接口，我们用自带的，不用自己写的接口
public interface Comparetor<E> {
     int compareTo(E e1, E e2);
}
