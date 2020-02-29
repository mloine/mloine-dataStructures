package com.xyj.Test;

import com.xyj.model.Person;
import com.xyj.treePackage.BinarySearchTree;


import java.util.ArrayList;
import java.util.Comparator;



public class BinarySearchTreeTest{


    public static class PersonComparetor implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAge()-o1.getAge();
        }
    }
    public static class PersonComparetor1 implements Comparator<Integer>{
        @Override
        public int compare(Integer e1, Integer e2) {
            return e1-e2;
        }
    }

    public static void main(String[] args) {
        /*testPrintlnTree();*/
       testPrintlnTree();

    }
    public static void test(){
        BinarySearchTree<Integer> ii = new BinarySearchTree<>();
        for(int a = 0;a <10;a++){
            ii.add((int)(Math.random()*1000));
        }
        System.out.println(ii);
    }

    //测试画树
    public static void testPrintlnTree(){
        ArrayList<Integer> ii = new ArrayList<>();
        ii.add(7);
        ii.add(4);
        ii.add(9);
        ii.add(2);
        ii.add(2);
        ii.add(1);
        ii.add(11);
        ii.add(1);
        ii.add(3);
        ii.add(10);
        ii.add(12);
        ii.add(13);

        BinarySearchTree<Integer> pp = new BinarySearchTree<>();
        for(Integer a:ii){
            pp.add(a);
        }
        pp.remove(1);
        pp.remove(3);
        pp.remove(12);
        pp.remove(9);
        pp.remove(7);
        pp.remove(2);
        pp.remove(4);
        pp.remove(10);
        pp.add(9);
        pp.printlnTree();
        pp.preorderTraversal(new BinarySearchTree.vistor<Integer>() {
            @Override
            protected boolean vistor(Integer element) {
                System.out.print("-"+element+"-");
               /* if(element == 9){return true;}*/
                return false;
            }
        });


        System.out.println("");
        pp.inorderTraversal(new BinarySearchTree.vistor<Integer>() {
            @Override
            protected boolean vistor(Integer element) {
                System.out.print("-"+element+"-");
                return false;
            }
        });
        System.out.println("");
        pp.postororderTraversal(new BinarySearchTree.vistor<Integer>() {
            @Override
            protected boolean vistor(Integer element) {
                System.out.print("-"+element+"-");
                if(element == 9){return true;}
                return false;
            }
        });
        System.out.println("");
        System.out.println("层序遍历");
        pp.levelOrderTranversal(new BinarySearchTree.vistor<Integer>() {
            @Override
            protected boolean vistor(Integer element) {
                System.out.print("-"+element+"-");
                /*if(element == 9){return true;}*/
                return false;
            }
        });
        System.out.println("");
        System.out.println(pp.height());
        System.out.println(pp.isComplete());
        /*pp.fanzhuanTree();*/
       /* pp.printlnTree();*/
       /* pp.testpre();*/
        System.out.println("");
        /*pp.testpost();*/
    }

    public static void testString(){
        StringBuffer aa = new StringBuffer();
        /*aa.append("  ");
        aa.append("a");*/
        System.out.println(aa);
        System.out.println("");
        System.out.println(aa.length());
        System.out.println();
    }

    public static void test5(){
        System.out.println(Math.pow(2,-1));
    }
    public static void test6(){
        System.out.println(2%2);
    }
    public static void StringTest(){

        StringBuffer asd = new StringBuffer("asd");
        StringBuffer asd1 = new StringBuffer("asd");
        System.out.println(asd.toString().equals(asd1.toString()));

    }

}
