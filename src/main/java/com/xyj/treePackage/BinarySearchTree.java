package com.xyj.treePackage;

import java.util.*;

//二叉搜索树
//特点：  比根节点大的放右边    小的放左边
public class BinarySearchTree<E>  extends BinaryTree{

    //比较器
    private Comparator comparator;


    public BinarySearchTree(Comparator comparetor){
            this.comparator =  comparetor;
    }

    public BinarySearchTree() {
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
                //为什么要覆盖，因为自定义类的比较方法是自定义的，可能相等，但值不相等
                eNode.element=element;
                return;
            }
        }

        //找到父节点 看看要插入那个子树
        if(c > 0){
            parent.right = new Node<E>(element,parent);
        }else{
            parent.left = new Node<E>(element,parent);
        }
        size++;
    }

    //移除树内某个元素
    public void remove(E element){
        Node<E> nodeByElement = getNodeByElement(element);
        if(nodeByElement == null){return;}
        remove(nodeByElement);
    }
    //内部移除节点
    private void remove(Node<E> node){
        //这里node不会是空的
        if (node.hasTwoChild()) {
            //找到后继节点
            Node<E> s = postNode(node);
            node.element = s.element;
            //删除后继节点
            node = s;
        }
        //来到这里必然是度为0或1的节点
        Node<E> replcement = node.left != null ? node.left : node.right;
        if(replcement != null){
            //在这里node是度为1的节点
            replcement.parent = node.parent;
            if(node.parent != null)
            {
                if(node.parent.left == node){
                    node.parent.left = replcement;
                }else{
                    node.parent.right = replcement;
                }
            }else{
                root = replcement;
            }
        }else{
            //在这里node是叶子节点
            if(node.parent == null){
                //这里node是根节点
                node = null;
            }else{
                //这里不是根节点的叶子节点
                if(node == node.parent.right){
                    node.parent.right = null;
                }else{
                    node.parent.left = null;
                }
            }
        }
        size--;
    }
    //通过element查找节点
    private Node<E> getNodeByElement(E element){
        Node<E> node = root;
        while(node != null){
            int compare = compare(element, node.element);
            if(compare == 0){return node;}
            if(compare < 0 ){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        return null;
    }

    //查看树内是否包含
    public boolean contains(E element){
        return getNodeByElement(element) != null;
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
