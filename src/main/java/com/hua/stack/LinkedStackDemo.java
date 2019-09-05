package com.hua.stack;


import java.util.Scanner;

public class LinkedStackDemo {
    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack(3);
        boolean loop = true;
        String key = "";
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 程序退出");
            System.out.println("push: 添加数据到栈(入栈)");
            System.out.println("pop: 从栈中取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = scanner.next();
            if ("show".equals(key)) {
                linkedStack.list();
            }
            if ("exit".equals(key)) {
                scanner.close();
                loop = false;
            }
            if ("push".equals(key)) {
                System.out.println("请输入要添加的数~");
                int value = scanner.nextInt();
                NumNode node = new NumNode(value);
                linkedStack.push(node);
            }
            if ("pop".equals(key)) {
                System.out.println("取出的数据是: ");
                System.out.println(linkedStack.pop().getNo());
            }
        }
        System.out.println("程序退出~");
    }
}


//使用链表模拟栈
class LinkedStack {

    private int maxSize = 0;
    private NumNode head;

    public LinkedStack(int maxSize) {
        head = new NumNode();
    }


    public boolean isEmpty() {
        return head.getNext() == null;
    }

    //入栈
    public void push(NumNode num) {
        if (head.getNext() != null) {
            //youshuju
            num.setNext(head.getNext());
        }
        head.setNext(num);
        maxSize++;
    }

    //chuzhan
    public NumNode pop() {
        if (isEmpty()) {
            System.out.println("kong~");
        }
        NumNode node = head.getNext();
        head.setNext(head.getNext().getNext());
        maxSize--;
        return node;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("kong~");
        }
        NumNode temp = head.getNext();
        for (int i = 0; i < maxSize; i++) {
            System.out.println(temp.getNo());
            temp = temp.getNext();
        }
    }
}

//定义 HeroNode ， 每个 HeroNode 对象就是一个节点
class NumNode {
    private int no;
    private NumNode next;    //指向下一个节点

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public NumNode getNext() {
        return next;
    }

    public void setNext(NumNode next) {
        this.next = next;
    }

    public NumNode(int no) {
        this.no = no;
    }

    public NumNode() {

    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}
