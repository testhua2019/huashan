package com.hua.recursion;

import java.util.concurrent.CountDownLatch;

public class Queen8 {
    int max = 8;
    int[] arr = new int[max];
static  int count = 0;
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println(count);
    }

    public void check(int n) {
        if (n == max) {//n = 8 , 其实 8 个皇后就既然放好
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }
    //查看当我们放置第 n 个皇后, 就去检测该皇后是否和前面已经摆放的皇后冲突

    /**
     * @param n 表示第 n 个皇后
     * @return
     */
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        count++;
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
