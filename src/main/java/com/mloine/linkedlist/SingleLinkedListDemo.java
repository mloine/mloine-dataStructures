package com.mloine.linkedlist;

import java.util.Stack;

/**
 * @Author mloine
 * @Description 单链表
 * @Date 2:34 下午 2020/2/22
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);

        //按照顺序
        singleLinkedList.addSort(hero1);
        singleLinkedList.addSort(hero4);
        singleLinkedList.addSort(hero2);
        singleLinkedList.addSort(hero3);
        singleLinkedList.addSort(hero3);

        singleLinkedList.list();
        //测试修改节点的代码
        HeroNode heroUpdate = new HeroNode(2, "薛勇康", "程序猿");
        singleLinkedList.updateByNo(heroUpdate);

        //测试删除
        singleLinkedList.delByBo(1);
//        singleLinkedList.delByBo(4);
//        singleLinkedList.delByBo(2);
//        singleLinkedList.delByBo(3);

        System.out.println("修改后的情况");
        singleLinkedList.list();

        //1.连标有效数据长度
        System.out.println("链表有效数据长度为：" + SingleLinkedList.getLength(singleLinkedList.getHeader()));

        //2.查找单链表中倒数第k个节点
        System.out.println("倒数第2个节点:" + SingleLinkedList.getReversalHeroNodeByIndex(singleLinkedList.getHeader(),2) );
        System.out.println("倒数第4个节点:" + SingleLinkedList.getReversalHeroNodeByIndex(singleLinkedList.getHeader(),4) );

        //3.单链表的反转
        System.out.println("反转前的情况");
        singleLinkedList.list();
        SingleLinkedList.ReverseLinkedList(singleLinkedList.getHeader());
        System.out.println("反转后的情况");
        singleLinkedList.list();

        //4.从尾到头打印单链表
        System.out.println("逆序打印 单链表 递归");
        SingleLinkedList.printLinedListDesc(singleLinkedList.getHeader());
        System.out.println("逆序打印 单链表 利用栈结构");
        SingleLinkedList.printLinedListDescByStack(singleLinkedList.getHeader());


        //5.合并
        System.out.println("1列表");
        singleLinkedList.list();
        System.out.println("2列表");
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList2.add(new HeroNode(5, "宋江", "及时雨"));
        singleLinkedList2.add(new HeroNode(6, "宋江", "及时雨"));
        singleLinkedList2.add(new HeroNode(7, "宋江", "及时雨"));
        singleLinkedList2.list();
        System.out.println("合并后列表");
        SingleLinkedList.mergeLinedList(singleLinkedList.getHeader(),singleLinkedList2.getHeader()).list();
    }
}

// 管理节点
class SingleLinkedList{
    //先初始化头节点 不存放具体的思路
    private HeroNode header = new HeroNode(0,"","");



    public HeroNode getHeader() {
        return header;
    }

    /**
     * 添加节点到单项列表
     * 1.找到当前链表的尾节点
     * 2.next指向node
     */
    public void add(HeroNode heroNode){
        HeroNode tmp = header;

        while(true){
            if(tmp.next == null){ break;}
            //没找到就后移
            tmp = tmp.next;
        }
        //退出循环时候 tmp指向链表的最后
        tmp.next = heroNode;
    }

    /**
     * 添加节点到单项列表 按顺序地址
     * 1.找到当前合适地址
     * 2.next指向node
     */
    public void addSort(HeroNode heroNode){
        HeroNode tmp = header;
        //添加的编号是否存在
        boolean flag = false;
        while(true){
            if(tmp.next == null){
                //在链表最后
                break;
            }else if(tmp.next.no > heroNode.no){
                //找到位置  就在tmp后面添加
                break;
            }else if(tmp.next.no == heroNode.no){
                // 希望添加的编号已经存在
                flag = true;
                break;
            }

            //后移
            tmp = tmp.next;
        }
        //退出循环时候 tmp指向链表的最后
        if(flag){
            //不能添加 说明编号已经存在
            System.out.printf("准备插入的英雄编号%d 已经存在不能加入\n",heroNode.no);
        }else{
            //修改节点的指向
            heroNode.next = tmp.next;
            tmp.next = heroNode;
        }
    }

    /**
     * 显示链表
     */
    public void list(){
        if(header.next == null){
            System.out.println("链表为空！！！！！！");
            return;
        }
        HeroNode tmp = header.next;
        while(true){
            if(tmp == null){ break; }
            System.out.println(tmp);
            // 后移
            tmp = tmp.next;
        }

    }

    /**
     * 更具编号修改数据
     * 1.更具heronode的no修改
     */
    public void updateByNo(HeroNode heroNode){
        if(header.next == null){
            System.out.println("链表为空！！！！！！");
        }
        //找到需要修改的节点
        HeroNode tmp = header.next;
        //表示是否找到
        boolean flag = false;
        while(true){
            if(tmp == null){
                break;
            }else if(tmp.no == heroNode.no){
                //找到了
                flag = true;
                break;
            }
            tmp = tmp.next;
        }

        if(flag){
            //找到需要修改的节点
            tmp.name = heroNode.name;
            tmp.linkName =heroNode.linkName;
        }else{
            System.out.printf("没有找到编号为%d的节点",heroNode.no);
        }
    }

    /**
     * 删除节点
     * @param no
     */
    public void delByBo(int no){
        HeroNode tmp = header;
        boolean flag = false;
        while(true){
            if(tmp.next == null){
                break;
            }else if(tmp.next.no == no){
                flag = true;
                break;
            }
            tmp = tmp.next;
        }

        if(flag){
            tmp.next = tmp.next.next;
        }else{
            System.out.printf("没有需要删除编号为%d的节点\n",no);
        }
    }

    //1.获取单链表有效节点的个数 头节点的列表不统计
    public static int getLength(HeroNode header){
        if(header.next == null){return 0;}
        int length = 0;

        HeroNode headerCur = header.next;
        while(headerCur != null){
            length ++;
            headerCur = headerCur.next;
        }
        return length;
    }

    //2.获取单链表倒数第k个节点
    public static HeroNode getReversalHeroNodeByIndex(HeroNode header,int index){
        if(header.next == null){return null;}
        // 总个数
        int length = getLength(header);
        if(length == 0 || index <= 0 || index > length){return null;}

        HeroNode tmp = header.next;
        for (int i = 0; i < length - index; i++) {
            tmp = tmp.next;
        }

        return tmp;

    }

    //3.反转单项链表 个人实现
    public static void ReverseLinkedList(HeroNode header) {
        if(header.next == null || header.next.next == null){return;}
        // 临时头节点
        HeroNode headerTmp = header.next;
        HeroNode next = null;
        HeroNode reverHeader = new HeroNode(0,"","");

        while(headerTmp != null){
            //暂存当前节点的下一个节点
            next = headerTmp.next;
            // 处理
            headerTmp.next = reverHeader.next;
            reverHeader.next = headerTmp;
            //指向修改
            headerTmp = next;
        }
        header.next = reverHeader.next;
    }

    //4.逆序打印单链表 个人实现 递归
    public static void printLinedListDesc(HeroNode header){
        HeroNode tmp = header.next;
        if(tmp != null){
            printLinedListDesc(tmp);
            System.out.println(tmp);
        }
    }
    //4.逆序打印单链表 栈结构 栈 先进后出
    public static void printLinedListDescByStack(HeroNode header){
        if(header.next == null){return;}
        Stack<HeroNode> heroNodeStack = new Stack<>();
        HeroNode tmp = header.next;
        while(tmp!=null){
            heroNodeStack.push(tmp);
            tmp = tmp.next;
        }

        while(heroNodeStack.size() > 0){
            System.out.println(heroNodeStack.pop());
        }
    }

    //5.合并两个链表,结果有序
    public static SingleLinkedList mergeLinedList(HeroNode header1,HeroNode header2){
        HeroNode sortTmp = null;
        //1.先排序插入
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        sortTmp = header1.next;
        while(sortTmp != null){
            HeroNode next = sortTmp.next;
            singleLinkedList1.addSort(sortTmp);
            sortTmp = next;
        }
        sortTmp = header2.next;
        while(sortTmp != null){
            HeroNode next = sortTmp.next;
            singleLinkedList1.addSort(sortTmp);
            sortTmp = next;
        }
        return singleLinkedList1;
        //2.处理
//        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        HeroNode tmp = singleLinkedList.header;
//        HeroNode tmp1 = header1.next;
//        HeroNode tmp2 = header2.next;
//        boolean flag = true;
//        while(flag){
//            if(tmp1 == null && tmp2 == null){
//                flag = false;
//            }else if(tmp1 == null){
//                tmp.next = tmp2;
//                tmp2 = tmp2.next;
//            }else if(tmp2 == null){
//                tmp.next = tmp1;
//                tmp1 = tmp1.next;
//            }else {
//                if(tmp1.no < tmp2.no){
//                    tmp.next = tmp1;
//                    tmp1 = tmp1.next;
//                }else if(tmp1.no > tmp2.no){
//                    tmp.next = tmp2;
//                    tmp2 = tmp2.next;
//                }else{
//                    tmp.next = tmp1;
//                    tmp1 = tmp1.next;
//                    tmp.next = tmp2;
//                    tmp2 = tmp2.next;
//                }
//            }
//            tmp = tmp.next;
//        }
//
//        return singleLinkedList;
    }


}

//定义 heroNode
class HeroNode{

    public int no;
    public String name;
    public String linkName;

    // 指向下一个节点
    public HeroNode next;

    // 构造器
    public HeroNode(int no, String name, String linkName) {
        this.no = no;
        this.name = name;
        this.linkName = linkName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", linkName='" + linkName + '\'' +
                '}';
    }
}
