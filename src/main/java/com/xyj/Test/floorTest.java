package com.xyj.Test;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class floorTest {
    public static void main(String[] args) {
       /* int a = 5/2;
        System.out.println(a);
        //默认向下取整.*/

        int a = 9;
        double pow = Math.pow(2, a)-1;
        double ten = 768-pow;
        double nine = Math.pow(2,8)-(ten+1)/2;
        double result = ten +nine;
        System.out.println("自己的办法："+result);

        //n 总节点   n0叶子    n1端口为1    n2端口为2
        // n= n0+n1+n2
        //n0 = n2 +1
        //推导出   n = 2n0 +n1 -1
        //全权二叉树的n1 要么是1 要么是0
        //推导出   n = 2n0   或者   n = 2n0 -1
        //推导出   n0 =n >>1    或者   n0 = (n+1)/2
        //推导出    n0 = floor((n+1)/2)    floor是向下取整
        //放在代码中就是   知道完全二叉树的总结点n  求叶子
        //n0 = (n+1)>>1
        System.out.print("推导出的公式算出：");
        System.out.println((768+1)>>1);
    }
}
