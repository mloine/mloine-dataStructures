package com.xyj.listPackage;
/*实现双向列表，相比单向列表提高效率*/
public class CricleDoubleLinkedList1<E> extends AbstracList1<E> {
    private Node<E> first;
    private Node<E> last;
    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void add(int index, E element) {
        if(index == 0){
            first = new Node<E>(element);
            last = new Node<E>(element);
            first.next=last;first.prve=last;
            last.next=first;last.prve=first;
        }
        if(index == 1){
            last.element= element;
        }
        if(index >1){
            if (index < size) {
                Node<E> pnode = node(index - 1);
                Node<E> nnode = node(index);
                Node<E> node = new Node<E>(element,pnode,nnode);
                pnode.next = node;
                nnode.prve = node;
            } else {
                Node<E> eNode = last;
                last = new Node<E>(element);
                last.prve = eNode;last.next=first;
                first.prve=last;
                eNode.next=last;
            }
        }
        size++;
    }

    @Override
    public E set(int index, E element) {
        E element1 = node(index).element;
        node(index).element = element;
        return element1;
    }

    @Override
    public E remove(int index) {
        Node<E> node = node(index);
        if(index == size-1){
            Node<E> prve = node(index).prve;
            prve.next = first;last = prve;first.prve=last;
            size--;
            return node.element;
        }
        if(index == 0 && index != size-1){
            Node<E> node1 = node(1);
            first = node1;first.prve=last;last.next=first;
            size--;
            return node.element;
        }
        Node<E> pnode1 = node(index - 1);
        Node<E> nnode = node(index +1);
        pnode1.next=nnode;nnode.prve=pnode1;
        size--;
        return node.element;
    }

    @Override
    public E removeByelement(E element) {
        int indexof = indexof(element);
        return  remove(indexof);
    }

    @Override
    public E get(int index) {
       return node(index).element;
    }

    @Override
    public int indexof(E element) {
        if(element == null){
            for(int a = 0;a<size;a++){
                if(node(a).element==null){return a;}
            }
        }else {
            for (int a = 0; a < size; a++) {
                if(element.equals(node(a).element)){return a;}
            }
        }
        return ELEMENT_NOT_FIND;
    }
    //寻找节点的位/*o()*/置的方法
    private Node<E> node(int index){
        rangChecked(index);//检查索引是否正确.
        if(index <= (size>>1)){
            Node rnode = first;
            for(int i = 0 ;i<index;i++){
                rnode = rnode.next;
            }
            return rnode;
        }else{
            Node rnode = first;
            int i1 = size - index;
            for(int i = 0;i< i1;i++){
                rnode = rnode.prve;
            }
            return rnode;
        }
    }
    //节点类
    private static class Node<E>{
        E element;
        Node<E> prve;//前一个节点
        Node<E> next;//后一个节点

        public Node(E element, Node<E> prve, Node<E> next) {
            this.element = element;
            this.prve = prve;
            this.next = next;
        }

        public Node(E element) {
            this.element = element;
        }
    }
    //两个测试头尾节点的方法
    public String TestElement(){
        String s = "DoubleLinkedList:"+"size="+size+"[";
        for(int a = 0;a<size;a++){
            s = s + node(a).prve.element+"_"+
                    node(a).element+"_"+
                    node(a).next.element
                    +",";
        }
        if(size ==0){
            return s+"]";
        }else{
            return s.substring(0, s.length() - 1) + "]";
        }
    }

    @Override
    public String toString() {
        String s = "size="+size+"[";
        for(int a = 0;a<size;a++){
            s = s + node(a).element+",";
        }
        if(size ==0){
            return s+"]";
        }else{
            return s.substring(0, s.length() - 1) + "]";
        }
    }
}
