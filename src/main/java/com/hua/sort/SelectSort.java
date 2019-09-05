package com.hua.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

//选择排序的实现
public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {34, 103, 81, 123, 1};
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
//        System.out.println("原数组");
//        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        Date date1 = new Date();
        String format1 = simpleDateFormat.format(date1);
        System.out.println(format1);
//        System.out.println("现数组");
//        System.out.println(Arrays.toString(arr));


    }

    //选择排序

    /**
     * 将数组从小到大排,速度比冒泡排序快
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        //选择排序  从小到大排
        //简化+优化     时间复杂度为 O(n^2)
        int minIndex;
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            min = arr[i];   //假定arr[i]是最小的数
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) { // > 是从小到大排 | < 则是从大到小排
                    minIndex = j;
                    min = arr[j];   //比较后发现有跟小的数,则替换min的值
                }
            }
            if (min != arr[i]) {    //如果假定的数就是最小的数,不进行换位
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
//            System.out.println("第" + (i + 1) + "轮排序后的数组");
//            System.out.println(Arrays.toString(arr));
        }
       /*
        //第1轮
        int minIndex = 0;
        int min = arr[0];
        for (int j = 0 + 1; j < arr.length; j++) {
            if (min > arr[j]) {
                minIndex = j;
                min = arr[j];
            }
        }
        arr[minIndex] = arr[0];
        arr[0] = min;
//第2轮
        minIndex = 1;
        min = arr[1];
        for (int j = 1 + 1; j < arr.length; j++) {
            if (min > arr[j]) {
                minIndex = j;
                min = arr[j];
            }
        }
        arr[minIndex] = arr[1];
        arr[1] = min;

//第3轮
        minIndex = 2;
        min = arr[2];
        for (int j = 2 + 1; j < arr.length; j++) {
            if (min > arr[j]) {
                minIndex = j;
                min = arr[j];
            }
        }
        arr[minIndex] = arr[2];
        arr[2] = min;
//第4轮
        minIndex = 3;
        min = arr[3];
        for (int j = 3 + 1; j < arr.length; j++) {
            if (min > arr[j]) {
                minIndex = j;
                min = arr[j];
            }
        }
        arr[minIndex] = arr[3];
        arr[3] = min;
        */
    }
}
