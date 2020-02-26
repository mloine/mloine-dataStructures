package com.mloine.stack;

import java.util.Scanner;

/**
 * @Author mloine
 * @Description
 * @Date 11:48 上午 2020/2/26
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        //1.创建
        ArrayStack arrayStack = new ArrayStack(4);

        //2.
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);


        while(loop){
            System.out.println("show:表示显示栈");
            System.out.println("exit:表示退出程序");
            System.out.println("push:表示添加数据到栈");
            System.out.println("pop:表示从栈取出数据");
            System.out.println("请输入你的选择:");

            key= scanner.next();

            switch (key){
                    case "show":
                        arrayStack.list();
                        break;

                    case "exit":
                        try {
                            loop = false;

                        }catch (Exception e){

                        }finally {
                            scanner.close();
                        }
                        break;

                    case "push":
                        System.out.println("请输入一个数");
                        int value = scanner.nextInt();
                        arrayStack.push(value);
                        break;
                    case "pop":
                        try{
                            int res = arrayStack.pop();
                            System.out.printf("出栈的数据是%d \n",res);
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }finally {
                            break;
                        }
                default: break;
            }
        }
    }

}

// 使用数组模拟栈
class ArrayStack{
    // 栈最大空间
    private int maxSize;

    // 数组模拟栈
    private int[] stack;

    // 栈顶
    private int top  = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * 判断栈满
     * @return
     */
    public boolean isFull(){
        return maxSize - 1 == top;
    }

    /**
     * 判断栈空
     * @return
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * 入栈 - push
     * @param value
     */
    public void push(int value){
        if(isFull()){
            System.out.println("栈满！！！");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈 - pop
     */
    public int pop(){
        if(isEmpty()){
            throw  new RuntimeException("栈空！！ 不能添加");
        }
        int result = stack[top];
        top--;
        return result;
    }

    /**
     * 遍历栈
     */
    public void list(){
        if(isEmpty()){
            System.out.println("栈空 没有数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}
