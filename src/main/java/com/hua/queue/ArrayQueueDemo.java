package com.hua.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试队列
        ArrayQueue queue = new ArrayQueue(3);
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

//使用数组实现队列
class ArrayQueue {
    private int maxSize;    //队列的最大容量
    private int front;  //队列的前标,第一个元素前一个的位置
    private int rear;   //队列的下标,最后一个元素的位置
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = -1; // 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
        rear = -1;  // 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
        arr = new int[this.maxSize];
    }

    //判断队列是否满
    public boolean isFull() {
        return maxSize - 1 == rear;
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
        rear++;
        arr[rear] = n;
    }

    //获取队列的数据,出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的,没有数据~~~");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void list() {
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);

        }
    }

    //显示队列的头数据,不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的,没有数据~~~");
        }
        return arr[front + 1];
    }

}
