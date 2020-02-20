package com.xyj.utils;

import java.util.Date;

//这个类主要是测试运行时间
public class Check {
    public interface task{
        void excute();
    }
    public static void checked(String title,task task){
        if(task == null){return;}
        System.out.println("开始");
        System.out.println("["+title+"]");
        System.out.println(new Date());
        long l = System.currentTimeMillis();
        task.excute();
        System.out.println("结束");
        long l1 = System.currentTimeMillis();
        System.out.println(new Date());
        System.out.println("用时"+(l1-l)/1000.0+"s");
        System.out.println("------------------");
    }
}
