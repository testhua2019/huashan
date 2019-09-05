package com.hua.linkedList;

public class Joseph {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoys(123);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
        circleSingleLinkedList.countBoy(3, 7, 123);
    }
}

//创建一个单向的环形链表
class CircleSingleLinkedList {
    // 创建一个 first 节点,当前没有编号
    private Boy first = null;

    // 添加小孩节点，构建成一个环形的链表
    public void addBoys(int nums) {
        if (nums < 1) {
            System.out.println("输入的值不正确~");
            return;
        }
        Boy curBoy = null;// 辅助指针，帮助构建环形链表
        for (int i = 1; i <= nums; i++) {
            Boy cur = new Boy(i);
            if (i == 1) {   //如果是第一个小孩
                first = cur;
                first.setNext(first); // 构成环
                curBoy = first;     //让curBoy指向第一个节点
            } else {
                curBoy.setNext(cur);
                cur.setNext(first);
                curBoy = cur;
            }
        }
    }

    /**
     * @param start 表示从第几个小孩开始数
     * @param count 表示数几下
     * @param nums  表示最初有多少小孩在圈中
     */
    public void countBoy(int start, int count, int nums) {
        //数据校验
        if (first == null || start < 1 || start > nums) {
            System.out.println("输入的数据有误或链表中没有数据,请校验");
            return;
        }
        Boy helper = first; //创建一个辅助指针,指向 first 节点的前一个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //报数前,先让first和helper移动k-1次  k指start
        for (int i = 0; i < start - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            if (first == helper) {  //圈中只有一个节点
                System.out.printf("最后小孩的编号是: %d \n", first.getNo());
                break;
            }
            for (int i = 0; i < count - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩的编号是: %d \n", first.getNo());
            helper.setNext(first.getNext());
            first = first.getNext();
        }

    }

    //遍历链表的节点
    public void list() {
        if (first == null) {
            System.out.println("链表为空~");
            return;
        }
        Boy cur = first;
        while (true) {
            System.out.printf("小孩的编号 %d \n", cur.getNo());
            if (cur.getNext() == first) {// 说明已经遍历完毕
                break;
            }
            cur = cur.getNext();
        }
    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

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

}
