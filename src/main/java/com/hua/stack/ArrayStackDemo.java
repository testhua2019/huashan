package com.hua.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {

        ArrayStack arrayStack = new ArrayStack(4);
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
                arrayStack.list();
            }
            if ("exit".equals(key)) {
                scanner.close();
                loop = false;
            }
            if ("push".equals(key)) {
                System.out.println("请输入要添加的数~");
                int value = scanner.nextInt();
                arrayStack.push(value);
            }
            if ("pop".equals(key)) {
                System.out.printf("取出的数据是: %d\n", arrayStack.pop());
            }
        }
        System.out.println("程序退出~");
    }
}

//使用数组来模拟栈
class ArrayStack {
    private int maxSize;    //栈的最大容量
    private int[] stack;    //使用数组模拟栈
    private int top = -1;    //表示栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //判断栈是否满了
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈~push
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满了,无法加入数据");
            return;
        }
        top++;
        stack[top] = value;
        return;
    }

    //出栈~pop
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈中的数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈为空,没有数据");
            return;
        }
        for (int i = top; top >= 0; top--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }
}
