package com.hua.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//希尔排序
public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        shellSort2(arr);
        Date date1 = new Date();
        String format1 = simpleDateFormat.format(date1);
        System.out.println(format1);
    }

    //希尔排序移位式
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int val = arr[j];
                if (val < arr[j - gap]) {
                    while (j - gap >= 0 && val < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j = j - gap;
                    }
                    arr[j] = val;
                }
            }
            //System.out.println(Arrays.toString(arr));
        }
    }

    //希尔排序交换式的实现
    public static void shellSort(int[] arr) {
        int temp;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素(共 gap 组，每组有个元素), 步长 gap
                for (int j = i - gap; j >= 0; j = j - gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));

        }
//        System.out.println(Arrays.toString(arr));

        /*
        //第1轮
        // 因为第 1 轮排序，是将 10 个数据分成了 5 组
        for (int i = 5; i < arr.length; i++) {
        // 遍历各组中所有的元素(共 5 组，每组有 2 个元素), 步长 5
            for (int j = i - 5; j >= 0; j = j - 5) {
            // 如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        //第2轮
        // 因为第 2 轮排序，是将 10 个数据分成了 5/2 = 2 组
        for (int i = 2; i < arr.length; i++) {
// 遍历各组中所有的元素(共 2 组，每组有 5 个元素), 步长 2
            for (int j = i - 2; j >= 0; j -= 2) {
// 如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));


        //第3轮
        for (int i = 1; i < arr.length; i++) {
// 遍历各组中所有的元素(共 1 组，每组有 10 个元素), 步长 1
            for (int j = i - 1; j >= 0; j -= 1) {
// 如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
            */
    }
}
