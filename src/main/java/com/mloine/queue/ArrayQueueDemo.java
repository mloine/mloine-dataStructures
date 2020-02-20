package com.mloine.queue;

import java.util.Scanner;

/**
 * @Author mloine
 * @Description 数组模拟队列   数组用一次就不能用了
 * @Date 5:12 下午 2020/2/20
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
            //初始化队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);


        boolean loop = true;
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出");
            System.out.println("a(add):添加队列数据");
            System.out.println("g(gain):从队列取出数据");
            System.out.println("h(header):查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's': arrayQueue.showQueue();break;
                case 'e':
                    try{
                        loop = false;
                    }catch (Exception e){
                    }finally {
                        scanner.close();
                        break;
                    }
                case 'a':
                    System.out.println("输入一个数字");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int queue = arrayQueue.getQueue();
                        System.out.println("取出的数据是"+queue);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }finally {
                        break;
                    }
                case 'h':
                    try{
                        System.out.println("当前队列头的数据是" + arrayQueue.headQueue());;break;
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

// 使用数组模拟队列
class ArrayQueue{
    // 数组的最大容量
    private int maxSize;

    // 头部
    private int front;

    // 尾部
    private int rear;

    // 模拟队列
    private int[] arr ;

    //创建队列的构造起
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr =new int[this.maxSize];
        // 指向队列头的前一个位置
        this.front = -1;
        // 指向队列尾的左后一个位置
        this.rear = -1;
    }

    /**
     * 判断队列是否满
     * @return
     */
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 添加数据
     * @param n
     */
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列满 不能加入数据");
            return;
        }
        rear ++;
        arr[rear] = n;
    }

    /**
     * 出队列
     */
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空 不能取出数据");
        }
        front++;
        return arr[front];
    }

    /**
     * 显示队列所有数据
     */
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空 没有数据");
            return;
        }
        for (int i = 0;i<arr.length;i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    /**
     * 显示队列的头数据 是多少
     */
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空 不能取出数据");
        }
        return arr[front + 1];
    }

}

