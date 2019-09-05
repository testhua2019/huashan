package com.hua.search;

import java.util.ArrayList;
import java.util.List;

//注意：使用二分查找的前提是 该数组是有序的.
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 7, 7, 7, 55, 77, 1234};
//        int i = binarySearch(arr, 0, arr.length - 1, 1);
//        if (i == -1) {
//            System.out.println("没有找到值");
//        } else {
//            System.out.println("查找到的索引是: " + i);
//        }

        System.out.println(arr);
        List<Integer> list = binarySearch2(arr, 0, arr.length - 1, 7);
        System.out.println("索引是: " + list);
    }

    //默认 arr 是从小到大排序

    /**
     * @param arr   数组
     * @param left  左索引
     * @param right 右索引
     * @param value 查找的值
     * @return 找到返回索引, 没有找到返回 -1
     */
    public static int binarySearch(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (left > right) {
            return -1;
        }

        if (value > midVal) {
            //向右
            return binarySearch(arr, mid + 1, right, value);
        } else if (value < midVal) {
            //向左
            return binarySearch(arr, left, mid - 1, value);
        } else {
            return mid;
        }
    }

    //二分增强,找到多个索引值

    /**
     * 思路分析
     * 1. 在找到 mid 索引值，不要马上返回
     * 2. 向 mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合 ArrayList
     * 3. 向 mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合 ArrayList
     * 4. 将 Arraylist 返回
     */
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        List<Integer> list = new ArrayList<Integer>();

        if (left > right) {
            return list;
        }

        if (value > midVal) {
            //向右
            return binarySearch2(arr, mid + 1, right, value);
        } else if (value < midVal) {
            //向左
            return binarySearch2(arr, left, mid - 1, value);
        } else {
            int temp = mid - 1;
            while (temp >= 0) {
                if (arr[temp] == value) {
                    list.add(temp);
                    temp--;
                } else {
                    break;
                }
            }
            list.add(mid);

            temp = mid + 1;
            while (temp <= arr.length - 1) {
                if (arr[temp] == value) {
                    list.add(temp);
                    temp++;
                } else {
                    break;
                }
            }
            return list;
        }
    }
}
