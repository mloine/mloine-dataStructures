package com.xyj.Test;

import java.util.ArrayList;

public class PrintTreeTest {
    public static void main(String[] args) {
       /* ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        int size = strings.size();
        int length = strings.get(0).length();
        String s = "";
        for(int a = 0;a <size;a++){
            s+=strings.get(a);
            int i = length + 4;
            for(int b = 0;b<i;b++){
                s+=" ";
            }
        }
        System.out.println(s);
        int a = s.indexOf("a");
        System.out.println(a);*/
        ArrayList<ArrayList<Integer>> aa = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        aa.add(integers);
        ArrayList<Integer> integers2 = new ArrayList<>();
        integers2.add(3);
        integers2.add(4);
        integers2.add(null);
        aa.add(integers2);
        System.out.println(aa);

    }
}
