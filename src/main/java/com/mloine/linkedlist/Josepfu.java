package com.mloine.linkedlist;
/**
 * @Author mloine
 * @Description 单项环形链表   约瑟夫问题
 * @Date 1:23 下午 2020/2/25
 */
public class Josepfu {

    public static void main(String[] args) {

        //1.构建
        CycleSingleLinkedList cycleSingleLinkedList = new CycleSingleLinkedList();
        cycleSingleLinkedList.addBoy(5);

        //2.显示
        cycleSingleLinkedList.showBoy();

        //3.测试 小孩出圈子是否正确    2 4 1 5 3
        cycleSingleLinkedList.countBoy(1,2,5);

        System.out.println("约瑟夫问题");
        CycleSingleLinkedList cycleSingleLinkedList2 = new CycleSingleLinkedList();
        cycleSingleLinkedList2.addBoy(6);
        cycleSingleLinkedList2.countBoy(1,5,6);


    }


}

//环形单向链表
class CycleSingleLinkedList{

    //指向第一个节点
    private Boy first = null;

    //添加小孩
    public void addBoy(int nums){
        if(nums < 1 ){
            System.out.println("nums 值不正确!!!");
            return;
        }

        Boy curBoy = null;
        //for循环来创建环形链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if(i == 1){
                first = boy;
                boy.setNext(first);
                curBoy = first;
            }else{
                //第二个小孩
                boy.setNext(first);
                curBoy.setNext(boy);
                curBoy = boy;
            }

        }
    }

    //遍历当前环形链表
    public void showBoy(){
        //判断链表是否为空
        if(first == null){
            System.out.println("链表为空 ！！");
            return;
        }

        Boy curBoy = first;

        while(true){
            System.out.printf("小孩编号：%d \n",curBoy.getNo());
            if(curBoy.getNext() == first){
                break;
            }else{
                curBoy = curBoy.getNext();
            }
        }

    }

    /**
     *  根据用户的输入 计算出 小孩出圈的顺序
     * @param startNo 第几个小孩开始
     * @param countNum  数几下
     * @param nums  最初有多少小孩在圈中
     */
    public void countBoy(int startNo,int countNum,int nums){

        //先对数据做娇艳
        if(first == null || startNo < 1 || startNo > nums || countNum <= 0){
            System.out.println("参数输入 有误 ");
            return;
        }

        //辅助指针
        Boy helper = first;

        //1. helper 指向环形链表的最后一个节点
        while(true){
            if(helper.getNext() == first){
                break;
            }else{
                helper = helper.getNext();
            }
        }

        //2. 移动startNo-1 次
        for (int i = 0; i < startNo - 1; i++) {
            helper = helper.getNext();
            first = first.getNext();
        }

        //3.移动 countNum 次 出圈
        while(true){
            // 圈中只有一个人
            if(helper == first){
                break;
            }else{
                // 报数
                for (int i = 0; i < countNum - 1; i++) {
                    helper = helper.getNext();
                    first = first.getNext();
                }
                //出圈
                System.out.printf("小孩%d出圈子\n ",first.getNo());
                first = first.getNext();
                helper.setNext(first);
            }

        }
        System.out.printf("最后留在圈中的小孩是%d \n",helper.getNo());
    }

}


// 节点模型
class Boy{

    private int no;

    //指向下一个节点
    private Boy next;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy(int no) {
        this.no = no;
    }
}


