package com.xyj;


import com.xyj.com.DoubleLinkedList1;

public class Test {
    public static void main(String[] args) {
        DoubleLinkedList1<Object> aa = new DoubleLinkedList1<>();
        boolean empty = aa.isEmpty();
        aa.add(0);
        aa.add(2);
        aa.add(4);
        aa.add(45);
        aa.add(41);

        System.out.println(aa);
        aa.TestElement();

    }
}
