package com.hua.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//插入 排序
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1};
//        System.out.println("原数组");
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*80000000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));
        insertSort(arr);
        Date date1 = new Date();
        System.out.println(simpleDateFormat.format(date));
        System.out.println(arr.length);
    }

    //插入排序
    //指定第一个确定
    public static void insertSort(int[] arr) {
        int val;
        int index;
        for (int i = 1; i < arr.length; i++) {
            val = arr[i];   //保存待插入的数
            index = i - 1;    //指向待插入的数的前一个数的索引
            // 给 Val 找到插入的位置
            // 说明
            // 1. Index >= 0 保证在给 Val 找插入位置，不越界
            // 2. Val < arr[Index] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[Index] 后移
            while (index >= 0 && val < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            // 当退出 while 循环时，说明插入的位置找到, insertIndex + 1
            if (index+1 != i) {
                arr[index + 1] = val;
            }
//            System.out.println("第" + i + "轮");
//            System.out.println(Arrays.toString(arr));
        }
        /*
        //第1轮
        int val = arr[1];   //保存待插入的数
        int index = 1 - 1;    //指向待插入的数的前一个数的索引
        while (index >= 0 && val < arr[index]) {
            arr[index + 1] = arr[index];
            index--;
        }
        arr[index + 1] = val;

        System.out.println("第1轮");
        System.out.println(Arrays.toString(arr));
        //第2轮
        val = arr[2];   //保存待插入的数
        index = 2 - 1;    //指向待插入的数的前一个数的索引
        while (index >= 0 && val < arr[index]) {
            arr[index + 1] = arr[index];
            index--;
        }
        arr[index + 1] = val;

        System.out.println("第2轮");
        System.out.println(Arrays.toString(arr));
        //第3轮
        val = arr[3];   //保存待插入的数
        index = 3 - 1;    //指向待插入的数的前一个数的索引
        while (index >= 0 && val < arr[index]) {
            arr[index + 1] = arr[index];
            index--;
        }
        arr[index + 1] = val;

        System.out.println("第3轮");
        System.out.println(Arrays.toString(arr));
        */
    }
}
