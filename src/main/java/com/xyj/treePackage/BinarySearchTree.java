package com.xyj.treePackage;


import com.xyj.utils.AbstartPrintTree;

import java.util.ArrayList;
import java.util.Comparator;

//二叉搜索树
//特点：  比根节点大的放右边    小的放左边
public class BinarySearchTree<E> extends AbstartPrintTree {

    /*数据的规模  二叉搜索树里没有索引的概念
    * */
    private int size;

    //二叉树的根节点
    private Node<E> root;

    //比较器
    private Comparator comparator;

    public BinarySearchTree(Comparator comparetor){
            this.comparator =  comparetor;
    }

    public BinarySearchTree() {
    }



    @Override
    public Object getRoot() {
        return root;
    }

    @Override
    public Object right(Object o) {
        Node o1 = (Node) o;
        return o1.right;
    }

    @Override
    public Object left(Object o) {
        Node o1 = (Node) o;
        return o1.left;
    }

    @Override
    public Object getNodeElement(Object o) {
        Node o1 = (Node) o;
        return o1.element;
    }


    //内部节点
    private static class Node<E>{

        //元素
        E element;

        //左子树
        Node<E> left;

        //右子树
        Node<E> right;

        //父节点
        Node<E> parent;

        public Node(E element,Node<E> parent) {
            this.parent = parent;
            this.element = element;
        }

        public Node() {
        }

        @Override
        public java.lang.String toString() {
            return element.toString();
        }
    }

    //返回数据规模
    public int size(){
        return size;
    }

    //查看是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //清空树
    public void clear(){

    }

    //向树内添加元素
    public void add(E element){

        //判断元素不为空
        elementNotNull(element);

        //加入第一个元素的情况
        if(root == null){
         root = new Node<E>(element,null);
         size++;
         return;
        }

        //添加的不是第一个节点
        Node<E> eNode = root;
        int c = 0;
        Node<E> parent = new Node<E>();
        while (eNode!= null) {
            parent = eNode;
            c = compare(element, eNode.element);
            if(c >0){
                    eNode = eNode.right;
            }else if(c < 0 ){
                    eNode = eNode.left;
            }else{//相等的情况
                return;
            }
        }

        //找到父节点 看看要插入那个子树
        if(c > 0){
            parent.right = new Node<E>(element,parent);
        }else if(c < 0){
            parent.left = new Node<E>(element,parent);
        }
        size++;
    }

    //移除树内某个元素
    public void remove(E element){

    }

    //查看树内是否包含
    public boolean contains(E element){
        return true;
    }

    //判断不是空元素
    private void elementNotNull(E element){
        if(element == null){
            throw new IllegalArgumentException("element not be null");
        }
    }

    //比较元素大小的方法
    /*返回值0  代表 e1 = e2
    * 返回值>0  e1 > e2
    * 返回值<0  e1 < e2
    * */
    private int compare(E e1,E e2){
        if (comparator != null) {
            return comparator.compare(e1,e2);
        }else{
            return ((Comparable)e1).compareTo(e2);
        }
    }
    @Override
    public String toString() {

        return "";
    }
}
