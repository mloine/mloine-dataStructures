package com.mloine.queue;

import java.util.Scanner;

/**
 * @Author mloine
 * @Description 数组模拟队列   环形数组
 * @Date 5:12 下午 2020/2/20
 */
public class ArrayCycleQueueDemo {

    public static void main(String[] args) {
            //初始化队列
        ArrayCycleQueue arrayQueue = new ArrayCycleQueue(4);//有效数据最大是3
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
class ArrayCycleQueue{
    // 数组的最大容量
    private int maxSize;

    // 头部 队列的第一个元素的位置
    private int front;

    // 尾部 最后一个元素的后一个位置
    private int rear;

    // 模拟队列
    private int[] arr ;

    //创建队列的构造起
    public ArrayCycleQueue(int maxSize){
        this.maxSize = maxSize;
        arr =new int[this.maxSize];
        // 指向队列头的位置
        this.front = 0;
        // 指向队列尾的后一个位置
        this.rear = 0;
    }

    /**
     * 判断队列是否满
     * @return
     */
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
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
        arr[rear] = n;
        rear = (rear + 1)%maxSize;
    }

    /**
     * 出队列
     */
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空 不能取出数据");
        }
        int result = arr[front];

        front = (front + 1)%maxSize;

        return result;
    }

    /**
     * 显示队列所有数据
     */
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空 没有数据");
            return;
        }
        for (int i = front;i< front + effectiveNums() ;i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    public int effectiveNums(){
        return (rear - front + maxSize) % maxSize ;
    }
    /**
     * 显示队列的头数据 是多少
     */
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空 不能取出数据");
        }
        return arr[front];
    }

}

