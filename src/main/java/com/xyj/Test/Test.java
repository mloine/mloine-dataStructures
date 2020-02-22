package com.xyj.Test;


import com.xyj.listPackage.CircleSingleLinkedList1;

public class Test {
    public static void main(String[] args) {
       /* List1 aa = new ArrayList1();
        for(int a = 1;a< 200;a++) {
            aa.add(a);
        }
        for(int a = 1;a< 200;a++) {
            aa.removeByelement(a);//参数 如果是int 就不能分辨是索引还是元素
        }
        System.out.println(aa);*/
       /* CircleSingleLinkedList1<Integer> bb = new CircleSingleLinkedList1<>();

        System.out.println(bb);*/
      /* CircleSingleLinkedList ll = new CircleSingleLinkedList<Integer>();
       for(int a = 0 ;a <10 ; a++){
           ll.add(a);
       }
       ll.testCircle();*/


      //约瑟夫环测试
        CircleSingleLinkedList1<Integer> ll = new CircleSingleLinkedList1<Integer>();
        for(int a = 1;a<9;a++){
            ll.add(a);
        }
        System.out.println(ll);
        ll.currentReset();
        int size = ll.size();
        while(ll.size()!=1){
            ll.currentNext();
            ll.currentNext();
            System.out.print("移除："+ll.removeCurrent()+"--");
            System.out.println(ll);
        }
    }
}
