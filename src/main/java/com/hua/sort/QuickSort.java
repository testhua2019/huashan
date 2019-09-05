package com.hua.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

//快速排序
public class QuickSort {
    public static void main(String[] args) {
        //int[] arr = {-9, 78, 0, 23, -567, 70};
        //System.out.println("原数组: " + Arrays.toString(arr));
        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);

        quickSort(arr, 0, arr.length - 1);
        //Arrays.sort(arr);

        Date date1 = new Date();
        String format1 = simpleDateFormat.format(date1);
        System.out.println(format1);
        //System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;   //左下标
        int r = right;  //右下标
        //pivot 中轴值
        int pivot = arr[(right + left) / 2];
        int temp;   //临时变量,交换是用
        //while 的目的是让比pivot 值小的放在左,比大的放在右
        while (r > l) {
            while (arr[l] < pivot) {    //在pivot的左一直找,直到找到 大于等于 pivot 的值
                l += 1;
            }
            while (arr[r] > pivot) {    //在pivot的右一直找,直到找到 小于等于 pivot 的值
                r -= 1;
            }
            //如果 l >= r 说明 pivot 的左右两的值，已经按照左边全部是
            //小于等于 pivot 值，右边全部是大于等于 pivot 值
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个 arr[l] == pivot 值 相等 r--， 前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个 arr[r] == pivot 值 相等 l++， 后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        // 如果 l == r, 必须 l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (r > left) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}

