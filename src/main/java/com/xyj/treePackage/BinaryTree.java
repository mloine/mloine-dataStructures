package com.xyj.treePackage;

import com.xyj.utils.AbstartPrintTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> extends AbstartPrintTree {
    //数据规模
    protected int size;
    //根节点
    protected Node<E> root;

    //下面四个是实现打赢器接口的方法
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

    //内部节点类
    protected static class Node<E>{

        //元素
        E element;

        //左子树
        Node<E> left;

        //右子树
        Node<E> right;

        //父节点
        Node<E> parent;

         Node(E element, Node<E> parent) {
            this.parent = parent;
            this.element = element;
        }

        protected Node() {
        }
        //是否是叶子节点
        protected boolean isLeaf(){
            return left ==null && right == null;
        }
        //是否是度为2
        protected boolean hasTwoChild(){
            return left !=null && right != null;
        }
        @Override
        public String toString() {
            return element.toString();
        }
    }
    //内部控制器
    public static abstract class vistor<E>{
        boolean stop;
        protected abstract boolean vistor(E element);
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
        root = null;
    }
    //前序遍历  自己  左  右
    protected void preorderTraversal(Node<E> node , vistor vis){
        if(node == null){return;}
        boolean vistor = vis.vistor(node.element);
        if(vistor == true){return;}
        preorderTraversal(node.left,vis);
        preorderTraversal(node.right,vis);
    }
    public void preorderTraversal(vistor vis){
        if(root == null||vis == null){return;}
        preorderTraversal(root,vis);
    }

    //中序遍历   左  自己 右
    public void  inorderTraversal(vistor<E> vis){
        if(vis == null || root ==null){return;}
        inorderTraversal(root,vis);
    }
    protected  void  inorderTraversal(Node<E> node, vistor<E> vis){
        if(node == null){return;}
        inorderTraversal(node.left,vis);
        boolean vistor = vis.vistor(node.element);
        if(vistor == true){return;}
        inorderTraversal(node.right,vis);
    }
    //后续遍历  左  右 自己
    protected void postororderTraversal(Node<E> node, vistor vis){
        if(node == null || vis.stop){return;}
        postororderTraversal(node.left,vis);
        postororderTraversal(node.right,vis);
        if(vis.stop == true){return;}
        vis.stop = vis.vistor(node.element);
    }
    public void postororderTraversal(vistor vis){
        if(root == null || vis == null){return;}
        postororderTraversal(root,vis);
    }
    //层序遍历
    public void levelOrderTranversal(vistor<E> vistor){
        if(root == null || vistor == null){return;}
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node<E> poll = queue.poll();
            /*System.out.print(poll.element+",");*/
            boolean vistor1 = vistor.vistor(poll.element);
            if(vistor1 == true){return;}
            if(poll.left!= null){
                queue.offer(poll.left);
            }
            if(poll.right != null){
                queue.offer(poll.right);
            }
        }
    }
    //获取某个节点的高度  用递归
    public int height(Node<E> node){
        if(node == null){return 0;}
        return 1+Math.max(height(node.left),height(node.right));
    }
    //迭代获取数的高度
    public int height(){
        Queue<Node<E>> queue = new LinkedList<>();
        int height = 0;
        int levelSize = 1;
        queue.offer(root);
        while(!queue.isEmpty()){
            Node<E> poll = queue.poll();
            levelSize--;
            if(poll.left!= null){
                queue.offer(poll.left);
            }
            if(poll.right != null){
                queue.offer(poll.right);
            }
            if(levelSize == 0){
                height++;
                levelSize = queue.size();
            }
        }
        return height;
    }

    public boolean isComplete(){
        if(root == null){return false;}
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        while(!queue.isEmpty()){
            Node<E> poll = queue.poll();
            if(leaf && !poll.isLeaf()){
                return false;
            }
            if(poll.hasTwoChild()){
                queue.offer(poll.left);
                queue.offer(poll.right);
            }else if(poll.left == null && poll.right != null){return false;}
            else{leaf = true;
                if(poll.left != null){
                    queue.offer(poll.left);
                }
            }
        }
        return true;
    }

    public void fanzhuanTree(){
        if(root == null){return;}
        Queue<Node<E>> queue = new LinkedList<Node<E>>();
        queue.offer(root);
        while (!queue.isEmpty()){
            //每隔存在的节点都会被推出
            Node<E> poll = queue.poll();
            Node<E> left = poll.left;
            poll.left = poll.right;
            poll.right = left;
            if(poll.left != null){
                queue.offer(poll.left);
            }
            if(poll.right != null){
                queue.offer(poll.right);
            }
        }
    }
    //求前驱节点   就是中序遍历时的前一个节点
    protected Node<E> perNode(Node<E> node){
        if(node == null){return null;}
        if(node.left != null){
            Node<E> left = node.left;
            while(left.right != null){
                left = left.right;
            }
            return left;
        }
        if( node.parent!= null){
            Node<E> eNode = new Node<>();
            eNode = node;
            while(eNode.parent != null){
                Node<E> p = eNode.parent;
                if(p.right == eNode){return p;}
                eNode = p;
            }
        }
        if(node.parent ==null){return null;}
        return null;
    }
    //求后驱节点   就是中序遍历时的后一个节点
    protected Node<E> postNode(Node<E> node){
        if(node == null){return null;}
        if(node.right != null){
            Node<E> left = node.right;
            while(left.left!= null){
                left = left.left;
            }
            return left;
        }
        if( node.parent!= null){
            Node<E> eNode = new Node<>();
            eNode = node;
            while(eNode.parent != null){
                Node<E> p = eNode.parent;
                if(p.left == eNode){return p;}
                eNode = p;
            }
        }
        if( node.parent ==null){return null;}
        return null;
    }
}
