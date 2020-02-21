package com.xyj;

import utils.Check;

//这个类主要学习时间复杂度和空间复杂度
public class Main {
    /*斐波那系数
    项数 0 1 2 3 4 5 6
    数值 0 1 1 2 3 5 8
    a(n) = a (n-1)  + a (n-2)
    * */
    public static void main(String[] args) {
        Check.checked("anintdigui", new Check.task() {
            @Override
            public void excute() {
                anIntDigui(46);
            }
        });
        Check.checked("anintxiangjia", new Check.task() {
            @Override
            public void excute() {
                anintXiangJia(46);
            }
        });
    }

    /*用递归求系数an的值
    * 缺点算比较大的数的时候，太慢不可取
    * 时间复杂度o(2^n)
    * */
    public static int anIntDigui(int a){
        if(a <= 1){
            return a;
        }
        else{
         return anIntDigui(a-1) + anIntDigui(a-2);}
    }
    /*换一种思路
    * 时间复杂度o(n)
    * */
    public static int anintXiangJia(int a ){
        if(a <= 1){
            return a;
        }
         int first = 0;
         int second = 1;
         for(int c = 0;c < a -1;c++){
             int sum = first +second;
             first = second;
             second = sum;
         }
         return  second;
    }
}

