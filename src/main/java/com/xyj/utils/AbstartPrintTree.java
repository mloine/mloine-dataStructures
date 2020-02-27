package com.xyj.utils;

import com.xyj.treePackage.BinarySearchTree;
import sun.font.TrueTypeFont;

import java.util.ArrayList;
/*
* 继承这个类
* 实现
*
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
    *
    * 调用printtree()方法 就可以打印二叉树的图像
*
* */
public abstract class AbstartPrintTree implements PrintlnTree {

    @Override
    public ArrayList<StringBuffer> deleteMore(ArrayList<StringBuffer> list) {
        ArrayList<StringBuffer> result = new ArrayList<>();
        int size = list.size()-3;
        for(int a =0;a<size;a++){
            if(!list.get(a).toString().equals(list.get(a+1).toString())||
                    !list.get(a).toString().equals(list.get(a+2).toString())||
                    !list.get(a).toString().equals(list.get(a+3).toString())
            ){
                result.add(list.get(a));
            }
        }
        return result;
    }

    @Override
    public ArrayList<StringBuffer> optStringList(ArrayList<StringBuffer> list) {
        //首先把字符串集合里的字符串都变成一样的长度
        int finalLength = list.get(0).length();
        int size = list.size();
        for(int a = 0;a<size;a++){
            StringBuffer ss = list.get(a);
            int length = ss.length();
            int cha = finalLength - length;
            if(cha>0){
                for(int b = 0;b<cha;b++){
                    ss.append(" ");
                }
            }
            list.set(a,ss);
        }
        //用来存放竖着的字符串
        ArrayList<StringBuffer> stringShu = new ArrayList<>();
        for(int l = 0 ; l < finalLength; l++){
            StringBuffer str = new StringBuffer();
            for(int s = 0;s<size;s++){
                char c = list.get(s).charAt(l);
                str.append(c);
            }
            stringShu.add(str);
        }
        //删除竖线中不足要的东西,让图好看点
            stringShu = deleteMore(stringShu);

        //转换成树图
        int finalLength1 = stringShu.get(0).length();
        int size1 = stringShu.size();
        ArrayList<StringBuffer> list1 = new ArrayList<>();

        for(int l = 0 ; l < finalLength1; l++){
            StringBuffer str = new StringBuffer();
            for(int s = 0;s<size1;s++){
                char c = stringShu.get(s).charAt(l);
                str.append(c);
            }
            list1.add(str);
        }
        return list1;
    }

    @Override
    public void printlnTree() {
        ArrayList<StringBuffer> tree = showTree();
        ArrayList<StringBuffer> shuXian = shuXian();
        ArrayList<StringBuffer> list = new ArrayList<>();
        int size1 = tree.size()-1;
        for(int a = size1; a>= 0; a--){
            list.add(tree.get(a));
            list.add(shuXian.get(a));
        }
        int size2 = list.size();
        list.remove(size2-1);
        list = optStringList(list);
        size2 = list.size();
        for(int c= 0;c<size2;c++){
            System.out.println(list.get(c));
        }
    }

    @Override
    public Integer getMaxElementLength() {
        ArrayList<ArrayList> arrayLists = showTreeList();
        int length = 0;
        for(ArrayList a:arrayLists){
            int size = a.size();
            for(int b = 0;b <size;b++){
                Object node = a.get(b);
                if (node != null) {
                    Object element = getNodeElement(node);
                    if(element !=null){
                        int length1 = element.toString().length();
                        if(length1>length){length = length1;}
                    }
                }
            }
        }
        if(length%2 == 1){length += 1;}
        return length;
    }

    @Override
    public int getTreeDepth(Object root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(left(root)), getTreeDepth(right(root))));
    }

    @Override
    public ArrayList<ArrayList> showTreeList() {
        Object root = getRoot();
        int treeDepth = getTreeDepth(root);
        int cc = treeDepth-1;
        ArrayList<ArrayList> arrayLists = new ArrayList<>();
        for(int a = 0 ;a<cc;a++){
            if(a == 0){
                ArrayList es = new ArrayList<>();
                es.add(root);
                arrayLists.add(es);
            }
            ArrayList currentList = arrayLists.get(a);
            ArrayList nodes = new ArrayList<>();
            int size = currentList.size();
            for(int b = 0;b <size;b++){
                Object node = currentList.get(b);
                if(node == null){
                    nodes.add(null);
                    nodes.add(null);
                }else {
                    nodes.add(left(node));
                    nodes.add(right(node));
                }
            }
            arrayLists.add(nodes);
        }
        return arrayLists;
    }

    @Override
    public ArrayList<StringBuffer> showTree() {
        ArrayList<StringBuffer> strings = new ArrayList<>();
        double eLength = (double) getMaxElementLength();
        ArrayList<ArrayList> arrayLists = showTreeList();
        int size = arrayLists.size();
        //从后便利
        for(int a = 1;a<=size;a++){
            StringBuffer ss = new StringBuffer();//每层的最终字符串
            StringBuffer sxian = new StringBuffer();//每层上面的线
            ArrayList nodes = arrayLists.get(size - a);
            double start = 0;//--0--这样的出现的第一个位置
            if(a != 1){start = (((2*eLength)+4)*(Math.pow(2,a-3))-2-(eLength/2)); }
            double xian = 0;//--每层线的长度
            if(a!= 1){xian =(((2*eLength)+4)*(Math.pow(2,a-3))-(eLength/2)); }
            double jiange = eLength+4;//每层--0-- 之间的间隔
            if(a != 1){jiange = ((2*eLength)+4)*(Math.pow(2,a-2));} //没有小数
            int size1 = nodes.size();
            for(int p = 0;p<start;p++){ss.append(" ");}
            for(int i = 0;i<size1;i++){
                //遍历nodes集合做操作
                Object node = nodes.get(i);
                if(node == null){
                    for(int q = 0;q<xian;q++){ss.append(" ");}
                    for(int q1 = 0;q1<eLength;q1++){ss.append(" ");}
                    for(int q2 = 0;q2<xian;q2++){ss.append(" ");}
                }else {
                    if (left(node) == null) {
                        for (int q = 0; q < xian; q++) {
                            ss.append(" ");
                        }
                    } else {
                        for (int q = 0; q < xian; q++) {
                            ss.append("-");
                        }
                    }
                    String s = getNodeElement(node).toString();
                    s = xiuGai(s);
                    ss.append(s);
                    if (right(node) == null) {
                        for (int q = 0; q < xian; q++) {
                            ss.append(" ");
                        }
                    } else {
                        for (int q = 0; q < xian; q++) {
                            ss.append("-");
                        }
                    }
                }
                for(int q = 0;q<jiange;q++){ss.append(" ");}
            }

            strings.add(ss);
        }
        return strings;
    }

    @Override
    public ArrayList<StringBuffer> shuXian() {
        ArrayList<StringBuffer> strings = new ArrayList<>();
        double eLength = (double) getMaxElementLength();
        ArrayList<ArrayList> arrayLists = showTreeList();
        int size = arrayLists.size();
        //从后便利
        for(int a = 1;a<=size;a++){
            StringBuffer ss = new StringBuffer();//每层的最终字符串
            StringBuffer sxian = new StringBuffer();//每层上面的线
            ArrayList nodes = arrayLists.get(size - a);
            double start = 0;//--0--这样的出现的第一个位置
            if(a != 1){start = (((2*eLength)+4)*(Math.pow(2,a-3))-2-(eLength/2)); }
            double xian = 0;//--每层线的长度
            if(a!= 1){xian =(((2*eLength)+4)*(Math.pow(2,a-3))-(eLength/2)); }
            double jiange = eLength+4;//每层--0-- 之间的间隔
            if(a != 1){jiange = ((2*eLength)+4)*(Math.pow(2,a-2));} //没有小数
            int size1 = nodes.size();
            for(int p = 0;p<start;p++){ss.append(" ");}
            for(int i = 0;i<size1;i++){
                //遍历nodes集合做操作
                Object node = nodes.get(i);
                if(node == null){
                    for(int q = 0;q<xian;q++){ss.append(" ");}
                    for(int q1 = 0;q1<eLength;q1++){ss.append(" ");}
                    for(int q2 = 0;q2<xian;q2++){ss.append(" ");}
                }else {
                    if (left(node) == null) {
                        for (int q = 0; q < xian; q++) {
                            ss.append(" ");
                        }
                    } else {
                        ss.append("|");
                        for (int q = 1; q < xian; q++) {
                            ss.append(" ");
                        }
                    }
                    String s = getNodeElement(node).toString();
                    s = xiuGai(s);
                    int length2 = s.length();
                    for(int j = 0;j<length2;j++){ss.append(" ");}
                    if (right(node) == null) {
                        for (int q = 0; q < xian; q++) {
                            ss.append(" ");
                        }
                    } else {
                        for (int q = 1; q < xian; q++) {
                            ss.append(" ");
                        }
                        ss.append("|");
                    }
                }
                for(int q = 0;q<jiange;q++){ss.append(" ");}
            }

            strings.add(ss);
        }
        return strings;
    }

    @Override
    public String xiuGai(String s) {
        Integer maxElementLength = getMaxElementLength();
        if(s.length() == maxElementLength){return s;}
        int i = maxElementLength - s.length();//差的长度
        if(i == 1){return " "+s;}
        if(i %2 == 0){
            int i1 = i / 2;
            for(int l = 0;l<i1;l++){
                s = " "+s;
            }
            for(int l = 0;l<i1;l++){
                s = s+" ";
            }
            return s;
        }else{
            s  = " " +s;
            int i1 = (i - 1)/2;
            for(int l = 0;l<i1;l++){
                s = " "+s;
            }
            for(int l = 0;l<i1;l++){
                s = s+" ";
            }
            return s;
        }
    }
}
