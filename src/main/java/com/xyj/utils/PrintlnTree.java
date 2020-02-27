package com.xyj.utils;

import com.xyj.treePackage.BinarySearchTree;

import java.util.ArrayList;

public interface PrintlnTree {
    //获得根节点

    Object getRoot();
    //获得左节点

    Object right(Object o);
    //获得右节点

    Object left(Object o);
    //获得节点中的元素

    Object getNodeElement(Object o);

    //最终打印树图

    void printlnTree();

    //获得元素的字符串最长长度

    public Integer getMaxElementLength();

    //获得树的层数

    int getTreeDepth(Object o);

    /*以满二叉树，空的节点为null   获得所有节点的集合*/

    ArrayList<ArrayList> showTreeList();

    //画节点层的方法

    ArrayList<StringBuffer> showTree();

    //画竖线层的方法

    ArrayList<StringBuffer> shuXian();

    //对字符串长度做修改

    String xiuGai(String s);

    ArrayList<StringBuffer> optStringList(ArrayList<StringBuffer> list);

    ArrayList<StringBuffer> deleteMore(ArrayList<StringBuffer> list);
}
