package com.hua.queue;

import java.util.Scanner;


public class CircleArrayDemo {

    public static void main(String[] args) {


        //测试队列
        CircleArray queue = new CircleArray(4); //说明设置 4, 其队列的有效数据最大是 3
        char key;
        Scanner scanner = new Scanner(System.in);

        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(gead):查看队列头的数据");
            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    queue.list();
                    break;
                case 'a':
                    System.out.println("请上输入添加的数据");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
            }
        }

        System.out.println("程序退出~~~");
    }
}


//使用数组模拟环形队列
class CircleArray {
    private int maxSize;    //队列的最大容量
    //front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
    //front 的初始值 = 0
    private int front;
    //rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
    //rear 的初始值 = 0
    private int rear;
    private int[] arr;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
    }

    //判断队列是否满
    public boolean isFull() {
        //(3+1) % 4 == 0;
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //给队列添加元素
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满,不能添加数据~~~");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    //获取队列的数据,出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的,没有数据~~~");
        }
        // 这里需要分析出 front 是指向队列的第一个元素
// 1. 先把 front 对应的值保留到一个临时变量
// 2. 将 front 后移, 考虑取模
// 3. 将临时保存的变量返回

        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void list() {
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        System.out.println("数据有效个数是: " + size());
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);

        }
    }

    //获取环形队列的有效数据个数
    private int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据,不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的,没有数据~~~");
        }
        return arr[front];
    }
}

