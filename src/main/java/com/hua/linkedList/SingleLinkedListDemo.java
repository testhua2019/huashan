package com.hua.linkedList;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
//先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode newHero = new HeroNode(1, "小宋", "雨");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.list();
        System.out.println("-----------------------------------");
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        HeroNode hero12 = new HeroNode(12, "宋江", "及时雨");
        HeroNode hero22 = new HeroNode(22, "卢俊义", "玉麒麟");
        HeroNode hero32 = new HeroNode(32, "吴用", "智多星");
        singleLinkedList2.addByOrder(hero12);
        singleLinkedList2.addByOrder(hero32);
        singleLinkedList2.addByOrder(hero22);
        singleLinkedList2.list();
        System.out.println("-----------------------------------");

        MergeOrderedList(singleLinkedList.getHead(),singleLinkedList2.getHead());
        singleLinkedList.list();
//        System.out.println("反转过后!~~~~");
//        reverseList(linkedList.head);
//        linkedList.list();

//        System.out.println("从尾到头打印!!");
//        reversePrint(linkedList.head);

        /*
        //创建列表
        SingleLinkedList linkedList = new SingleLinkedList();
//        linkedList.add(hero1);
//        linkedList.add(hero3);
//        linkedList.add(hero2);
//        linkedList.add(hero4);


        linkedList.addByOrder(hero1);
        linkedList.addByOrder(hero3);
        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero2);
        linkedList.list();

        System.out.println("修改后的~~~");
        linkedList.updata(newHero);
        linkedList.list();
        System.out.println("修改后的~~~");
        linkedList.delete(1);
        linkedList.list();
        System.out.println(getLength(linkedList.head));
        System.out.println(findLastIndexNode(linkedList.head, 4));
        */
    }

    public static HeroNode MergeOrderedList(HeroNode first,HeroNode head){
        HeroNode cur1 = first.next;
        HeroNode cur2 = head.next;
        HeroNode result ;
        result = null;
        HeroNode tail = null;
        HeroNode next = null;
        while((cur1 != null)  &&  (cur2 != null)){
            if(cur1.no <= cur2.no){
                if(result != null){   //当结果链表不为空时
                    next = cur1.next;  // 保存链表1的下一个节点，让循环可以继续
                    tail.next = cur1;   // 插入过程
                    cur1.next = null;
                    tail = cur1;  //保存结果链表的最后一个节点
                    cur1 = next;
                }else{   // 结果链表为空时
                    next = cur1.next;
                    result = cur1;
                    cur1.next = null;
                    //保存新的最后一个节点
                    tail = cur1;
                    cur1 = next;

                }
            }else{
                if(result != null){
                    next = cur2.next;
                    tail.next = cur2;
                    cur2.next = null;
                    tail = cur2;
                    cur2 = next;
                }else{
                    next = cur2.next;
                    result = cur2;
                    cur2.next = null;
                    //保存新的最后一个节点
                    tail = cur2;
                    cur2 = next;
                }
            }
        }
        //其中一个链表为空之后
        if(cur1 == null){
            tail.next = cur2;
        }
        if(cur2 == null){
            tail.next = cur1;
        }

        return result;
    }


    //合并两个有序的单链表，合并之后的链表依然有序
    public static void mergeList(HeroNode head1,HeroNode head2){
        if (head1.next == null || head2.next == null) {
            return;
        }
        HeroNode cur1 = head1.next;
        HeroNode cur2 = head2.next;
        HeroNode reverseHead = new HeroNode(0, "", "");
        HeroNode next = null;
        while (cur2 != null){
            next = cur2.next;
            cur2.next = head1.next;
            head1.next = cur2;
            cur2 = next;
        }
//        while (cur1.next != null){
//            if (cur1.next.no > cur1.no){
//                cur1.next = cur1.next.next;
//                cur1.next.next = cur1;
//                head1.next = cur1.next;
//            }
//            cur1 = cur1.next;
//        }

    }

    //从尾到头打印单链表 【百度，要求方式 1：反向遍历 。 方式 2：Stack 栈】
    public static void reversePrint(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());//stack 的特点是先进后出
        }

    }

    //    单链表的反转
    public static void reverseList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表 reverseHead 的最前端
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;//使cur.next=null,然后使后面的节点指向前一个节点
            reverseHead.next = cur; //将 cur 连接到新的链表上
            cur = next;//cur后移
        }
        //将 head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next;
    }

    //查找单链表中的倒数第 k 个结点
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int length = getLength(head);
        //先做一个 index 的校验
        if (index <= 0 || index > length) {
            return null;
        }
        //定义给辅助变量， for 循环定位到倒数的 index
        HeroNode cur = head.next;
        for (int i = 0; i < length - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //求链表中有效节点的个数
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量, 这里我们没有统计头节点
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next; //遍历
        }
        return length;
    }
}

//定义 SingleLinkedList 单链表 管理我们的英雄
class SingleLinkedList {
    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                //表示链表中没有数据
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    /**
     * //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
     * //(如果有这个排名，则添加失败，并给出提示)
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
//因为单链表，因为我们找的 temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;   // flag 标志添加的编号是否存在，默认为 false
        while (true) {
            if (temp.next == null) {
                //到链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) { //位置找到，就在 temp 的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {   //说明希望添加的 heroNode 的编号已然存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);

        } else {
            //插入到链表中, temp 的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 修改节点功能
     * 思路(1) 先找到该节点，通过遍历，(2) temp.name = newHeroNode.name ; temp.nickname= newHeroNode.nickname
     *
     * @param heroNode
     */
    public void updata(HeroNode heroNode) {
        //判断是否空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode temp = head.next;
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

    /**
     * //删除节点
     * //思路
     * //1. head 不能动，因此我们需要一个 temp 辅助节点找到待删除节点的前一个节点
     * //2. 说明我们在比较时，是 temp.next.no 和需要删除的节点的 no 比较
     *
     * @param no
     */
    public void delete(int no) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;   //是否找到指定编号的节点
        while (true) {
            if (temp.next == null) {
                //找不到节点
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }

    }

    //显示链表(遍历)
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空~~~");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            System.out.println(temp);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }

}

//定义 HeroNode ， 每个 HeroNode 对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;    //指向下一个节点

    public HeroNode(int no, String name, String nickName) {
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
