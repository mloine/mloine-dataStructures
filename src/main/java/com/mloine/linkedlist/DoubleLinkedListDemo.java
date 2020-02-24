package com.mloine.linkedlist;
/**
 * @Author mloine
 * @Description 双向链表
 * @Date 6:24 下午 2020/2/24
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        //创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        //创建
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        //显示
        doubleLinkedList.list();

        //修改测试
        HeroNode2 heroUpdate = new HeroNode2(4, "公孙胜", "入云龙");

        doubleLinkedList.updateByNo(heroUpdate);
        System.out.println("修改后的情况");
        doubleLinkedList.list();

        //删除测试
        doubleLinkedList.delByBo(3);
        System.out.println("删除后展示");
        doubleLinkedList.list();

        //有序添加测试
        doubleLinkedList.addSort(hero3);
        // 尾部添加测试
        HeroNode2 hero5 = new HeroNode2(5, "薛勇康", "程序猿");
        doubleLinkedList.addSort(hero5);
        System.out.println("有序添加后展示");
        doubleLinkedList.list();


    }

}

class DoubleLinkedList{

    //先初始化头节点 不存放具体的思路
    private HeroNode2 header = new HeroNode2(0,"","");

    public HeroNode2 getHeader() {
        return header;
    }

    /**
     * 显示链表
     */
    public void list(){
        if(header.next == null){
            System.out.println("链表为空！！！！！！");
            return;
        }
        HeroNode2 tmp = header.next;
        while(true){
            if(tmp == null){ break; }
            System.out.println(tmp);
            // 后移
            tmp = tmp.next;
        }

    }

    /**
     * 添加节点到双向列表的最后
     * 1.找到当前链表的尾节点
     * 2.next指向node   node.pre = 尾节点
     */
    public void add(HeroNode2 heroNode){
        HeroNode2 tmp = header;

        while(true){
            if(tmp.next == null){ break;}
            //没找到就后移
            tmp = tmp.next;
        }
        //退出循环时候 tmp指向链表的最后
        tmp.next = heroNode;
        heroNode.pre = tmp;
    }

    /**
     * 添加节点到双项列表 按顺序地址
     * 1.找到当前合适地址
     * 2.next指向node
     */
    public void addSort(HeroNode2 heroNode){
        HeroNode2 tmp = header;
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
            heroNode.pre = tmp;

            if(tmp.next != null){tmp.next.pre = heroNode;}
            tmp.next = heroNode;

        }
    }

    /**
     * 更具编号修改数据
     * 1.更具heronode的no修改
     */
    public void updateByNo(HeroNode2 heroNode){
        if(header.next == null){
            System.out.println("链表为空！！！！！！");
        }
        //找到需要修改的节点
        HeroNode2 tmp = header.next;
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
        if(header.next == null){
            System.out.println("链表为空 不能删除");
        }

        HeroNode2 tmp = header.next;
        boolean flag = false;

        // 直接找到需要删除的节点
        while(true){
            if(tmp == null){
                break;
            }else if(tmp.no == no){
                flag = true;
                break;
            }
            // 没找到 后移
            tmp = tmp.next;
        }

        if(flag){
            //自我删除
            tmp.pre.next = tmp.next;
            if(tmp.next != null){ tmp.next.pre = tmp.pre;}
        }else{
            System.out.printf("没有需要删除编号为%d的节点\n",no);
        }
    }


}

// 双向链表节点 结构
class HeroNode2{

    public int no;
    public String name;
    public String linkName;

    // 指向下一个节点
    public HeroNode2 next;

    // 指向前一个节点
    public HeroNode2 pre;

    // 构造器
    public HeroNode2(int no, String name, String linkName) {
        this.no = no;
        this.name = name;
        this.linkName = linkName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", linkName='" + linkName + '\'' +
                '}';
    }
}

