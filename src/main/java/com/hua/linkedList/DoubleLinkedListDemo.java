package com.hua.linkedList;

import javax.sound.midi.Soundbank;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(22, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(33, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(44, "林冲", "豹子头");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.list();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        HeroNode2 newHero = new HeroNode2(20, "xioalu", "玉");
        doubleLinkedList.addByOrder(newHero);
        doubleLinkedList.list();
        /*System.out.println("修改后的链表~");
        HeroNode2 newHero = new HeroNode2(1, "songjiang", "小雨");
        doubleLinkedList.updata(newHero);
        doubleLinkedList.list();
        System.out.println("删除后的链表~");
        doubleLinkedList.delete(4);
        doubleLinkedList.list();*/

    }
}

//定义 双向链表
class DoubleLinkedList {
    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    //显示链表(遍历)
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空~~~");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            System.out.println(temp);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }

    //添加节点, 根据排名将英雄插入到指定位置,编号从小到大
    // (如果有这个排名，则添加失败，并给出提示)
    public void addByOrder(HeroNode2 heroNode){
        HeroNode2 temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){ //表示链表中没有数据
                break;
            }
            if (temp.next.no > heroNode.no){    //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            heroNode.next = temp.next;
            temp.next.pre = heroNode;
            temp.next = heroNode;
            heroNode.pre = temp;
        }else {
            temp.next = heroNode;
            heroNode.pre = temp;
        }
    }

    //添加节点到链表的最后
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                //表示链表中没有数据
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //修改节点的信息
    public void updata(HeroNode2 heroNode) {
        //判断是否空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;   //表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", heroNode.no);
        }
    }

    //删除节点
    public void delete(int no) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;   //是否找到指定编号的节点
        while (true) {
            if (temp == null) {
                //找不到节点
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            // 如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
            if (temp.next != null) {    //如果删除的不是最后一个节点,则执行
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }

    }

}

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;    //指向下一个节点
    public HeroNode2 pre;   //指向上一个节点

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
