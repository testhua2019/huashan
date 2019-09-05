package com.hua.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

//冒泡排序
public class BubbleSort {
    public static void main(String[] args) {
//        int arr[] = {3, 9, -1, 10, 20};
//        System.out.println("原数组");
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Format = simpleDateFormat.format(date1);
        System.out.println(date1Format);
        bubbleSort(arr);
        Date date2 = new Date();
        String date2Format = simpleDateFormat.format(date2);
        System.out.println(date2Format);



        /*
        //第二波
        for (int i = 0; i < arr.length - 1 - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第二步数组");
        System.out.println(Arrays.toString(arr));

        //第三波
        for (int i = 0; i < arr.length - 1 - 2; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第三步数组");
        System.out.println(Arrays.toString(arr));

        //第四波
        for (int i = 0; i < arr.length - 1 - 3; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第四步数组");
        System.out.println(Arrays.toString(arr));
        */
    }

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        int temp;//存放数据的临时变量
        boolean flag = false;//是否进行了交换操作
        //简化: 冒泡排序的时间复杂度为 O(n^2)
        for (int j = 0; j < arr.length - 1; j++) {
            //0,1,2,3 j<4
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
//            System.out.println("第" + (j + 1) + "步数组");
//            System.out.println(Arrays.toString(arr));

            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }
}
